<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Dto.dto" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<dto> glist = new ArrayList<dto>();
glist = (ArrayList<dto>) request.getAttribute("glist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%@ include file="header.jsp"%>
<section>
	<div class="title">상품별 매출 현황</div>
	<div class="wrapper">
				<table border="1">
					<tr>
						<th>피자 코드</th>
						<th>피자 명</th>
						<th>총매출액</th>
					</tr>
					<% for(dto d : glist){ %>
					<tr>
						<td><%=d.getPizzacode() %></td>
						<td><%=d.getPizzaname() %></td>
						<td><%=d.getTotal() %></td>
					</tr>
					<%} %>
				</table>
			</div>
</section>
<%@ include file="footer.jsp"%>
</body>
</html>