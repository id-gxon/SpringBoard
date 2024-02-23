package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	@Inject
	SqlSession sqlSession;

	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";

	@Override
	public void boardCreate(BoardVO vo) throws Exception {
		logger.debug("boardCreate(BoardVO vo) 실행 -> DAO register Method 호출");

		sqlSession.insert(NAMESPACE + ".createBoard", vo);

		logger.debug("mapper 실행 완료 -> Service 이동");
	}

	@Override
	public List<BoardVO> boardListSelect() throws Exception {

		return sqlSession.selectList(NAMESPACE + ".selectBoardList");
	}

}
