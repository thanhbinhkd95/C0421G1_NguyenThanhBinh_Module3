<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/6/2021
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assert/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<jsp:include page="/layout1/header.jsp"></jsp:include>

<div class="container-fluid mt-2">
    <h2>ADD New Service</h2>
    <form action="/service" method="post">
        <input type="hidden" name="action" value="create">
        <div>
            <div class="form-group">
                <label class="mt-2">Code :</label>
                <input class="form-control" type="text" name="code" aria-describedby="code" style="width: 80%" value="${service.code}">
                <c:if test="${messCode != null}">
                    <small id="code" class="form-text text-danger">${messCode}</small>
                </c:if>

                <label class="mt-2">Name :</label>
                <input class="form-control" type="text" name="name" style="width: 80%" value="${service.name}">

                <label class="mt-2">Area:</label>
                <input class="form-control" type="text" name="area" aria-describedby="area" style="width: 80%" value="${service.area}">
                <c:if test="${messArea != null}">
                    <small id="area" class="form-text text-danger">${messArea}</small>
                </c:if>

                <label>Cost :</label>
                <input class="form-control" type="text" name="cost" aria-describedby="cost" style="width: 80%" value="${service.cost}">
                <c:if test="${messCost != null}">
                    <small id="cost" class="form-text text-danger">${messCost}</small>
                </c:if>

                <label class="mt-2">Max People :</label>
                <input class="form-control" type="text" name="maxPeople" aria-describedby="maxPeople" style="width: 80%" value="${service.maxPeople}">
                <c:if test="${messMaxPeople != null}">
                    <small id="maxPeople" class="form-text text-danger">${messMaxPeople}</small>
                </c:if>

                <label class="mt-2">Rent Type Id :</label>
                <input class="form-control" type="text" name="rentTypeId" style="width: 80%" value="${service.rentTypeId}">

                <label class="mt-2">Service Type Id :</label>
                <input class="form-control" type="text" name="serviceTypeId" style="width: 80%" value="${service.serviceTypeId}">

                <label class="mt-2">Standard Room :</label>
                <input class="form-control" type="text" name="standardRoom" style="width: 80%" value="${service.standardRoom}">

                <label class="mt-2">Description:</label>
                <input class="form-control" type="text" name="description" style="width: 80%" value="${service.description}">

                <label class="mt-2">Pool Area</label>
                <input class="form-control" type="text" name="poolArea" aria-describedby="poolArea" style="width: 80%" value="${service.poolArea}">
                <c:if test="${messPoolArea != null}">
                    <small id="poolArea" class="form-text text-danger">${messPoolArea}</small>
                </c:if>

                <label class="mt-2">Number Floor :</label>
                <input class="form-control" type="text" name="numberFloor" aria-describedby="numberFloor" style="width: 80%" value="${service.numberFloor}">
                <c:if test="${messNumberFloor != null}">
                    <small id="numberFloor" class="form-text text-danger">${messNumberFloor}</small>
                </c:if>
            </div>
        </div>

        <div class="mt-2">
            <input class="btn btn-success" type="submit" value="Create"> |
            <a class="btn btn-dark" href="/service" role="button">Back</a>
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
