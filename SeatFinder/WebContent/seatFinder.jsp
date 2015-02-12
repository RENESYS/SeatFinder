<%@page import="manage.*" import="java.util.*" import="data.*"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//ReadFile r = new ReadFile();
	//r.init();
	ServletContext context = getServletContext();
	String path = context.getRealPath("/");
	ArrayList<Station> aa = Manager.manager(path);
	int n = aa.get(0).getNum();
	int m = aa.get(10).getBound()[10];
	int nn = aa.get(11).getStair().get(2);
	//int n = 10;
%>

<h2><%=n %></h2>
<h3><%=m %></h3>
<h1><%= nn %></h1>

</body>
</html>