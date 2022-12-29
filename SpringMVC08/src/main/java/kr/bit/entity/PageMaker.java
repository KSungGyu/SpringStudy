package kr.bit.entity;

public class PageMaker {
	private Criteria cri;
	private int totalCount; // 총게시글의 수
	private int startPage; // 시작페이지번호
	private int endPage; // 끝페이지번호(조정이 되어야 함)
	private boolean prev; // 이전버튼(true, false)
	private boolean next; // 다음버튼(true, false)
	private int displayPageNum=10; // 1 2 3 4 5 6 7 8 9 10, 하단 페이지 개수
}
