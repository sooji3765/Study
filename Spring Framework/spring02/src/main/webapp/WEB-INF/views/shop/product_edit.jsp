<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>

<script type="text/javascript">

	function product_update(){

	//태그를 name 으로 조회할경우
	// var product_name = docucment.form1.product_name.value;
	
	// 태그를 id로 조회할 경우
	var product_name =$("#product_name").val();
	var price=$("#price").val();
	var description = $("#description").val();
	
	if(product_name==""){
		alert("상품이름을 입력하세요.");
		$("#product_name").focus();
		return;
	}
	if(price==""){
		alert("상품가격을 입력하세요.");
		$("#price").focus();
		return;
	}
	if(description==""){
		alert("상품설명을 입력하세요.");
		$("#description").focus();
		return;
	}
	
	document.form1.action="${path}/shop/product/update.do";
	document.form1.submit();
	
	}
	
	function product_delete(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/shop/product/delete.do";
			document.form1.submit();
		}
	}
	
</script>

<form name="form1" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>상품명</td>
			<td><input name="product_name" id="product_name" value="${dto.product_name}"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input name="price" id="price" value="${dto.price}"></td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td><textarea rows="5" cols="60" name="description" id="description" >${dto.description}</textarea></td>
		</tr>
		<tr>
			<td>상품 이미지</td>
			<td>
			<img src="${path}/images/${dto.picture_url}" width="300px" height="300px">
			<br>
			<input type="file" name="file1" id="file1">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="hidden" name="product_id" value="${dto.product_id}">
				<input type="button" value="수정" onclick="product_update()">
				<input type="button" value="삭제" onclick="product_delete()">
				<input type="button" value="목록" onclick="location.href='${path}/shop/product/list.do'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>