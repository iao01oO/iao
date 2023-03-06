package com.shopping.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.bean.EcUser;
import com.shopping.dao.UserDao;

@WebServlet({"/doLogin","/loginOut","/doRegister"})
public class userControll extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		UserDao userDao=new UserDao();
		String uri=req.getRequestURI();
		if(uri.endsWith("/doLogin")) {
			String loginName = req.getParameter("loginName");
			String password = req.getParameter("password");
			System.out.println("请求登录的用户名："+loginName+","
				+ "请求登录的密码:"+password);
			EcUser user=userDao.doLogin(loginName, password);
			if(user!=null) {
				session.setAttribute("user", user);
				resp.sendRedirect("queryAllA"+ "rctile");
			}else {
				session.setAttribute("errorMsg", "用户名或密码输入错误");
				resp.sendRedirect("login.jsp");
			}
		
			}
			else if(uri.endsWith("/loginOut")) {
				session.invalidate();
				resp.sendRedirect("login.jsp");
			}
			else if(uri.endsWith("/doRegister")) {
				String loginName = req.getParameter("loginName");
				String password = req.getParameter("password");
				String name = req.getParameter("name");
				String sex = req.getParameter("sex");
				String address = req.getParameter("address");
				String phone = req.getParameter("phone");
				EcUser user=new EcUser(loginName,password,name,Integer.parseInt(sex),address,phone);
				int i=userDao.doRegister(user);
				if(i>0) {
					session.setAttribute("errorMsg", "用户"+user.getLoginName()+"注册成功");
					resp.sendRedirect("login.jsp");
					
				}
				else {
					session.setAttribute("rgError", "注册失败,该用户已存在");
					resp.sendRedirect("register.jsp");
				}
			}
		
		}
	
}

