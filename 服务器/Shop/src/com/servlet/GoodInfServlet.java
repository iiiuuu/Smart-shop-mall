package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.GoodInf;
import com.bean.GoodInfBean;
import com.domain.Good;


/**
 * Servlet implementation class GoodInfServlet
 */
public class GoodInfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodInf service=new GoodInfBean();
	private String gg = null;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gg = request.getParameter("gg");
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Good> ggs = service.getGoodInf(gg);
		request.setAttribute("ggs", ggs);
		request.getRequestDispatcher("/GoodInf.jsp").forward(request, response);
	}

}
