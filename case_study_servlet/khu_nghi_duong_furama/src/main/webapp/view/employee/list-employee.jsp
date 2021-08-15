<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/6/2021
  Time: 3:47 PM
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

<div class="container-fluid mt-3">
    <h1 class="text-center">Employee List</h1>
    <c:if test="${empty employeeList}">
        <h3 style="color: red">Employee List Empty</h3>
    </c:if>

    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand btn btn-primary mb-2 text-white" href="/employee?action=create" role="button"> + Create
            Employee</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="navbar-nav mr-auto"></div>
            <form class="form-inline my-2 my-lg-0" action="/employee" method="post">
                <input type="hidden" name="action" value="search">
                <input name="name" class="form-control me-2 mr-1" type="search" placeholder="Search"
                       aria-label="Search">

                <button class="btn btn-info text-white" type="submit">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="14" fill="currentColor"
                                 class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                            </svg>
                        </li>
                        <li class="nav-item pl-2">
                            Search
                        </li>
                    </ul>
                </button>
            </form>
        </div>
    </nav>

    <c:if test="${not empty employeeList}">
        <div class="container-fluid">
            <table id="tableEmployee" class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th class="align-middle">Id</th>
                    <th class="align-middle">Name</th>
                    <th class="align-middle">Birthday</th>
                    <th class="align-middle">Id Card</th>
                    <th class="align-middle">Salary</th>
                    <th class="align-middle">Phone</th>
                    <th class="align-middle">Address</th>
                    <th class="align-middle">Position</th>
                    <th class="align-middle">Education Degree</th>
                    <th class="align-middle">Division</th>
                    <th class="align-middle">Username</th>
                    <th class="align-middle text-center">Delete</th>
                    <th class="align-middle text-center">Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employeeList}" var="employee">
                    <tr>
                        <td class="align-middle">${employee.id}</td>
                        <td class="align-middle">${employee.name}</td>
                        <td class="align-middle">${employee.birthday}</td>
                        <td class="align-middle">${employee.idCard}</td>
                        <td class="align-middle">${employee.salary}</td>
                        <td class="align-middle">${employee.phone}</td>
                        <td class="align-middle">${employee.address}</td>
                        <td class="align-middle">${employee.position}</td>
                        <td class="align-middle">${employee.educationDegree}</td>
                        <td class="align-middle">${employee.division}</td>
                        <td class="align-middle">${employee.username}</td>
                        <td class="align-middle">
                            <button onclick="onDelete(${employee.id})" type="button" class="btn btn-danger"
                                    data-toggle="modal" data-target="#exampleModal">
                                Delete
                            </button>
                        </td>

                        <td class="align-middle">
                            <a class="btn btn-success" href="/employee?action=edit&id=${employee.id}" role="button">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/employee" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="isEmployeeDel">
                <div class="modal-body">
                    Are you sure delete ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function onDelete(id) {
        document.getElementById("isEmployeeDel").value = id;
    }
</script>
<script src="../assert/jquery/jquery-3.5.1.min.js"></script>
<script src="assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assert/jquery/popper.min.js"></script>
<script src="../assert/bootstrap4/js/bootstrap.js"></script>

<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
