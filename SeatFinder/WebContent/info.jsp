<%@page import="manage.*" import="java.util.*" import="data.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>SeatFinder v0.5 - Train Congestion Analyzer</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <style>
		body {
			padding-top: 60px; 
			/* 60px to make the container go all the way to the bottom of the topbar */
		}
	</style>
</head>
<body>
	<script type="text/javascript" src="event.js"> </script>
	<script type="text/javascript">
	// a Generic function to associate the event handler with a function
	function catchEvent(eventObj, event, eventHandler) {
		if (eventObj.addEventListener)
	                eventObj.addEventListener(event, eventHandler, false);
		else if (eventObj.attachEvent) {
	                event = "on" + event;
	                eventObj.attachEvent(event, eventHandler);
		}
		else
			alert("error");
	}
	
	catchEvent(window, "load", showCarInfo);
	</script>

	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="seatFinder.jsp">SeatFinder v0.5</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="seatFinder.jsp">Home</a></li>
            <li><a href="#about">About</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
        <%
		ServletContext context = getServletContext();
		String path = context.getRealPath("/");
		request.setCharacterEncoding("UTF-8");
		
		Manager main = new Manager();
		ArrayList<Station> sta = main.initialize(request, response, path);
	
		int staNum = Integer.parseInt(request.getParameter("staNum")) - 409;
		String name = sta.get(staNum).getName();
		int hour = Integer.parseInt(request.getParameter("hour"));
		int[] train = main.getTrainCongestion(sta, staNum, hour);
		%>
		
		<div class="alert alert-success"><b><%=name %>역 <%=hour %>시</b> 하행열차 혼잡도입니다.</div>
		</br>
		<div id = "passenger"></div>
		<%
		for(int i = 0; i < 10; i++){
			String id = "" + i;
			if(train[i] < 50){
				%>
			<img src = "img/green.jpg" id = <%=id %> name = <%=train[i]%> width=80>
			<%continue;}
			if(train[i] >= 50 && train[i] < 100){
				%>
			<img src = "img/yellow.jpg" id = <%=id %> name = <%=train[i]%> width=80>
			<%continue;}
			if(train[i] >= 100){
				%>
			<img src = "img/red.jpg" id = <%=id %> name = <%=train[i]%> width=80>
			<%}
		}
	%>
	</br></br>
	<div class="alert alert-danger"> 그림 위에 마우스를 올리시면 각 열차 칸의 정보를 볼 수 있습니다.</div>
    </div><!-- /.container -->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>