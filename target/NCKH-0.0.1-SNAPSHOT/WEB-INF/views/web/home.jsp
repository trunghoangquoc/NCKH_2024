<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<%@ page import="nckh.util.SecurityUtils" %>
<c:url var="homeURL" value="/trang-chu"/>
<c:url var="product" value="/product"/>
<c:url var="loginURL" value="/dang-nhap"/>
<c:url var="registerURL" value="/dang-ky"/>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/bootstrap.min.css' /> ">
    <link rel="stylesheet"
          href="<c:url value='/template/web/css/my_style.css' /> ">

    <!-- 	trên mang -->
    <link rel="stylesheet"
          href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>

<body>

<!-- header -->
<%@ include file="/common/web/header.jsp" %>
<!-- header -->

<!-- 	message -->
<div class=" sticky-top ">
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}">${message}</div>
    </c:if>
</div>

<!-- banner slide -->
<div id="carouselExampleIndicators" class="carousel slide"
     data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0"
            class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="<c:url value='/template/image/banner_3.jpg' />"
                 class="d-block w-100" alt="...">

        </div>
        <div class="carousel-item">
            <img src="<c:url value='/template/image/Banner-2.jpg' /> "
                 class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img
                    src="<c:url value='/template/image/pngtree-green-fresh-banner1.jpg ' />"
                    class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="<c:url value='/template/image/baner 4.jpg' />"
                 class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button"
            data-target="#carouselExampleIndicators" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
            class="sr-only">Previous</span>
    </button>
    <button class="carousel-control-next" type="button"
            data-target="#carouselExampleIndicators" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span> <span
            class="sr-only">Next</span>
    </button>
</div>
<!-- banner slide -->

<!-- luoi product -->

<div class="container" style="margin-top: 20px; margin-bottom: 20px;">
    <div class="hot">
        <h2 class="mb-5">
            Sản Phẩm Mới Nhất <img
                src="<c:url value='/template/image/sanpanhot.png' /> " alt="">
        </h2>
    </div>
    <form action="<c:url value='/trang-chu'/>" id="formSubmit"
          method="get">
        <div class="row">
            <c:forEach var="item" items="${model.listResult}">
                <div class="col-md-3 col-sm-6">
                    <div class="card text-center" style="margin-bottom: 20px;">
                        <input type="hidden" value="${item.id}" id="product_${item.id}"/>
                        <img class="card-img-top" style="height : 190px;  " src="${item.codeImg}" alt="">
                        <div class="card-body">
                            <h6 class="card-title">${item.name}</h6>
                            <p class="card-text">
                            <h6>Giá: <fmt:formatNumber type="currency" currencySymbol="" maxFractionDigits="0"
                                                       value="${item.price}"></fmt:formatNumber>VND</h6>
                            <c:url var="productDetails" value="/productDetails">
                                <c:param name="id" value="${item.id}"/>
                            </c:url>
                            <a class="btn btn-sm btn-info" href='${productDetails}'>Chi tiết</a>
                            <button id="btnAdd" type="button" class="btn btn-sm btn-success"
                                    onclick="addToCart(${item.id})">
                                Chọn
                            </button>

                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </form>
</div>


<!-- form the bolg -->
<div class="container">
    <div class="Feature-Product">
        <h2>From The Blog</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
    </div>
</div>
<!-- luoi blog -->
<img src="./img/anhbia.svg" alt="Ảnh trường ĐH GTVT" width="100%"/>
<div class="header-link">
    <div></div>
    <div><a href="">Lịch công tác</a></div>
    <div><a href="">Tài liệu</a></div>
    <div><a href="">Tra cứu điểm</a></div>
    <div><a href="">Khảo sát</a></div>
    <div><a href="">Đảng - Đoàn thể</a></div>
    <div><a href="">Hỗ trợ CNTT</a></div>
    <div></div>
</div>
<div class="empty2"></div>
<div class="section1">
    <div class="tintuccha">
        <h1>TIN TỨC</h1>
        <br/>
        <div class="tintuc">
            <div>
                <a href=""><img src="/img/ssung.jpg" alt="" height="220px"/></a>
                <br/>
                <a href=""
                >Sinh viên Khoa Điện - Điện tử tham gia sự kiện Samsung SRV Open
                    Day 2023</a
                >
            </div>
            <div>
                <a href=""
                ><img src="/img/chinhsach.png" alt="" height="220px"
                /></a>
                <br/>
                <a href=""
                >Thực hiện chế độ chính sách sinh viên học kỳ I năm học
                    2023-2024</a
                >
            </div>
            <div>
                <a href=""><img src="/img/kiniem.jpg" alt="" height="220px"/></a
                ><br/>
                <a href=""
                >Thư cảm ơn: Kỷ niệm 25 năm thành lập khoa Điện - Điện tử
                </a>
            </div>
        </div>
    </div>
    <div class="sukien">
        <h1>SỰ KIỆN</h1>

        <div class="sukiencon">
            <a href=""
            ><img src="/img/1111.png" alt="" width="80px"/>
                <p>Lễ kỷ niệm 25 năm thành lập Khoa</p></a
            ><br/>
            <a href=""
            ><img src="/img/0411.png" alt="" width="80px"/>
                <p>
                    Hội thảo Khoa học Công nghệ mới và ứng dụng trong lĩnh vực Điện
                    - Điện tử - Tự động hóa
                </p></a
            ><br/>
            <a href=""
            ><img src="/img/311.png" alt="" width="80px"/>
                <p>
                    Kỷ niệm 25 năm thành lập Khoa Điện-Điện tử
                    (03/11/1998-03/11/2023) và 55 đào tạo (1968-2023)
                </p></a
            ><br/>
            <a href=""
            ><img src="/img/2610.png" alt="" width="80px"/>
                <p>
                    Hội nghị Chuyển đổi số: Công nghệ và ứng dụng trong lĩnh vực
                    Giao thông vận tải
                </p></a
            ><br/>
            <a href=""
            ><img src="/img/1905.png" alt="" width="80px"/>
                <p>
                    Hội thảo khoa học "Công nghệ Điện - Điện tử - Tự động hóa và ứng
                    dụng trong lĩnh vực giao thông"
                </p></a
            ><br/>
        </div>
    </div>
</div>
<div class="empty"></div>
<div class="tuyenmem">
    <h1>TIN TUYỂN SINH</h1>
    <div>
        <div class="tuyensinh1 row">
            <a href=""
            ><img src="/img/1.png" alt="" width="340px"/>
                <p>
                    Thông tin tuyển sinh đại học chính quy Khoa Điện - Điện tử năm
                    2023
                </p></a
            >
            <a href=""
            ><img src="/img/2.png" alt="" width="340px"/>
                <p>Ngành Kỹ thuật Điện năm 2023</p></a
            >
            <a href=""
            ><img src="/img/3.png" alt="" width="340px"/>
                <p>Ngành Kỹ thuật điện tử - viễn thông năm 2023</p></a
            >
        </div>
        <br/>
        <div class="tuyensinh2 row">
            <img src="<c:url value='/template/image/5.png' />"
                 class="d-block w-100" width="340px" alt="...">
            <p>Ngành Kỹ thuật Robot và trí tuệ nhân tạo năm 2023</p>

            <img src="<c:url value='/template/image/6.png' />"
                 class="d-block w-100" width="540px" alt="...">
            <p>Ngành Hệ thống giao thông thông minh (iTS) năm 2023</p>
        </div>
    </div>
</div>
<div class="empty2"></div>
<div class="sukien">
    <h1>SỰ KIỆN</h1>

    <img src="/img/chaotan.svg" alt="" width="1110px"/>
    <div class="empty2"></div>
    <div class="sukien2 row">
        <img src="<c:url value='/template/image/cuocthi/1.svg' />"
             class="d-block w-100" width="540px"  alt="...">
        <img src="<c:url value='/template/image/cuocthi/2.svg' />"
             class="d-block w-100" width="540px"  alt="...">
    </div>
    <div class="sukien2 row">
        <img src="<c:url value='/template/image/cuocthi/3.svg' />"
             class="d-block w-100" width="540px"  alt="...">
        <img src="<c:url value='/template/image/cuocthi/4.svg' />"
             class="d-block w-100" width="540px" alt="...">
    </div>
</div>
<div class="empty2"></div>


<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- footer -->

<script>


    function addToCart(data) {
//		alert(data);
        $.ajax({
            url: '${addProductCart}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                alert("SUCCESS : Thêm Thành Công !");
            },
            error: function (error) {
                alert("ERROR : Vui Lòng Thêm Lại !");
            }
        });
    }
</script>

<script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
<script src="<c:url value='/template/web/js/bootstrap.min.js' /> "></script>
<script
        src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js">

</script>
<script
        src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
        src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>

</body>

</html>