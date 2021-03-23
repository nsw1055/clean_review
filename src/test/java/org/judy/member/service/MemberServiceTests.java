package org.judy.member.service;

import org.judy.common.CommonConfig;
import org.judy.member.config.MemberConfig;
import org.judy.time.config.TimeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class, MemberConfig.class , TimeConfig.class})
@Log4j
public class MemberServiceTests {

	@Autowired
	private MemberService service;
	
	@Test
	public void getMemberTest() {
		
		log.info("------------");
		log.info(service);
		log.info(service.getMemberList());
	}
	
	
}
