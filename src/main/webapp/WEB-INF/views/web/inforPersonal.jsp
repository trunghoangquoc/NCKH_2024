<%@ page import="nckh.util.SecurityUtils" %>
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
<title>Thông Tin Cá Nhân</title>
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
    
     <!-- message-alert -->
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
	  <!-- message-alert -->
	<div class="container ">
		<div class="btn-group" role="group" aria-label="Basic example" style="margin-top : 30px;">

			<button class="btn btn-outline-success my-2 my-sm-0 "
					style="height: 40px; width: 130px; text-decoration: none"
					type="button">
				<c:url var="orderSuccessURL" value="/orderSuccess?page=1&limit=5">
					<c:param name="username" value="<%=SecurityUtils.getPrincipal().getUsername()%>"/>
				</c:url>
				<a href='${orderSuccessURL}' style="text-decoration: none;">Đơn Đã Đặt</a>
			</button>

			<button class="btn btn-outline-success my-2 my-sm-0 "
					style="height: 40px; width: 120px; text-decoration: none"
					type="button">
				<c:url var="orderDeleteURL" value="/orderDelete?page=1&limit=5">
					<c:param name="username" value="<%=SecurityUtils.getPrincipal().getUsername()%>"/>
				</c:url>
				<a href='${orderDeleteURL}' style="text-decoration: none;">Đơn Đã Hủy</a>
			</button>

			<button class="btn btn-outline-success my-2 my-sm-0 "
					style="height: 40px; width: 120px; text-decoration: none"
					type="button">
				<c:url var="homeURL"
					   value="/trang-chu"/>
				<a href='${homeURL}' style="text-decoration: none;">Trang Chủ</a>
			</button>
		</div>
	</div>
	<!-- form login -->
	<div class=" form-login ">
		<fieldset>
			<%--@elvariable id="userInfo" type="agricultural"--%>
			<form:form id="formSubmit" modelAttribute="userInfo">
				<div class="form-group row">
					<label for="fullName" class="col-sm-2 col-form-label">Họ Và Tên</label>
					<div class="col-sm-10">
			        <form:input type="text" name="fullName" class="form-control" id="fullName" path="fullName" placeholder="Họ và Tên" required ="required" ></form:input>
					</div>
				</div>
					<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">Tên</label>
					<div class="col-sm-10">
						<form:input type="text" name="userName" path="username" class="form-control" id="username" placeholder="Tên" required ="required"></form:input>
 						
					</div>
				</div>
				<div class="form-group row">
					<%--@declare id="address"--%><label for="phoneNumber" class="col-sm-2 col-form-label">Số Điện Thoại</label>
					<div class="col-sm-10">
						<form:input type="tel" pattern="[0-9]{10}" name="phoneNumber"
									path="phoneNumber" class="form-control" id="phoneNumber" placeholder="Số Điện Thoại" required ="required"></form:input>
						
					</div>
				</div>
			
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<form:input type="email" name="email" path="email"
									class="form-control" id="inputEmail3" placeholder="Email" required ="required"></form:input>
						
					</div>
				</div>
				<div class="form-group row">
						<%--@declare id="address"--%><label for="address" class="col-sm-2 col-form-label">Địa Chỉ</label>
					<div class="col-sm-10">
						<form:input type="text" name="address" path="address"
									class="form-control" id="address" placeholder="Địa Chỉ" required ="required"></form:input>

					</div>
				</div>
<%--				<div class="form-group row">--%>
<%--					<label for="inputPassword3" class="col-sm-2 col-form-label">Mật khẩu</label>--%>
<%--					<div class="col-sm-10">--%>
<%--						          <input type="password" name="passWord" class="form-control" id="inputPassword3" placeholder="Mật Khẩu" required>--%>
<%--					</div>--%>
<%--				</div>--%>
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-outline-success my-2 my-sm-0" id="btnAddOrUpdateNew">
							Cập Nhập Thông Tin</button>
					</div>
				</div>
			</form:form>
		</fieldset>
	</div>

	
	
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