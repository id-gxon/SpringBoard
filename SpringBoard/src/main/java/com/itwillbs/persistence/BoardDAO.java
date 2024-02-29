package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

/**
 * Service - MyBatis(mapper) 연결 객체
 * 
 * Query 호출
 */
public interface BoardDAO {

	// registerBoard
	public void boardCreate(BoardVO vo) throws Exception;

	// selectBoardList
	public List<BoardVO> boardListSelect() throws Exception;

	// selectBoard
	public BoardVO boardSelect(Integer bno) throws Exception;

	// updateViewcnt
	public void viewcntUpdate(Integer bno) throws Exception;

	//updateBoard
	public void boardUpdate(BoardVO vo) throws Exception;

	//deleteBoard
	public void boardDelete(Integer bno) throws Exception;
}
