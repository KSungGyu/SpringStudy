package kr.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@Controller
public class MemberController {

	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping("/memJoin.do")
	public String memJoin() {
		return "member/join";
	}
	
	@RequestMapping("/memRegisterCheck.do")
	public @ResponseBody int memRegisterCheck(@RequestParam("memID") String memID) {
		Member m=memberMapper.registerCheck(memID);
		if(m!=null || memID.equals("")) {
			return 0; //�̹� �����ϴ� ȸ��, �ԷºҰ�
		}
		return 1; // ��밡���� ���̵�
	}
	// ȸ������ ó��
	@RequestMapping("/memRegister.do")
	public String memRegister(Member m, RedirectAttributes rttr, HttpSession session) {
		if(m.getMemID()==null || m.getMemID().equals("") ||
		   m.getMemPassword()==null || m.getMemPassword().equals("") ||
		   m.getMemName()==null || m.getMemName().equals("") ||
		   m.getMemAge()==0 || m.getMemName().equals("") ||
		   m.getMemGender()==null || m.getMemGender().equals("") ||
		   m.getMemEmail()==null || m.getMemEmail().equals("")) {
			// �����޼����� ������ ���� => ��ü���ε�(Model, HttpServletRequest, HttpSession)
		   rttr.addFlashAttribute("msgType", "���� �޼���");
		   rttr.addFlashAttribute("msg", "��� ������ �Է��ϼ���.");
		   return "redirect:/memJoin.do"; // ${msgType} , ${msg} => join.jsp���� üũ
			
		}
		m.setMemProfile(""); // �����̹����� ���ٴ� �ǹ� "" 
		// ȸ���� ���̺� �����ϱ�
		int result=memberMapper.register(m);
		if(result==1) { //ȸ������ ���� �޼���
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "ȸ�����Կ� �����߽��ϴ�.");
			//ȸ�������� �����ϸ�=> �α���ó���ϱ�
			session.setAttribute("mvo", m); // ${empty m}
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "�̹� �����ϴ� ȸ���Դϴ�.");
			return "redirect:/memJoin.do";
		}
	}
}
