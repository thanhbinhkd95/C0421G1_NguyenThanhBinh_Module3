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
    <h2>ADD New Contract Detail</h2>
    <form action="/contractDetail" method="post">
        <input type="hidden" name="action" value="create">
        <div>
            <div class="form-group">
                <label class="mt-2">Contract Id :</label>
                <input class="form-control" type="text" name="contractId" style="width: 80%">

                <label class="mt-2">Attach Service Id</label>
                <input class="form-control" type="text" name="attachServiceId" style="width: 80%">

                <label class="mt-2">Quantity :</label>
                <input class="form-control" type="text" name="quantity" style="width: 80%">
            </div>
        </div>

        <div class="mt-2">
            <input class="btn btn-success" type="submit" value="Create"> |
            <a class="btn btn-dark" href="/contractDetail" role="button">Back</a>
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
