<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/6/2021
  Time: 8:36 PM
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
    <h2>ADD New Contract</h2>
    <form action="/contract" method="post">
        <input type="hidden" name="action" value="create">
        <div>
            <div class="form-group">
                <label class="mt-2">Star Date :</label>
                <input class="form-control" type="date" name="starDate" style="width: 80%" value="${contract.starDate}">

                <label class="mt-2">End Date :</label>
                <input class="form-control" type="date" name="endDate" style="width: 80%" value="${contract.endDate}">

                <label class="mt-2">Deposit:</label>
                <input class="form-control" type="text" name="deposit" aria-describedby="deposit" style="width: 80%" value="${contract.deposit}">
                <c:if test="${messDeposit != null}">
                    <small id="deposit" class="form-text text-danger">${messDeposit}</small>
                </c:if>

                <label>Total Money :</label>
                <input class="form-control" type="text" name="totalMoney" aria-describedby="totalMoney" style="width: 80%" value="${contract.totalMoney}">
                <c:if test="${messTotalMoney != null}">
                    <small id="totalMoney" class="form-text text-danger">${messDeposit}</small>
                </c:if>

                <label class="mt-2">Employee Id :</label>
                <input class="form-control" type="text" name="employeeId" style="width: 80%" value="${contract.employeeId}">

                <label class="mt-2">Customer Id:</label>
                <input class="form-control" type="text" name="customerId" style="width: 80%" value="${contract.customerId}">

                <label class="mt-2">Service Id :</label>
                <input class="form-control" type="text" name="serviceId" style="width: 80%" value="${contract.serviceId}">
            </div>
        </div>

        <div class="mt-2">
            <input class="btn btn-success" type="submit" value="Create"> |
            <a class="btn btn-dark" href="/contract" role="button">Back</a>
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
