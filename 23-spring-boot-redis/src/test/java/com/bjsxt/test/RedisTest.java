package com.bjsxt.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
/**
 * 测试类
 * @author mac1094
 *
 */
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.App;
import com.bjsxt.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {
    @Resource
	private RedisTemplate<String,Object> redisTemplate;
    
    @Test
    public void testSet() {
    	this.redisTemplate.opsForValue().set("key","雷康来自湖北");
    }
    //获取一个字符串
    @Test
    public void testGet() {
    	String value = (String) this.redisTemplate.opsForValue().get("key");
    	System.out.println(value);
    }
    
    /**
     * 添加users对象
     */
    @Test
    public void testSetUsers() {
    	Users users = new Users();
    	users.setId(1);
    	users.setName("雷康");
    	users.setAge(23);
    	this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    	this.redisTemplate.opsForValue().set("users",users);
    }
    /**
     * 	取users对象
     */
    @Test
    public void testGetUsers() {
    	this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    	Users users = (Users) this.redisTemplate.opsForValue().get("users");
    	System.out.println(users);
    }
    /**
     * 基于JSON格式存储对象
     */
    @Test
    public void testSetUsersJson() {
    	Users  users = new Users();
    	users.setId(1);
    	users.setName("张三");
    	users.setAge(29);
    	this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
    	this.redisTemplate.opsForValue().set("users",users);
    	
    }
    /**
     * 	取出JSON对象
     */
    @Test
    public void testGetUserJson() {
    	this.redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
    	Users user = (Users) this.redisTemplate.opsForValue().get("users");
    	System.out.println(user);
    }
}
