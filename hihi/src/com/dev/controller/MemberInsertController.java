package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. �Է� ȭ�鿡�� query string�� �� �Է°� ��������
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String zipcode = req.getParameter("zipcode");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
	
		if(id.isEmpty() || pwd.isEmpty() || name.isEmpty() || email.isEmpty() ||zipcode.isEmpty()||address.isEmpty()||phone.isEmpty())
		{
			req.setAttribute("error", "Enter All information!!");
			HttpUtil.forward(req, resp, "/join.jsp");
			return;
		}
		
		//2. �Է°����� MemberVO ��ü ����
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(pwd);
		member.setName(name);
		member.setMail(email);
		member.setPhone(phone);
		member.setZip(zipcode);
		member.setAdd(address);
		
		//3. MemberService���� ����, ó��
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		//4. ����ڿ��� ��� �˷��ֱ�
		/*PrintWriter out = resp.getWriter();
		out.print("Join success");
		out.close();*/
		String path="/result/memberInsertOutput.jsp";
		//RequestDispatcher dispather = req.getRequestDispatcher(path);
		//dispather.forward(req, resp);
		req.setAttribute("id", id);
		HttpUtil.forward(req, resp, path);
	}

}