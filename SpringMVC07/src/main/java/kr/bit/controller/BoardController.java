package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.bit.entity.Board;
import kr.bit.service.BoardService;

@Controller  // POJO
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String getList(Model model) {
		List<Board> list=boardService.getList();
		// ��ü���ε�
		model.addAttribute("list", list); // Model
		return "board/list"; // View
	}
	
	@GetMapping("/register")
	public String register() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(Board vo, RedirectAttributes rttr) { //�Ķ���� ����(vo) �� �ѱ����ڵ�
		boardService.register(vo);
		System.out.println(vo);
		rttr.addFlashAttribute("result", vo.getIdx()); // ${result}
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public String get(@RequestParam("idx") int idx, Model model) {
		Board vo=boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/get"; // /WEB-INF/views/board/get.jsp
	}
}
