<%@ page language="java" contentType="text/html; charset=GB2312"pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%
Connection con;
Statement sql;
ResultSet rs;
try{        
	
           request.setCharacterEncoding("gb2312");//设置请求字符的编码为国标2312
           String gid1=request.getParameter("gid1");//得到请求参数el1
           String gid=request.getParameter("gid");//得到请求参数el
           String gname=request.getParameter("gname");//得到请求参数elt
           String gprice=request.getParameter("gprice");//得到请求参数els
           String sid=request.getParameter("sid");//得到请求参数ch
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载sqlserver驱动必须用try{}catch{}语句捕获异常
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql的url其中127.0.0.1是本地服务器，1433是数据库的接口，DATABASENAME是dictionary数据库
			con=DriverManager.getConnection(url,"sa","123456");//连接数据库
			sql=con.createStatement();//创建连接
			  String ss="UPDATE goodtable set gid='"+gid+"',gname='"+gname+"',gprice='"+gprice+"',sid='"+sid+"' where gid='"+gid1+"'";//更新输入的数据依据输入所要修改的英语
			  int i=sql.executeUpdate(ss);//执行sql语句
			  if(i>0){
				    out.print("<script>alert('修改成功');location.href='Gmodify.jsp';</script>");//成功则跳为成功的框
				  }
				  else{
				    out.print("<script>alert('修改失败');location.href='Gmodify3.jsp';</script>");//失败则跳转失败的框
				 }
			
	}
catch(SQLException e){
	System.out.println(e);
}

%>

