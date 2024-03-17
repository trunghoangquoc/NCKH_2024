<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeURL" value="/trang-chu" />
<c:url var="product" value="/product" />
<c:url var="loginURL" value="/dang-nhap" />
<c:url var="registerURL" value="/dang-ky" />
<c:url var="contactURL" value="/contact" />
<c:url var="productDetails" value="/productDetails" />
<c:url var="registerAPI" value="/api/registerAccount" />
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng Ký</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/css/bootstrap.min.css' /> ">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/my_style.css' /> ">
	
	<!-- 	trên mang -->
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>
   
</head>

<body>

	
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    
<!--        Form -->
<%-- 	<c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
	<div class=" form-login ">
		<div class="form">
			<%--@elvariable id="newUser" type=""--%>
			<form:form method="POST" action='/shop/dang-ky' modelAttribute="newUser" id="formSubmit">
				<h2 class="form-signin-heading" style="text-align: center"> Đăng Kí Tài Khoản</h2>
				<hr/>
				<div class="form-group">
					<form:input type="text" path="fullName" class="form-control"
						placeholder="Họ Và Tên" required="required"></form:input>
					<form:errors class="error" path="fullName"></form:errors>
				</div>
				<div class="form-group">
					<form:input type="text" path="userName" class="form-control"
						placeholder="Tên Đăng Nhập" required="required"></form:input>
					<form:errors class="error" style="  color: red"  path="userName"></form:errors>
				</div>
				<div class="form-group">
					<form:input type="email" path="email" class="form-control"
						placeholder="Email" autofocus="true" required="required"></form:input>
					<form:errors class="error" path="email"></form:errors>
				</div>

				<div class="form-group">
					<form:input type="password" path="passWord" class="form-control"
						required="required" placeholder="Mật khẩu"></form:input>
					<form:errors class="error" path="passWord"></form:errors>
				</div>

				<div class="form-group">
					<form:input type="tel" path="phoneNumber" pattern="[0-9]{10}" class="form-control"
						placeholder="Số Điện Thoại" required="required"></form:input>
					<form:errors class="error" path="phoneNumber"></form:errors>
				</div>

				<div class="form-group">
					<form:input type="text" path="address" class="form-control"
						placeholder="Địa Chỉ" required="required"></form:input>
					<form:errors class="error" path="address"></form:errors>
				</div>
				<input id="submit" type="submit" class="btn btn-outline-success my-2 my-sm-0" value="Đăng Ký">
				<p class="message" style="font-size: 18; padding-top:10px"> Bạn Có Chắc Chắn Muốn Tạo Tài Khoản? <a href="<c:url value='/dang-nhap'/>" >Đăng Nhập</a></p>
			</form:form>
		</div>
	</div>
	
<!-- 	Form -->
	
	<!-- footer -->
    <%@ include file="/common/web/footer.jsp" %>
    <!-- footer -->


	<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">
	</script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>