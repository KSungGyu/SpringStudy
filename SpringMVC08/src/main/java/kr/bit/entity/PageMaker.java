package kr.bit.entity;

public class PageMaker {
	private Criteria cri;
	private int totalCount; // �ѰԽñ��� ��
	private int startPage; // ������������ȣ
	private int endPage; // ����������ȣ(������ �Ǿ�� ��)
	private boolean prev; // ������ư(true, false)
	private boolean next; // ������ư(true, false)
	private int displayPageNum=10; // 1 2 3 4 5 6 7 8 9 10, �ϴ� ������ ����
}
