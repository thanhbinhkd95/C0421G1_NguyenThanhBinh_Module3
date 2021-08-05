<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2021
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1{
            text-align: center;
            height: 70px;
        }
        table{
            width: 100%;
            border-collapse: collapse;
        }
        img{
            width: 50px;
            height: 50px;
        }
        th{
            width: 25%;
            border-bottom: 1px solid grey;
        }
        td{
            border-bottom: 1px solid grey;
        }
        tr{
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Danh Sách Khách Hàng</h1>
    <table>
        <thead>
            <tr>
                <th>Tên</th>
                <th>Ngày Sinh</th>
                <th>Địa chỉ</th>
                <th>Ảnh</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.name}</td>
                    <td>${customer.birthday}</td>
                    <td>${customer.address}</td>
                    <td><img src="${customer.img}"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
