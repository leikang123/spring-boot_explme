package com.lk;

import org.springframework.boot.SpringApplication;


import com.lk_source.SpringBootApplication;

/**
*@author leikang
*@version :2021年6月12日下午4:02:34
*
*/
// 该注解是启动类的唯一关键，是一种接口型
@SpringBootApplication
public class App {
public static void main(String[] args) {
	// SpringApplication的底层源码
	SpringApplication.run(App.class,args);
}
}
