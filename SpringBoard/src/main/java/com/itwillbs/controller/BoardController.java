package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService bService;

	// http://localhost:8088/board/register
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.debug("/board/register -> registerGET() 호출");
		logger.debug("/board/register.jsp View 연결");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo) throws Exception {
		logger.debug("/board/register.jsp (submit) -> registerPOST() 호출");

		// 전달 정보 저장
		logger.debug("vo: " + vo);

		// service -> DAO register Method 호출
		bService.regist(vo);

		logger.debug("글 쓰기 완료 -> list.jsp로 이동");

		// 페이지 이동
		return "redirect:/board/list";
	}

	// http://localhost:8088/board/list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(Model model) throws Exception {
		logger.debug("/board/list -> listGET() 호출");
		logger.debug("/board/list.jsp View 연결");

		// Service -> DAO 게시판 글 목록 가져오기
		List<BoardVO> boardList = bService.getList();
		logger.debug("list.size:" + boardList.size());

		// 연결된 뷰에 정보 전달
		model.addAttribute(boardList);
	}

}
