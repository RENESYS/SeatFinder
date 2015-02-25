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

    <title>SeatFinder v0.5</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <style>
		body {
			padding-top: 60px; 
			/* 60px to make the container go all the way to the bottom of the topbar */
		}
		th.station, td.station{
			border : 5px solid;
			border-color : #0099ff; 
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
	catchEvent(window, "load", createButtons);
	window.onresize = function(){resizeButtons()}
</script>

<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">SeatFinder v0.5</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
        <h3>원하시는 역을 선택하세요</h3>
        <img src="img/line4.png" id ="map">
		<form name="setting" action="info.jsp" method="get">
			<table align=center>
				<tr class="station">
					<td class="station" align=center colspan=2>
						<input type="hidden" name="staNum" id ="station" value="" />
						<img src="img/sta/default.png" id="sta">
					</td>
				</tr>
				<tr>
					<td align=center width=300>
						<select name="hour">
							<option>원하는 시간대를 선택하세요</option>
			               <option value="5">05시</option>
			               <option value="6">06시</option>
			               <option value="7">07시</option>
			               <option value="8">08시</option>
			               <option value="9">09시</option>
			               <option value="10">10시</option>
			               <option value="11">11시</option>
			               <option value="12">12시</option>
			               <option value="13">13시</option>
			               <option value="14">14시</option>
			               <option value="15">15시</option>
			               <option value="16">16시</option>
			               <option value="17">17시</option>
			               <option value="18">18시</option>
			               <option value="19">19시</option>
			               <option value="20">20시</option>
			               <option value="21">21시</option>
			               <option value="22">22시</option>
			               <option value="23">23시</option> 
			           </select>
					</td>
					<td align=center width=300>
						<button type="summit" class="btn btn-sm btn-success">검색</button>
					</td>
				</tr>
			</table>
		</form>
    </div><!-- /.container -->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>