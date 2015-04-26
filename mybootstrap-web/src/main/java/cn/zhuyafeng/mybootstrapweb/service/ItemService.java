package cn.zhuyafeng.mybootstrapweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import cn.zhuyafeng.mybootstrapweb.pojo.Item;
import cn.zhuyafeng.mybootstrapweb.utils.HttpClientConnection;
import cn.zhuyafeng.mybootstrapweb.utils.MyByteArray;
@Service
@SuppressWarnings("unchecked")
public class ItemService {

    @Autowired
    private Jedis jedis ;
    
    @Autowired
    private HttpSolrServer httpSolrServer;
    
    private final static  Logger LOGGER = LoggerFactory.getLogger(ItemService.class);
    
    private String itemKey = "ItemKey";
    public Map<String, Object> queryPageItem() {
        
        byte[] bs = jedis.get(itemKey.getBytes());
        if(bs!=null){
            return MyByteArray.getObject(bs);
        }
        Map<String, Object> pageItem = HttpClientConnection.doGet("http://manage.taotao.com/views/item/queryPageItem");
        byte[] byteArray = MyByteArray.getByteArray(pageItem);
        jedis.set(itemKey.getBytes(), byteArray);
        return pageItem;
    }
    
    public  Map<String, Object>  queryLikeItem(String likeItemKey) {
       
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(likeItemKey);
        try {
            QueryResponse response = httpSolrServer.query(solrQuery);
                List<Item> item = response.getBeans(Item.class);
             if(!item.isEmpty()){
              Map<String, Object> map = new HashMap<String, Object>();
                map.put("item", item);
                return map;
            }
        } catch (SolrServerException e1) {
            LOGGER.error("查询收索数据出错"+e1);
        }    
            
        
        Map<String, Object> likeItem =  HttpClientConnection.doGet("http://manage.taotao.com/views/item/queryLikeItem?name="+likeItemKey);
            try {
                 JSONArray jsonArray = JSONArray.fromObject(likeItem.get("item"));
                List <Item>list = new ArrayList<Item>();  
                for (int i = 0; i < jsonArray.size(); i++) 
                {           
                    list.add((Item) JSONObject.toBean(jsonArray.getJSONObject(i), Item.class, new HashMap<String, Item>()));  
                } 
                
                httpSolrServer.addBeans(list);
                httpSolrServer.commit();
                
                    return likeItem;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                LOGGER.error("添加收索数据出错:"+e);
                
            }
            return likeItem;
    }

}
