package kr.bit.mapper;

import java.util.List;

import kr.bit.entity.Board;

//@Mapper
public interface BoardMapper {
	public List<Board> getList();
	public void insert(Board vo);
	public void insertSelectKey(Board vo);
}
