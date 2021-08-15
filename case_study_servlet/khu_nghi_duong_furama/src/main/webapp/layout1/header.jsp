<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/5/2021
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row container-fluid">
    <div class="col-sm-3 align-self-center justify-content-center">
        <a href="/view/home.jsp">
            <img class="img-fluid ml-5 pt-2 pb-2" src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png"
                 height="120" width="70"/>
        </a>
    </div>

    <div class="col-sm-3 justify-content-center align-self-center">
        <a> <img class="img-fluid" src="/assert/img/logo.png"/></a>
    </div>

    <div class="col-sm-3 justify-content-center align-self-center">
        103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam
        7.0 km từ Sân bay Quốc tế Đà Nẵng
    </div>

    <div class="col-sm-3 text-right align-self-center">
        Sơn Trà
    </div>
</div>

<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://furamavietnam.com/wp-content/uploads/2019/07/Vietnam_Danang_Furama_Resort_Exterior_Ocean-Pool-6.jpg"
                 class="d-block w-100 h-75" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg"
                 class="d-block w-100 h-75" alt="...">
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #0F574B;">

    <a class="navbar-brand text-white mx-5" href="/view/home.jsp">Home</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item mx-5 ">
                <a class="nav-link text-white" href="/employee">Employee</a>
            </li>

            <li class="nav-item mx-3 ">
                <a class="nav-link text-white" href="/customer">Customer</a>
            </li>

            <li class="nav-item mx-3 ">
                <a class="nav-link text-white" href="/service">Service</a>
            </li>

            <li class="nav-item mx-3 ">
                <a class="nav-link text-white" href="/contract">Contract</a>
            </li>

            <li class="nav-item mx-3 ">
                <a class="nav-link text-white" href="/contractDetail">Contract detail</a>
            </li>
        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-light btn-light text-dark my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

</body>
</html>
