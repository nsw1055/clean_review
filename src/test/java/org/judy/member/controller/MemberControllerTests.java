package org.judy.member.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.judy.common.CommonConfig;
import org.judy.common.ServletConfig;
import org.judy.member.config.MemberConfig;
import org.judy.member.mapper.MemberMapper;
import org.judy.time.config.TimeConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class, ServletConfig.class, MemberConfig.class , TimeConfig.class})
@Log4j
@WebAppConfiguration
public class MemberControllerTests {

	
	@Autowired
	WebApplicationContext ctx;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	
	@Test
	public void testController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/member/list")).andDo(print());
	}
}
