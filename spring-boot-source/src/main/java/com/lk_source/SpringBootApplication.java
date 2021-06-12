package com.lk_source;

 // import org.springframework.boot.SpringBootConfiguration;
 // import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
 // import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.annotation.AliasFor;

/**
*@author leikang
*@version :2021年6月12日下午4:11:27
*该接口是SpringApplication的底层解释
*/
@SpringBootConfiguration
@EnableAutoConfiguration
/**
 * 两个注解是核心重点，起到启动作用。再次深入两个注解的源码
 * @author mac1094
 *
 */
public @interface SpringBootApplication {
	/**
	 * 排除特定的自动配置类，以便它们永远不会被应用。
	 * @return the classes to exclude
	 */
	@AliasFor(annotation = EnableAutoConfiguration.class)
	// 所有的类能通过继承
	Class<?>[] exclude() default {};

	/**
	 * 
	 * applied.
	 * @return the class names to exclude
	 * @since 1.3.0
	 */
	@AliasFor(annotation = EnableAutoConfiguration.class)
	String[] excludeName() default {};

	/**
	 *用于扫描带注释组件的基本包。 使用 {@link #scanBasePackageClasses}
     *  用于基于字符串的包名称的类型安全替代方案。
	 * @return base packages to scan
	 * @since 1.3.0
	 */
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
	String[] scanBasePackages() default {};

	/**
	 * 扫描所有的包的数组
	 * @return base packages to scan
	 * @since 1.3.0
	 */
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackageClasses")
	Class<?>[] scanBasePackageClasses() default {};

}
