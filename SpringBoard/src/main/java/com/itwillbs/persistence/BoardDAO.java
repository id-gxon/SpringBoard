package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

/**
 * Service - MyBatis(mapper) 연결 객체
 * 
 * Query 호출
 */
public interface BoardDAO {

	// register
	public void boardCreate(BoardVO vo) throws Exception;

	// list
	public List<BoardVO> boardListSelect() throws Exception;
}
