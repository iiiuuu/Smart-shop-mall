<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><?xml version="1.0" encoding="UTF-8"?>
<charts><c:forEach items="${ggs}" var="gges">
	<news id="${gges.gid}">
	<gname>${gges.gname}</gname>
	<gprice>${gges.gprice}</gprice>
	<sid>${gges.sid}</sid>
	<sname>${gges.sname}</sname>
	</news></c:forEach>
</charts>