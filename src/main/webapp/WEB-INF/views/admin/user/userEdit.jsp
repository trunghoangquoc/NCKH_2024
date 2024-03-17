<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@page session="false" %>
<c:url var="userListURL" value="/admin/user/listActive" />
<c:url var="adminURL" value="/admin/home" />
<c:url var="userEditURL" value="/admin/user/edit" />
<c:url var="userAPI" value="/api/user" />

<%@ page import="nckh.util.SecurityUtils"%>

<html>
<head>
<title>Chỉnh Sửa Người Dùng</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="<c:url value='/template/web/css/my_style.css' /> ">
    <!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />

</head>
<body class="no-skin">

	<!-- header -->
	<div id="navbar" class="navbar navbar-default          ace-save-state  navedit">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href='<c:url var="adminURL" value="/admin/home"/>' class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang quản trị
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        Xin chào, <%=SecurityUtils.getPrincipal().getFullName()%>
                    </a>
                    <li class="light-blue dropdown-modal">
                        <a href='<c:url value='/logoutSuccessful'/>'>
                            <i class="ace-icon fa fa-power-off"></i>
                            Thoát
                        </a>
                    </li>
                </li>
            </ul>
        </div>
    </div>
</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		
		<!-- menu -->
    	<%@ include file="/common/admin/menu.jsp" %>
	    <!-- menu -->
	    
<!-- body -->
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="<c:url value='/admin/home'/>"><i
						class="navbar-brand" ></i>Trang chủ</a></li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
  							${message}
						</div>
					</c:if>
					<%--@elvariable id="model" type=""--%>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
						<div class="form-group">
							  <label for="roleCode" class="col-sm-3 control-label no-padding-right">Vai Trò:</label>
							  <div class="col-sm-9">
							  	 <form:select path="roleCode" id="roleCode">
							  	 	<form:option value="" label="-- Role --"/>
							  	 	<form:options items="${roles}"/>
							  	 </form:select>
							  </div>
						</div>
						<div class="form-group">
								<%--@declare id="form-field-1"--%><label class="col-sm-3 control-label no-padding-right" for="form-field-1">Name</label>
								<div class="col-sm-9">
									<form:input path="userName" cssClass="col-xs-10 col-sm-5" id="userName" />
								</div>
						</div>
					
						<div class="form-group">
						  	<label for="content" class="col-sm-3 control-label no-padding-right">Họ Và Tên:</label>
						  	<div class="col-sm-9">
						  		<form:input path="fullName"  cssClass="form-control" id="fullName"/>
						  	</div>
						</div>
						<div class="form-group">
						  	<%--@declare id="content"--%><label for="content" class="col-sm-3 control-label no-padding-right">Email:</label>
						  	<div class="col-sm-9">
						  		<form:input path="email"  cssClass="form-control" id="email"/>
						  	</div>
						</div>
						<div class="form-group">
						  	<label for="content" class="col-sm-3 control-label no-padding-right">Trạng Thái:</label>
						  	<div class="col-sm-9">
						  		<form:input path="status"  cssClass="form-control" id="status"/>
						  	</div>
						</div>
						<div class="form-group">
						  	<label for="content" class="col-sm-3 control-label no-padding-right">Địa Chỉ:</label>
						  	<div class="col-sm-9">
						  		<form:input path="address"  cssClass="form-control" id="address"/>
						  	</div>
						</div>
						<div class="form-group">
						  	<label for="content" class="col-sm-3 control-label no-padding-right">Số Điện Thoại:</label>
						  	<div class="col-sm-9">
						  		<form:input path="phoneNumber"  cssClass="form-control" id="phoneNumber"/>
						  	</div>
						</div>
						<form:hidden path="id" id="newId"/>
						<c:if test="${empty model.id}">
						     <div class="form-group">
						  	    <label for="content" class="col-sm-3 control-label no-padding-right">Mật Khẩu :</label>
						       	<div class="col-sm-9">
						  		   <form:input path="passWord"  cssClass="form-control" id="passWord"/>
						  	    </div>
						      </div>		
						</c:if>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập Nhập Tài Khoản
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Tạo Tài Khoản
												</button>
											</c:if>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Hủy
											</button>
							</div>		
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>	

<script>
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#newId').val();
	    if (id == "") {
	    	addUser(data);
	    } else {
	    	updateUser(data);
	    }
	});
	
	function addUser(data) {
		$.ajax({
            url: '${userAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${userEditURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${userEditURL}?page=1&limit=2&message=error_system";
            }
        });
	}
	
	function updateUser(data) {
		$.ajax({
            url: '${userAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${userEditURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${userEditURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
     <!-- body -->
     
 	  <!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->
    	
		
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
		<script src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	
	<!-- page specific plugin scripts -->
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>
