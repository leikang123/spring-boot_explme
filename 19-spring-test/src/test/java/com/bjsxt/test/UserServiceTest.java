package com.bjsxt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * spring boot测试类
 * @author mac1094
 *@RunWith  启动器
 *SpringJUnit4ClassRunner.class;让Junit与spring坏境进行整合
 *@SpringBootTest(classes= {App.class})1.当前类为Springboot的测试类
 *2.加载Springboot启动类，启动Springboot。
 *junit与Spring整合@Contextfiguration("classpath:applicationContext.xml")
 */

import com.bjsxt.App;
import com.bjsxt.service.UserServiceIm;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {App.class})
public class UserServiceTest {
	@Autowired
	private UserServiceIm userServiceIm;
	@Test
	public void testAddUser() {
		this.userServiceIm.addUser();
		
	}

}
