package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public void listGET(Model model, HttpSession session) throws Exception {
		logger.debug("/board/list -> listGET() 호출");
		logger.debug("/board/list.jsp View 연결");

		// Service -> DAO 게시판 글 목록 가져오기
		List<BoardVO> boardList = bService.getList();
		logger.debug("list.size:" + boardList.size());

		// 연결된 뷰에 정보 전달
		model.addAttribute(boardList);

		session.setAttribute("viewUpdateStatus", 1);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readGET(Model model, @RequestParam("bno") int bno, HttpSession session) throws Exception {
		logger.debug("/board/read -> readGET() 호출");
		logger.debug("/board/read.jsp View 연결");

		// 전달 정보 저장
		logger.debug("bno:" + bno);

		if (((Integer) session.getAttribute("viewUpdateStatus")).equals(1)) {
			session.setAttribute("viewUpdateStatus", 0);

			// Service -> DAO 게시판 글 조회수 1 증가
			bService.updateViewcnt(bno);
		}

		// Service -> DAO 게시판 글 조회 가져오기
		BoardVO bvo = bService.read(bno);

		// 해당 정보를 저장 -> 연결된 뷰로 전달
		model.addAttribute(bvo);
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(Model model, @RequestParam("bno") int bno) throws Exception {
		logger.debug("/board/modify -> modifyGET() 호출");
		logger.debug("/board/modify.jsp View 연결");

		// 전달 정보 저장(bno)
		logger.debug("bno: " + bno);

		// 연결된 뷰에 전달(Model)
		model.addAttribute(bService.read(bno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo) throws Exception {

		// 전달 정보 저장(bno, title, content, writer)
		logger.debug("BoardVO" + vo);

		// Service -> DAO 게시판 글 정보 수정
		bService.modify(vo);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno) throws Exception {

		// 전달 정보 저장(bno)
		logger.debug("bno: " + bno);

		// Service -> DAO 게시판 글 정보 삭제
		bService.remove(bno);

		return "redirect:/board/list";
	}

}
