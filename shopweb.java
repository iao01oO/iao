package com.shopping.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.bean.EcArticle;
import com.shopping.bean.EcArticleType;
import com.shopping.bean.EcUser;
import com.shopping.bean.ShopCar;
import com.shopping.dao.ShopDao;
import com.shopping.utils.BaseUtils;

@WebServlet({"/queryAllArctile","/queryActileById","/addShopCar","/myShopCar"})
public class shopweb extends HttpServlet implements BaseUtils{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		String uri=req.getRequestURI();
		ShopDao shopDao=new ShopDao();
		int i=0;
		if(uri.endsWith("/queryAllArctile")) {
			List<EcArticleType> articleTypeList=shopDao.queryAllArctileType();
			session.setAttribute("articleTypeList", articleTypeList);
			String remark=req.getParameter("remark");
			String title=req.getParameter("title");
			session.setAttribute("title", title);
			session.setAttribute("remark", remark);
			int pageNum=getInt(req,"pageNum",1);
			session.setAttribute("pageNum", pageNum);
			int pageSize=getInt(req,"pageSize",8);
			session.setAttribute("pageSize", pageSize);
			List<EcArticle> articleList=new ArrayList<EcArticle>();
			List<EcArticle> pageToleList=null;
			if((remark==null||remark.equals(""))&&(title==null||title.equals(""))) {
				pageToleList=shopDao.queryAllArctile();
				articleList=shopDao.queryAllArctile(pageNum,pageSize);
			}
			if((remark!=null&&(!remark.equals("")))&&(title==null||title.equals(""))) {
				 articleList=shopDao.queryAllArctileByType(remark,pageNum,pageSize);
				 pageToleList=shopDao.queryAllArctileByType(remark);
				 
			}
			if((remark==null||remark.equals(""))&&((title!=null)&&(!title.equals("")))) {
				 articleList=shopDao.queryAllArctileByTitle(title,pageNum,pageSize);
				 pageToleList=shopDao.queryAllArctileByTitle(title);
			}
			if(((remark!=null)&&(!remark.equals("")))&&((title!=null)&&(!title.equals("")))) {
				 articleList=shopDao.queryAllArctileByTitleAndRemark(title,remark);
				 pageToleList = shopDao.queryAllArctileByTitleAndRemark(remark, title, pageNum, pageSize);
			}
			session.setAttribute("articleList", articleList);
			int pageTole=pageToleList.size();
			session.setAttribute("pageTole", pageTole);
			resp.sendRedirect("index.jsp");
		}else if(uri.endsWith("/queryActileById")) {
			//String id=req.getParameter("id");
			//System.out.println(id);
			int id=getInt(req, "id", 1);
			EcArticle article=shopDao.queryActileById(id);
			session.setAttribute("article", article);
			resp.sendRedirect("page.jsp");
		}else if(uri.endsWith("/addShopCar")) {
			int articleId=getInt(req,"articleId",1);
			int buyNum=getInt(req,"buyNum",1);
			int userId=getInt(req,"userId",1);
			System.out.println("articleId:"+articleId+",buyNum:"+buyNum+",userId:"+userId);
			i=shopDao.addShopCar(articleId,buyNum,userId);
			if(i==1) {
				resp.sendRedirect("myShopCar?id="+articleId);
			}else {
				resp.sendRedirect("myShopCar");
			}
			
		}else if(uri.endsWith("/myShopCar")) {
			EcUser user=(EcUser)session.getAttribute("user");
			System.out.println("userid:"+user.getId());
			List<ShopCar> ShopCarList=shopDao.myShopCar(user.getId());
			for (ShopCar shopcar :ShopCarList) {
				System.out.println(shopcar.getBuyNum());
			}
			session.setAttribute("articleList", ShopCarList);
			resp.sendRedirect("shop.jsp");
		}
		
	}

}
