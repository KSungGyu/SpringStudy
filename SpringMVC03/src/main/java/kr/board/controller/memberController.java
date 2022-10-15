package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class memberController {

	@RequestMapping("/memJoin.do")
	public String memJoin() {
		return "member/join";
	}
}
