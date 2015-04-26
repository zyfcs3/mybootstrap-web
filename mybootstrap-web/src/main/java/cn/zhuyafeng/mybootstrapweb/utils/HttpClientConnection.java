package cn.zhuyafeng.mybootstrapweb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpClientConnection {

    private final static ObjectMapper mapper = new ObjectMapper();
    private final static Logger logger = LoggerFactory.getLogger(HttpClientConnection.class);
    
    public static Map<String,Object> doGet(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
                
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            
            HashMap <String,Object>map = mapper.readValue(entity.getContent(), HashMap.class);
            return map;
        }catch(Exception e){
            logger.error("httpcliet获取itemCat数据异常");
        }finally{
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("httpcliet关闭连接异常");
            }
        }
        
        return null;
    }
}
