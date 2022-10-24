package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;
import kr.board.entity.Member;

@Mapper //- Mybatis API
public interface MemberMapper {	
	public Member registerCheck(String memID);
    public int register(Member m); //ȸ�����( 1, 0)
    public Member memLogin(Member mvo); // �α���üũ
}
