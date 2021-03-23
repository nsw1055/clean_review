package org.judy.member.mapper;

import org.judy.common.CommonConfig;
import org.judy.common.ServletConfig;
import org.judy.member.config.MemberConfig;
import org.judy.member.controller.MemberControllerTests;
import org.judy.time.config.TimeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class, MemberConfig.class , TimeConfig.class})
@Log4j
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testGetMemberList() {
		log.info("12312312");
		log.info(mapper.getMemberList());
	}
}
