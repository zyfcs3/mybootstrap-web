package cn.zhuyafeng.mybootstrapweb.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool.impl.GenericObjectPool.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedisPool;
import cn.zhuyafeng.mybootstrapweb.utils.HttpClientConnection;
import cn.zhuyafeng.mybootstrapweb.utils.RedisService;

@Service
public class ItemCatService {
    
   
    @Autowired
    private Jedis jedis ;
    
    private String itemCatKey = "ItemCatKey";
    
    public String queryItemCatALL() {
        String key = jedis.get(itemCatKey);
      if(StringUtils.isNotBlank(key)){
          return key;
      }
        Map<String, Object> itemCats = HttpClientConnection.doGet("http://manage.taotao.com/views/itemCat/itemCatAll");
        String liItemCat = (String)itemCats.get("liItemCat");
        jedis.set(itemCatKey, liItemCat);
        
      
        return liItemCat;
    }
    

}
