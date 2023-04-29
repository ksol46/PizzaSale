function fn_submit() {
	var fn = document.frm;

	if (fn.saleno.value == "") {
		alert("매출전표번호가 입력되지 않았습니다!");
		fn.saleno.focus();
		return false;
	}
	if (fn.bcode.value == "") {
		alert("지점코드가 입력되지 않았습니다!");
		fn.bcode.focus();
		return false;
	}
	if (fn.saledate.value == "") {
		alert("판매일자가 입력되지 않았습니다!");
		fn.saledate.focus();
		return false;
	}
	if (fn.pizzacode.value == "") {
		
		alert("피자코드가 입력되지 않았습니다!");
		fn.pizzacode.focus();
		return false;
	}
	if (fn.quantity.value == "") {
		alert("판매수량이 입력되지 않았습니다!");
		fn.quantity.focus();
		return false;
	}
	console.log("insert 확인");
	fn.submit();
}

function fn_reset(){
	alert("정보를 지우고 처음부터 다시 입력합니다!");
}