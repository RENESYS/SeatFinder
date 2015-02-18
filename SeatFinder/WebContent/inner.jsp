<%@page import="manage.*" import="java.util.*" import="data.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Train Congestion Information</title>
</head>
<body>
	<%
	ServletContext context = getServletContext();
	String path = context.getRealPath("/");
	request.setCharacterEncoding("UTF-8");
	
	Manager main = new Manager();
	ArrayList<Station> sta = main.initialize(request, response, path);

	String name = (request.getParameter("staNum"));
	int num = main.getStationNum(sta, name);
	int hour = Integer.parseInt(request.getParameter("hour"));
	int[] train = main.getTrainCongestion(sta, num, hour);
	%>
	
	<h2><%=name %>역 <%=hour %>시 하행열차 혼잡도입니다.</h2>
	
	<%
	for(int i = 0; i < 10; i++){
		if(train[i] < 50){
			%>
		<img src = "img/green.jpg" width = 80>
		<%continue;}
		if(train[i] >= 50 && train[i] < 100){
			%>
		<img src = "img/yellow.jpg" width = 80>
		<%continue;}
		if(train[i] >= 100){
			%>
		<img src = "img/red.jpg" width = 80>
		<%}
	}
%>

</body>
</html>