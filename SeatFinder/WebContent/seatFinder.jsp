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
	response.setCharacterEncoding("EUC_KR");
	ServletContext context = getServletContext();
	String path = context.getRealPath("/");
	
	
	ArrayList<Station> aa = Manager.manager(request, response, path);
	String na = aa.get(2).getName();
	int n = aa.get(2).getNum();
	int m = aa.get(2).getBound()[10];
	int nn = aa.get(2).getStair().get(2);
	int o = 0;
	int oo = 0;
	if( aa.get(2) instanceof TransferSta){
		TransferSta ss = (TransferSta)aa.get(2);
		o = ss.getTransferPassenger();
		oo = ss.getTransferStair().get(1);
	}
	int rr = aa.get(3).getGetOn()[10];
	int r = aa.get(3).getGetOff()[23];
%>

<h2><%=n %></h2>
<h3><%=m %></h3>
<h1><%= nn %></h1>
<h2><%=o %></h2>
<h3><%=oo %></h3>
<h1><%= na %></h1>
<h2><%=r %></h2>
<h2><%=rr %></h2>

</body>
</html>