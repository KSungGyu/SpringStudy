package kr.bit.entity;

import lombok.Data;

@Data
public class Board {
	private int idx; // ��ȣ
	  private String memID; // ȸ��ID
	  private String title; // ����
	  private String content; // ����
	  private String writer; // �ۼ���
	  private String indate; // �ۼ���
	  private int count; // ��ȸ��
	  private int boardGroup; // �θ�۰� ����� ���� ����
	  private int boardSequence; // ����� ����
	  private int boardLevel; // ����� ����(�鿩����)
	  private int boardAvailable; // ������ ������ ����
}
