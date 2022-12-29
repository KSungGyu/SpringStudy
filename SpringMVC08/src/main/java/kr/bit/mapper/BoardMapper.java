package kr.bit.mapper;

import java.util.List;

import kr.bit.entity.Board;
import kr.bit.entity.Member;

//@Mapper
public interface BoardMapper {
	public List<Board> getList();
	public void insert(Board vo);
	public void insertSelectKey(Board vo);
	public Member login(Member vo); // SQL
	public Board read(int idx);
	public void update(Board vo);
	public void delete(int idx);
	public void replySeqUpdate(Board parent);
	public void replyInsert(Board vo);
}