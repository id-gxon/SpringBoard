package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Inject
	private BoardDAO bdao;

	@Override
	public void regist(BoardVO vo) throws Exception {
		logger.debug("regist(BoardVO vo) 실행 -> register Method 호출");

		bdao.boardCreate(vo);

		logger.debug("Service 동작 완료 -> Controller 이동");
	}

	@Override
	public List<BoardVO> getList() throws Exception {
		logger.debug("list() 실행 -> list Method 호출");

		return bdao.boardListSelect();
	}

}
