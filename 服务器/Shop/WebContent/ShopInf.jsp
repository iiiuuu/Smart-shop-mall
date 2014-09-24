<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><?xml version="1.0" encoding="UTF-8"?>
<charts><c:forEach items="${sgs}" var="sges">
	<news id="${sges.sid}">
	<sname>${sges.sname}</sname>
	<layer>${sges.layer}</layer>
	<smessage>${sges.smessage}</smessage>
	<sphone>${sges.sphone}</sphone>
	<praise>${sges.praise}</praise>
	<step>${sges.step}</step>
	<x>${sges.x}</x>
	<y>${sges.y}</y>
	</news></c:forEach>
</charts>