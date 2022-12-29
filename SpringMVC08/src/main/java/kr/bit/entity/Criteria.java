package kr.bit.entity;

public class Criteria {
	private int page; // ���� ������ ��ȣ
	private int perPageNum; // ���������� ������ �Խñ��� ��
	public Criteria() {
		this.page=1;
		this.perPageNum=10;
	}
	// ���� �������� �Խñ��� ���۹�ȣ
	public int getPageStart() {      // 1page  2page  3page
		return (page-1)*perPageNum;  // 0~     10~    20~    : limit 0, 10
	}
}
