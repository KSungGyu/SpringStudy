package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.entity.Member;
import kr.bit.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<Board> getList() {
		// �ݿ��� ����~~~
		List<Board> list=boardMapper.getList();
		
		return list;
	}

	@Override
	public Member login(Member vo) {
		Member mvo=boardMapper.login(vo);
		return mvo;
	}

	@Override
	public void register(Board vo) {
		boardMapper.insertSelectKey(vo);
		
	}

	@Override
	public Board get(int idx) {
		Board vo=boardMapper.read(idx);
		return vo;
	}

	@Override
	public void modify(Board vo) {
		boardMapper.update(vo);
	}

	@Override
	public void remove(int idx) {
		boardMapper.delete(idx);
	}

	@Override
	public void replyProcess(Board vo) {
		// - ��۸����
		// 1. �θ��(����)�� ������ ��������(vo->idx)
		Board parent=boardMapper.read(vo.getIdx());
		// 2. �θ���� boardGroup�� ����->���(vo)������ �����ϱ�
		vo.setBoardGroup(parent.getBoardGroup());
		// 3. �θ���� boardSequence�� ���� +1 �ؼ� ->���(vo)������ �����ϱ�
		vo.setBoardSequence(parent.getBoardSequence()+1);
		// 4. �θ���� boardLevel�� ���� +1 �ؼ� ->���(vo)������ �����ϱ�
		vo.setBoardLevel(parent.getBoardLevel()+1);
		// 5. ���� boardGroup�� �ִ� �� �߿��� 
		// 	  �θ���� boardSequence���� ū ������ ��� 1�� ������Ʈ
		boardMapper.replySeqUpdate(parent);
		// 6. ���(vo)�� DB�� �����ϱ�
		boardMapper.replyInsert(vo);
	}
	

}
