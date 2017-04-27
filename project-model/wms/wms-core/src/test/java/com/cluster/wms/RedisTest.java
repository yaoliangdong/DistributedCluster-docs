/*package com.cluster.wms;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {

	public static void testJedisSingle() {  
        //创建jedis对象  
        Jedis jedis = new Jedis("192.168.5.107", 6479);  
        jedis.auth("123456");
        //调用jedis对象的方法，方法名称和redis 的命令一致  
        jedis.set("test", "Jedis test");  
        String string = jedis.get("test");  
        System.out.println(string);  
        //关闭jedis  
        jedis.close();  
	}
	
	public static void test(){
		JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxTotal(20);  
        config.setMaxIdle(2);  
  
        HostAndPort hp0 = new HostAndPort("192.168.5.107", 6379);  
        HostAndPort hp1 = new HostAndPort("192.168.5.107", 6479);  
        HostAndPort hp2 = new HostAndPort("192.168.5.107", 6579);  
        HostAndPort hp3 = new HostAndPort("192.168.5.107", 6679);  
        HostAndPort hp4 = new HostAndPort("192.168.5.107", 6779);  
        HostAndPort hp5 = new HostAndPort("192.168.5.107", 6879);  
  
        Set<HostAndPort> hps = new HashSet<HostAndPort>();  
        hps.add(hp0);  
        hps.add(hp1);  
        hps.add(hp2);  
        hps.add(hp3);  
        hps.add(hp4);  
        hps.add(hp5);  
  
        // 超时，最大的转发数，最大链接数，最小链接数都会影响到集群  
        JedisCluster jedisCluster = new JedisCluster(hps, 5000,5000, 10,"123456", config);  
  
        long start = System.currentTimeMillis();  
        for (int i = 0; i < 100; i++) {  
            jedisCluster.set("sn" + i, "n" + i);  
        }  
        long end = System.currentTimeMillis();  
  
        System.out.println("Simple  @ Sharding Set : " + (end - start) / 10000);  
  
        for (int i = 0; i < 1000; i++) {  
            System.out.println(jedisCluster.get("sn" + i));  
        }  
  
        //jedisCluster.close();  
	}
	
	public static void testJedisCluster(){  
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();  
        nodes.add(new HostAndPort("192.168.5.107", 6379));  
        nodes.add(new HostAndPort("192.168.5.107", 6479));  
        nodes.add(new HostAndPort("192.168.5.107", 6579));  
        nodes.add(new HostAndPort("192.168.5.107", 6679));  
        nodes.add(new HostAndPort("192.168.5.107", 6779));  
        nodes.add(new HostAndPort("192.168.5.107", 6879));  
        JedisCluster cluster = new JedisCluster(nodes, 10000, 10000, 10, "123456", new GenericObjectPoolConfig());
        
        cluster.set("cluster", "JedisCluster test");  
        System.out.println(cluster.get("cluster"));  
    }

	public static void main(String[] args) {
		//RedisTest.testJedisSingle();
		RedisTest.testJedisCluster();
		//RedisTest.test();
	}
}
*/