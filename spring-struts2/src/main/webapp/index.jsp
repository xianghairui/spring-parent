<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.xiang.spring.struts2.bean.Person"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
		Person person = ctx.getBean(Person.class);
		person.sayHello();
	%>

</body>
</html>