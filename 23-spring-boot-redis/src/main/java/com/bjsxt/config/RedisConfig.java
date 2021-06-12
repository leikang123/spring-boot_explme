package com.bjsxt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 完成对redis的整合的一些配置
 * @author mac1094
 *
 */
@Configurable
public class RedisConfig {
	/**
	 * 1.创建JEDISPOOLCONFIG对象，在该对象完成一些连接配置池
	 */
	@Bean
	@ConfigurationProperties(prefix="aaa.bbb")
 public JedisPoolConfig jedisPoolconfig() {
	 JedisPoolConfig config = new JedisPoolConfig();
	 
	/* // 最大空闲数
	 config.setMaxIdle(10);
	 // 最小空闲数
	 config.setMinIdle(20);
	 // 最大连接数
	  **/
	 config.setMaxTotal(20);
	 System.out.println("默认值:"+config.getMaxIdle());
	 System.out.println("默认值:"+config.getMinIdle());
	 System.out.println("默认值:"+config.getMaxTotal());
	return config;
	 
 }
 /**
  * 2.创建JedisConnectionFactory配置redis连接信息
  */
	@Bean
 public JedisConnectionFactory jedisCOnnectionFactory(JedisPoolConfig config) {

	 System.out.println("配置完毕:"+config.getMaxIdle());
	 System.out.println("配置完毕:"+config.getMinIdle());
	 System.out.println("配置完毕:"+config.getMaxTotal());
	 
	 JedisConnectionFactory factory = new JedisConnectionFactory();
	 // 关联连接池的配置对象
	 factory.setPoolConfig(config);
	 //配置连接Redis的信息
	 // 主机地址
	 factory.setHostName("192.168.70.128");
	 // 端口
	 factory.setPort(6379);
	return factory;
	 
 }
 /**
  * 3.创建RedisTemplate:用于执行Redis 操作方法
  */
 
 @Bean
 public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory factory){
	 RedisTemplate<String,Object> template = new RedisTemplate<>();
	  // 关联
	 template.setConnectionFactory(factory);
	 //为key设置序列化
	 template.setKeySerializer(new StringRedisSerializer());
	 // 为value设置序列化器
	 template.setValueSerializer(new StringRedisSerializer());
	 
	  return template;
	 
 }
}
