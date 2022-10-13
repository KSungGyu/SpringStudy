package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController{
	
	@Autowired
	BoardMapper boardMapper;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	// @ResponseBody -> jackson-databind(��ü��->JSON �������������� ��ȯ)
	@RequestMapping("/boardList.do")
	public @ResponseBody List<Board> boardList(){
		List<Board> list=boardMapper.getLists();
		return list; // JSON ������ �������� ��ȯ(API)�ؼ� �����Ѵ�.
	}
	
	@RequestMapping("/boardInsert.do")
	public @ResponseBody void boardInsert(Board vo) {
		boardMapper.boardInsert(vo); //��� ����
	}
	
	@RequestMapping("/boardDelete.do")
	public @ResponseBody void boardDelete(@RequestParam("idx") int idx) {
		boardMapper.boardDelete(idx);
	}
	
	@RequestMapping("/boardUpdate.do")
	public @ResponseBody void boardUpdate(Board vo) {
		boardMapper.boardUpdate(vo);
	}
	@RequestMapping("/boardContent.do")
	public @ResponseBody Board boardContent(int idx) {
		Board vo=boardMapper.boardContent(idx);
		return vo; // vo => JSON
	}
	@RequestMapping("/boardCount.do")
	public @ResponseBody Board boardCount(int idx) {
		boardMapper.boardCount(idx);
		Board vo=boardMapper.boardContent(idx);
		return vo;
	}
}
