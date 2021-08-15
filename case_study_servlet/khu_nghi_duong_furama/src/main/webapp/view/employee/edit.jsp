<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/6/2021
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assert/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<jsp:include page="/layout1/header.jsp"></jsp:include>

<div class="container-fluid mt-2">
    <h2>Edit Employee</h2>
    <form action="/employee" method="post">
        <input type="hidden" name="action" value="edit">
        <div>
            <div class="form-group">
                <input type="hidden" name="id" style="width: 80%" value="${employee.id}">

                <label class="mt-2">Name :</label>
                <input class="form-control" type="text" name="name" style="width: 80%" value="${employee.name}">

                <label class="mt-2">Birthday :</label>
                <input class="form-control" type="date" name="birthday" style="width: 80%" value="${employee.birthday}">

                <label class="mt-2">Id Card :</label>
                <input class="form-control" type="text" name="idCard" style="width: 80%" value="${employee.idCard}">
                <c:if test="${messIdCard != null}">
                    <small id="idCard" class="form-text text-danger">${messIdCard}</small>
                </c:if>

                <label>Salary :</label>
                <input class="form-control" type="text" name="salary" style="width: 80%" value="${employee.salary}">
                <c:if test="${messSalary != null}">
                    <small id="salary" class="form-text text-danger">${messSalary}</small>
                </c:if>

                <label class="mt-2">Phone :</label>
                <input class="form-control" type="text" name="phone" style="width: 80%" value="${employee.phone}">
                <c:if test="${messPhone != null}">
                    <small id="phone" class="form-text text-danger">${messPhone}</small>
                </c:if>

                <label class="mt-2">Email :</label>
                <input class="form-control" type="text" name="email" style="width: 80%" value="${employee.email}">
                <c:if test="${messEmail != null}">
                    <small id="email" class="form-text text-danger">${messEmail}</small>
                </c:if>

                <label class="mt-2">Address :</label>
                <input class="form-control" type="text" name="address" style="width: 80%" value="${employee.address}">

                <label class="mt-2">Position Id :</label>
                <select class="form-control" name="positionId" style="width: 80%">
                    <option value="1" ${employee.positionId == 1 ? 'selected': ''}>Giám đốc</option>
                    <option value="2" ${employee.positionId == 2 ? 'selected': ''}>Phó Giám Đốc</option>
                    <option value="3" ${employee.positionId == 3 ? 'selected': ''}>Quản Lý</option>
                    <option value="4" ${employee.positionId == 4 ? 'selected': ''}>Trưởng Phòng</option>
                    <option value="5" ${employee.positionId == 5 ? 'selected': ''}>Trưởng Nhóm</option>
                    <option value="6" ${employee.positionId == 6 ? 'selected': ''}>Nhân Viên</option>
                </select>

                <label class="mt-2">Education Degree Id :</label>
                <select class="form-control" name="educationDegreeId" style="width: 80%">
                    <option value="1" ${employee.educationDegreeId == 1 ? 'selected': ''}>Đại học</option>
                    <option value="2" ${employee.educationDegreeId == 2 ? 'selected': ''}>Cao Đẳng</option>
                    <option value="3" ${employee.educationDegreeId == 3 ? 'selected': ''}>Trung Cấp</option>
                    <option value="4" ${employee.educationDegreeId == 4 ? 'selected': ''}>Khác</option>
                </select>

                <label class="mt-2">Division Id :</label>
                <select class="form-control" name="divisionId" style="width: 80%">
                    <option value="1" ${employee.divisionId == 1 ? 'selected': ''}>Lễ Tân</option>
                    <option value="2" ${employee.divisionId == 2 ? 'selected': ''}>Buồng Phòng</option>
                    <option value="3" ${employee.divisionId == 3 ? 'selected': ''}>Ẩm Thực</option>
                    <option value="4" ${employee.divisionId == 4 ? 'selected': ''}>Kinh Doanh</option>
                    <option value="5" ${employee.divisionId == 5 ? 'selected': ''}>Hành chính - Nhân Sự</option>
                    <option value="6" ${employee.divisionId == 6 ? 'selected': ''}>Tài Chính Kế Toán</option>
                    <option value="7" ${employee.divisionId == 7 ? 'selected': ''}>Kỹ Thuật</option>
                    <option value="8" ${employee.divisionId == 8 ? 'selected': ''}>An ninh</option>
                </select>

                <label class="mt-2">Username :</label>
                <input class="form-control" type="text" name="username" style="width: 80%" value="${employee.username}">
            </div>
        </div>

        <div class="mt-2">
            <input class="btn btn-success" type="submit" value="Edit"> |
            <a class="btn btn-dark" href="/employee" role="button">Back</a>
        </div>
    </form>
</div>

<script src="../assert/jquery/jquery-3.5.1.min.js"></script>
<script src="assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assert/jquery/popper.min.js"></script>
<script src="../assert/bootstrap4/js/bootstrap.js"></script>

</body>
</html>
