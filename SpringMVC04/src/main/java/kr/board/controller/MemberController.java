package kr.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
	public String memRegister(Member m, String memPassword1, String memPassword2, RedirectAttributes rttr, HttpSession session) {
		if(m.getMemID()==null || m.getMemID().equals("") ||
		   memPassword1==null || memPassword1.equals("") ||
		   memPassword2==null || memPassword2.equals("") ||
		   m.getMemName()==null || m.getMemName().equals("") ||
		   m.getMemAge()==0 ||
		   m.getMemGender()==null || m.getMemGender().equals("") ||
		   m.getMemEmail()==null || m.getMemEmail().equals("")) {
			// �����޼����� ������ ���� => ��ü���ε�(Model, HttpServletRequest, HttpSession)
		   rttr.addFlashAttribute("msgType", "���� �޼���");
		   rttr.addFlashAttribute("msg", "��� ������ �Է��ϼ���.");
		   return "redirect:/memJoin.do"; // ${msgType} , ${msg} => join.jsp���� üũ	
		}
		if (!memPassword1.equals(memPassword2)) {
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "��й�ȣ�� ���� �ٸ��ϴ�.");
			return "redirect:/memJoin.do";
		}
		m.setMemProfile(""); // �����̹����� ���ٴ� �ǹ� "" 
		// ȸ���� ���̺��� �����ϱ�
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
	// �α׾ƿ� ó��
	@RequestMapping("/memLogout.do")
	public String memLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	// �α��� ȭ������ �̵�
	@RequestMapping("/memLoginForm.do")
	public String memLoginForm() {
		return "member/memLoginForm"; // memLoginForm.jsp
	}
	// �α��� ��� ����
	@RequestMapping("/memLogin.do")
	public String memLogin(Member m, RedirectAttributes rttr, HttpSession session) {
		if(m.getMemID()==null || m.getMemID().equals("") ||
		   m.getMemPassword()==null || m.getMemPassword().equals("")) {
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "��� ������ �Է����ּ���.");
			return "redirect:/memLoginForm.do";
		}
		Member mvo=memberMapper.memLogin(m);
		if(mvo!=null) { // �α��ο� ����
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "�α��ο� �����߽��ϴ�.");
			session.setAttribute("mvo", mvo); //${!empty mvo}
			return "redirect:/"; // ����
		}else { // �α��ο� ����
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "�ٽ� �α��� ���ּ���.");
			return "redirect:/memLoginForm.do";
		}
	}
	// ȸ������ ����ȭ��
	@RequestMapping("/memUpdateForm.do")
	public String memUpdateForm() {
		return "member/memUpdateForm";
	}
	// ȸ������ ����
	@RequestMapping("/memUpdate.do")
	public String memUpdate(Member m, RedirectAttributes rttr,
			String memPassword1, String memPassword2, HttpSession session) {
		if(m.getMemID()==null || m.getMemID().equals("") ||
			 memPassword1==null || memPassword1.equals("") ||
			 memPassword2==null || memPassword2.equals("") ||
			 m.getMemName()==null || m.getMemName().equals("") ||
			 m.getMemAge()==0 ||
			 m.getMemGender()==null || m.getMemGender().equals("") ||
			 m.getMemEmail()==null || m.getMemEmail().equals("")) {
			// �����޼����� ������ ���� => ��ü���ε�(Model, HttpServletRequest, HttpSession)
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "��� ������ �Է��ϼ���.");
			return "redirect:/memJoin.do"; // ${msgType} , ${msg} => join.jsp���� üũ	
				}
		if (!memPassword1.equals(memPassword2)) {
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "��й�ȣ�� ���� �ٸ��ϴ�.");
			return "redirect:/memJoin.do";
		}
		// ȸ���� ���������ϱ�
		int result=memberMapper.memUpdate(m);
		if(result==1) { //�������� �޼���
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "ȸ������ ������ �����߽��ϴ�.");
			//ȸ�������� �����ϸ�=> �α���ó���ϱ�
			session.setAttribute("mvo", m); // ${empty m}
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "ȸ������ ������ �����߽��ϴ�.");
			return "redirect:/memUpdateForm.do";
		}
	}
	// ȸ���� ������� ȭ��
	@RequestMapping("/memImageForm.do")
	public String memImageForm() {
		return "member/memImageForm"; // memImageForm.jsp
	}
	
	// ȸ������ �̹��� ���ε�(upload, DB����)
	@RequestMapping("/memImageUpdate.do")
	public String memImageUpdate(HttpServletRequest request,HttpSession session, RedirectAttributes rttr) {
		// ���Ͼ��ε� API(cos.jar, 3����)
		MultipartRequest multi=null;
		int fileMaxSize=10*1024*1024;  // 10MB
		String savePath=request.getRealPath("resources/upload");
		try {
			// �̹��� ���ε�
			multi=new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			rttr.addFlashAttribute("msgType", "���� �޼���");
			rttr.addFlashAttribute("msg", "������ ũ��� 10MB�� ���� �� �����ϴ�.");
			return "redirect:/memImageForm.do";
		}
		// �����ͺ��̽� ���̺��� ȸ���̹����� ������Ʈ
		String memID=multi.getParameter("memID");
		String newProfile="";
		File file=multi.getFile("memProfile");
		if(file !=null) { // ���ε尡 �Ȼ���(.png, .jpg, .gif)
			// �̹����� ���θ� üũ->�̹��� ������ �ƴϸ� ����(1.png)
			String ext=file.getName().substring(file.getName().lastIndexOf(".")+1);
			ext=ext.toUpperCase(); // PNG, GIF, JPG
			if(ext.equals("PNG") || ext.equals("GIF") || ext.equals("JPG")){
				// ���� ���ε���̹���(new->1.PNG), ����DB�� �ִ� �̹���(old->4.PNG)
				String oldProfile=memberMapper.getMember(memID).getMemProfile();
				File oldFile=new File(savePath+"/"+oldProfile);
				if(oldFile.exists()) {
					oldFile.delete();
				}
				newProfile=file.getName();
			}else { // �̹��� ������ �ƴϸ�
				if(file.exists()) {
					file.delete(); //����
				}
				rttr.addFlashAttribute("msgType", "���� �޼���");
				rttr.addFlashAttribute("msg", "�̹��� ���ϸ� ���ε� �����մϴ�.");			
				return "redirect:/memImageForm.do";
			}
		}
		// ���ο� �̹����� ���̺��� ������Ʈ
		Member mvo=new Member();
		mvo.setMemID(memID);
		mvo.setMemProfile(newProfile);
		memberMapper.memProfileUpdate(mvo); // �̹��� ������Ʈ ����
		Member m=memberMapper.getMember(memID);
		// ���� ���� ����
		session.setAttribute("mvo", m);
		rttr.addFlashAttribute("msgType", "���� �޼���");
		rttr.addFlashAttribute("msg", "�̹��� ������ �����߽��ϴ�.");
		return "redirect:/";
	}
}