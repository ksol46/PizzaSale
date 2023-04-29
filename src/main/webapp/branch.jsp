<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Dto.dto" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<dto> blist = new ArrayList<dto>();
blist = (ArrayList<dto>) request.getAttribute("blist");
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
	<div class="title">지점별 매출 현황</div>
	<div class="wrapper">
				<table border="1">
					<tr>
						<th>지점 코드</th>
						<th>지점 명</th>
						<th>총매출액</th>
					</tr>
					<% for(dto bd : blist){ %>
					<tr>
						<td><%=bd.getBcode() %></td>
						<td><%=bd.getBname() %></td>
						<td style="text-align: right;"><%=bd.getTotal() %></td>
					</tr>
					<%} %>
				</table>
			</div>
</section>
<%@ include file="footer.jsp"%>
</body>
</html>