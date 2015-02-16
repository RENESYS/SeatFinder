<%@page import="manage.*" import="java.util.*" import="data.*"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SeatFinder v0.1</title>
</head>
<body>
<%
	response.setCharacterEncoding("EUC_KR");
	ServletContext context = getServletContext();
	String path = context.getRealPath("/");
	
	
	ArrayList<Station> aa = Manager.manager(request, response, path);
	String na = aa.get(24).getName();
	int n = aa.get(24).getNum();
	int m = aa.get(24).getBound()[10];
	int nn = aa.get(24).getStair().get(2);
	int o = 0;
	int oo = 0;
	if( aa.get(24) instanceof TransferSta){
		TransferSta ss = (TransferSta)aa.get(24);
		o = ss.getTransferPassenger();
		oo = ss.getTransferStair().get(1);
	}
	int r = aa.get(24).getGetOff()[23];
%>

 <form name="searchForm" action="" method="get">
       <p>
           <select name="searchType">
               <option value="ALL">전체검색</option>
               <option value="SUBJECT">제목</option>
               <option value="WRITER">작성자</option>
               <option value="CONTENTS">내용</option>
           </select>
           <input type="text" name="searchText" value="" />
           <input type="submit" value="검색" />
       </p>
</form>

<h2><%=n %></h2>
<h3><%=m %></h3>
<h1><%= nn %></h1>
<h2><%=o %></h2>
<h3><%=oo %></h3>
<h1><%= na %></h1>
<h2><%=r %></h2>
<% for(int i = 0; i < 24; i++){
	int[] arr = aa.get(3).getCongetstion()[i].getCrowd();
	for(int e : arr){
%>
<%=e%>
<%}
%>
<p></p>
<%}%>


</body>
</html>