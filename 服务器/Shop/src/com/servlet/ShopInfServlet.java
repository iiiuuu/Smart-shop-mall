package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ShopInf;
import com.bean.ShopInfBean;
import com.domain.Shop;


public class ShopInfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopInf service=new ShopInfBean();
	private String sg=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		//String temp = request.getCharacterEncoding();
		sg = request.getParameter("sg");
		//sg=new String(sg.getBytes("GBK"),"UTF-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//sg=new String(sg.getBytes("UTF-8"),"GBK");
		List<Shop> sgs = service.getShopInf(sg);
		request.setAttribute("sgs", sgs);
		request.getRequestDispatcher("/ShopInf.jsp").forward(request, response);
	}

}
