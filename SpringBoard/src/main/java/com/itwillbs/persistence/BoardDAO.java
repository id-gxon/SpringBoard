package com.itwillbs.persistence;

import com.itwillbs.domain.BoardVO;

/**
 * Service - MyBatis(mapper) 연결 객체
 * 
 * Query 호출
 */
public interface BoardDAO {

	// register
	public void boardCreate(BoardVO vo) throws Exception;

}
