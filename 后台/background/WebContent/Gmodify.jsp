<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="UTF-8"%><!其中charset是字符编码其中是国标2312编码而pageencoding是页面编码Utf-8!>
    <%@page import="java.sql.*" %><!调用sql包!>
 <%@page import="background.com.Bean.*" %><!调用ks包!>
    <jsp:useBean id="look" class="background.com.Bean.GqureyBean" scope="request"/><!使用javabean文件QueryBean并命名为look!>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gmodify</title>
</head>
<body>
<FORM action="Gmodify2.jsp" method=post name=form>
选择你要的修改的商品id：<INPUT type="text"name="gid1"><!编辑框输入el1的数据!>
修改后商品id；<Input type="text" name="gid"size=10>
修改后商品名称：<Input type="text" name="gname"size=10>
修改后商品价格：<Input type="text" name="gprice"size=10>
修改后店铺id：<Input type="text" name="sid"size=10>
<Input type=submit name="g" value="修改"><!提交按钮!>
</FORM><!这个表单是将这些数据提交给modify2.jsp中!>
<BR><jsp:getProperty name="look" property="queryResult"/><!输出数据库数据!>
<td><A href="index.jsp"><font size=2>返回</font></A></td><!设置返回按钮用于返回首页!>
</body>
</html>