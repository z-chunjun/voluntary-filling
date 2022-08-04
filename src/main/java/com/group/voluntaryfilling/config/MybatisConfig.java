package com.group.voluntaryfilling.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 配置mybatis扫描文件
 */
@ComponentScan
@Configuration
@MapperScan("com.group.voluntaryfilling.mapper")
public class MybatisConfig {
}
