package com.itwillbs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 페이징 처리 하단 블럭
public class PageVO {

	private static final Logger logger = LoggerFactory.getLogger(PageVO.class);

	private int pageBlock = 10; // 페이지 블럭 수

	private int totalCount; // 전체 글 개수
	private int startPage; // 블럭의 시작번호
	private int endPage; // 블럭의 끝번호

	private boolean prev; // 이전 버튼
	private boolean next; // 다음 버튼

	private Criteria cri;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		logger.debug("페이징 처리에 필요한 정보를 계산시작");

		pageCalc();

		logger.debug("페이징 처리에 필요한 정보를 계산완료");
	}

	public void pageCalc() {
		// endPage
		endPage = (int) Math.ceil(cri.getPage() / (double) pageBlock) * pageBlock;

		// startPage
		startPage = (endPage - pageBlock) + 1;

		// tmpEndPage (실제 endPage)
		int tmpEndPage = (int) Math.ceil(totalCount / (double) cri.getPageSize());

		// 글이 없음
		if (endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}

		// prev
		prev = startPage != 1;

		// next
		next = endPage * cri.getPageSize() < totalCount;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "pageVO [pageBlock=" + pageBlock + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", cri=" + cri + "]";
	}

}
