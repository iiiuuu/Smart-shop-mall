<%@ page language="java" contentType="text/html; charset=GB2312"pageEncoding="UTF-8"%><!其中charset是字符编码其中是国标2312编码而pageencoding是页面编码Utf-8!>
 <%@page import="java.sql.*" %><!调用sql包!>
 <%@page import="background.com.Bean.*" %><!调用ks包!>
 <jsp:useBean id="base" class="background.com.Bean.GDeleteBean" scope="request"/><!使用javabean文件DeleteBean并命名为base!>
 <jsp:useBean id="look" class="background.com.Bean.GqureyBean" scope="request"/><!使用javabean文件QueryBean并命名为look!>
 <jsp:setProperty name="base" property="id"param="id"/><!设置el字段的变量!>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GDelete</title>
</head>
<body>
<FORM action="" method=post name=form><!表单用于提交数据!>
填写你要删除的gid：<INPUT type="text"name="id"><!编辑框输入el的数据!>
<Input type=submit name="g" value="删除"><!删除按钮进行提交数据!>
<jsp:setProperty name="base" property="*"/>
你的操作；<jsp:getProperty name="base"property="deleteMessage"/><!返回DeleteBean中的deleteMessage消息输出操作是否成功!>
<p>数据库当前的数据记录是；
<BR><jsp:getProperty name="look" property="queryResult"/><!输出列表用的look!>
<td><A href="index.jsp"><font size=2>返回</font></A></td><!设置返回按钮用于返回首页!>
</FORM>
</body>
</html>