package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DataSourceTest {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceTest.class);

	// DB 연결 정보 저장 객체
	@Inject
	private DataSource ds;

	@Test
	public void 테스트() throws SQLException {
		logger.debug("ds: " + ds);

		Connection con = ds.getConnection();
		logger.debug("con: " + con);
	}
}