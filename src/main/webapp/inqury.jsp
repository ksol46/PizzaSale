<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Dto.dto" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<dto> list = new ArrayList<dto>();
list = (ArrayList<dto>) request.getAttribute("list");
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
		<div class="title">통합매출현황조회</div>
		<div class="wrapper">
			<table border="1">
				<tr>
				<th>매출전표번호</th>
				<th>지점</th>
				<th>판매일자</th>
				<th>피자코드</th>
				<th>피자명</th>
				<th>판매수량</th>
				<th>매출액</th>
				</tr>
				<% for(dto d : list){ %>
				<tr>
				<td><%=d.getSaleno() %></td>
				<td><%=d.getBname() %></td>
				<td><%=d.getSaledate() %></td>
				<td><%=d.getPizzacode() %></td>
				<td><%=d.getPizzaname() %></td>
				<td><%=d.getQuantity() %></td>
				<td><%=d.getTake() %></td>
				</tr>
				<%} %>
			</table>
		</div>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>