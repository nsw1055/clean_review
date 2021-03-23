package org.judy.member.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "org.judy.member.mapper")
@ComponentScan(basePackages = "org.judy.member.service")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class MemberConfig {

}
