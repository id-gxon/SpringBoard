package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
		logger.debug("getList() 실행 -> getList Method 호출");

		return bdao.boardListSelect();
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		logger.debug("read() 실행 -> read Method 호출");

		return bdao.boardSelect(bno);
	}

	@Override
	public void updateViewcnt(Integer bno) throws Exception {
		logger.debug("updateViewcnt(Integer bno) 실행 -> updateViewcnt Method 호출");

		bdao.viewcntUpdate(bno);

		logger.debug("Service 동작 완료 -> Controller 이동");
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		logger.debug("modify(BoardVO vo) 실행 -> modify Method 호출");

		bdao.boardUpdate(vo);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		logger.debug("remove(Integer bno) 실행 -> remove Method 호출");

		bdao.boardDelete(bno);
	}

}
