package cn.zhuyafeng.mybootstrapweb.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RabbitmqListener {
	
	@Autowired
	private  JedisPool jedisPool;
	
	public void listener (Long id){
		Jedis jedis = jedisPool.getResource();
		jedis.del("ItemKey".getBytes());
		System.out.println(id);
	}

}
