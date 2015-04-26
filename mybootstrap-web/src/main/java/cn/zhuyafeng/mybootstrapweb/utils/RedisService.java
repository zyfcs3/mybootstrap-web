package cn.zhuyafeng.mybootstrapweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisService {
    
    @Autowired
    private static JedisPool jedisPool ;
    
    public static Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

}
