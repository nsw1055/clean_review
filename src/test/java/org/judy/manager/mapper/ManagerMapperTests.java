package org.judy.manager.mapper;

import org.judy.common.CommonConfig;
import org.judy.manager.config.ManagerConfig;
import org.judy.time.config.TimeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class, ManagerConfig.class , TimeConfig.class})
@Log4j
public class ManagerMapperTests {

	@Autowired
	private ManagerMapper mapper;
	
	@Test
	public void testGetMemberList() {
		log.info("12312312");
		log.info(mapper.getMemberList());
	}
	
	@Test
	public void testSelectOne() {
		log.info(mapper.selectOne("테스트1"));
	}
}
