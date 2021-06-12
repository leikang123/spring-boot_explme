package com.lk_source;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;

/**
*@author leikang
*@version :2021年6月12日下午4:35:22
*此注解的作用：
*1.注解所标识的类，作为配资类
*2.注解所标识的类，用于纳入IOC容器中
*/

@Documented
@Configuration
public @interface SpringBootConfiguration {

}
