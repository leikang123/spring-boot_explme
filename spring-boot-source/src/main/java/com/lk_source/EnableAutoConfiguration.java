package com.lk_source;

import java.lang.annotation.Inherited;

import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Import;

/**
*@author leikang
*@version :2021年6月12日下午4:40:11
*此注解的作用是用于自动配置，自动引入jar包。
*/


	@Inherited
	@AutoConfigurationPackage
	@Import(AutoConfigurationImportSelector.class)
	public @interface EnableAutoConfiguration {

		String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

		Class<?>[] exclude() default {};

		String[] excludeName() default {};


}
