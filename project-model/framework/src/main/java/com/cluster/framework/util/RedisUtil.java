package com.cluster.framework.util;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * Redis操作工具类
 * @className RedisUtil.java
 * @author    liangdong.yao
 * @Date      2017年4月7日 下午3:03:48
 * @version   1.0
 */
@Component
public class RedisUtil {

	@Autowired
	private RedisTemplate<Serializable,Object> redisTemplate;
	
	public Object get(final String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}
	
	public <T>T get(final String key,Class<T> cls) {
		T result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		Object object = operations.get(key);
		if(null != object)
			result = new Gson().fromJson(object.toString(), cls);
		return result;
	}
	
	public boolean set(final String key, Object value) {
		return set(key, value, null);
	}
	
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			String jsonStr = new Gson().toJson(value);
			operations.set(key, jsonStr);
			if(expireTime!=null){
				redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
