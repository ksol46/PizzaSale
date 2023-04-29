<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<section>
		<form name="frm" action="add">
			<div class="wrapper">
				<table border="1">
					<tr>
						<th>매출전표번호</th>
						<td><input type="text" name="saleno"></td>
					</tr>
					<tr>
						<th>지점코드</th>
						<td><input type="text" name="bcode"></td>
					</tr>
					<tr>
						<th>판매일자</th>
						<td><input type="text" name="saledate"></td>
					</tr>
					<tr>
						<th>피자코드</th>
						<td>
							<select name="pizzacode">
								<option value="">피자선택</option>
								<option value="PP01">[PP01]고르곤졸라피자</option>
								<option value="PP02">[PP02]치즈피자</option>
								<option value="PP03">[PP03]페퍼로니피자</option>
								<option value="PP04">[PP04]콤피네이션피자</option>
								<option value="PP05">[PP05]고구마피자</option>
								<option value="PP06">[PP06]포테이토피자</option>
								<option value="PP07">[PP07]불고기피자</option>
								<option value="PP08">[PP08]나폴리피자</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>판매수량</th>
						<td><input type="text" name="quantity"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="btn" type="submit" onclick="fn_submit(); return false;">전표등록</button>
							<button class="btn" type="reset" onclick="fn_reset();">다시쓰기</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>