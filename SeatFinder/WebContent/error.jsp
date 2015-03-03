<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">
	<title>SeatFinder v0.9 - ERROR :(</title>
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
	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="seatFinder.jsp">SeatFinder v0.9</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="seatFinder.jsp">Home</a></li>
            <li><a href="about.jsp">About</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
    <table>
    	<tr>
    		<td>
    			<div class="panel panel-danger">
			        <div class="panel-heading">
			          <h2 class="panel-title"><b>에러가 발생했습니다!</b></h2>
			        </div>
			        <div class="panel-body">
			        <img src ="img/error.jpg" class="img-thumbnail" width=400>
			          <div class="alert alert-warning">혹시 이런 실수를 하지 않으셨나요?</div></br>
			          <p class="text-danger">※ 노선도에서 역을 클릭하지 않았습니다.</p>
			          </br>
			          </br>
			          <p>다시 하려면 상단의 Home 탭이나 뒤로 가기를 누르세요.</p>
			        </div>
      			</div>
    		</td>
    	</tr>
    </table>
    </div><!-- /.container -->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>