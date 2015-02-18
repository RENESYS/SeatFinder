<%@page import="manage.*" import="java.util.*" import="data.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SeatFinder v0.1</title>
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

catchEvent(window, "load", setupEvents);
</script>

<h1>SeatFinder v0.1</h1>
<h3>원하시는 역을 선택하세요</h3>
<img src = "img/line4.png">

 <form name="setting" action="inner.jsp" method="get">
       <p>
           <select name="hour">
               <option value="4">04시</option>
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
           <input type="text" name="staNum" id = "aaa" value="" />
           <input type="submit" value="검색" />
       </p>
</form>




</body>
</html>