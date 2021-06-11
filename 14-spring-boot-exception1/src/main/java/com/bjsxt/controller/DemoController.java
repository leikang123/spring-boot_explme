package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *spring boot 处理异常方式一，自定义错误页面
 * @author mac1094
 *
 */
@Controller
public class DemoController {
@RequestMapping("/show")
public String showInfo() {
	String str = null;
	str.length();
	return "index";
	
}
@RequestMapping("/show2")
public String showInfo2() {
	int a= 10/0;
	return "index";
	
}
}
