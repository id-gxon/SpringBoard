package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

/**
 * Service: Controller - DAO 연결 역할
 * 
 * Controller가 외부 호출에 종속적인 상황을 방지
 */
public interface BoardService {

	// register
	public void regist(BoardVO vo) throws Exception;

	// getBoardList
	public List<BoardVO> getList() throws Exception;

	// getBoard
	public BoardVO getBoard(Integer bno) throws Exception;
}
