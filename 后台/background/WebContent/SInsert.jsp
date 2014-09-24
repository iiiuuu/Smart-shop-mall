<%@ page language="java" contentType="text/html; charset=GB2312"pageEncoding="UTF-8"%><!其中charset是字符编码其中是国标2312编码而pageencoding是页面编码Utf-8!>
<%@page import="java.sql.*" %><!调用sql包!>
 <%@page import="background.com.Bean.*" %><!调用ks包!>
 <jsp:useBean id="add" class="background.com.Bean.SInsertBean"scope="request"/><!使用javabean文件InsertBean并命名为add!>
 <jsp:useBean id="look" class="background.com.Bean.SqureyBean"scope="request"/><!使用javabean文件QueryBean并命为look!>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SInsert</title>
</head>
<body><font size=2> 
店铺id是主键，不可重复，请输入新记录的相应字段的值：
<form action="" method=post><!表单用于提交数据!>
输入店铺id；<Input type="text" name="sid"size=10>
输入所在层数：<Input type="text" name="layer"size=10>
输入店铺名称：<Input type="text" name="sname"size=10>
输入店铺信息：<Input type="text" name="smessage"size=10>
输入店铺电话；<Input type="text" name="sphone"size=10>
输入赞；<Input type="text" name="prise"size=10>
输入踩；<Input type="text" name="step"size=10>
输入x；<Input type="text" name="x"size=10>
输入y；<Input type="text" name="y"size=10>
<BR><Input type="submit" name="b" value="提交增添">
<jsp:setProperty name="add" property="*"/>
<br>你增添记录操作的结果：
<jsp:getProperty name="add"property="addMessage"/><!返回InsertBean中的addMessage消息输出操作是否成功!>
<p>数据库当前的数据记录是；
<jsp:getProperty name="look"property="queryResult"/><!输出列表用的look!>
<td><A href="index.jsp"><font size=2>返回</font></A></td><!设置返回按钮用于返回首页!>
</form>
</font>

</body>
</html>