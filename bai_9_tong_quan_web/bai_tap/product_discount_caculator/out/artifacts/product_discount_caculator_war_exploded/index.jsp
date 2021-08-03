<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/25/2021
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Product Discount Caculator</h2>
<form action="/productDiscount" method="post">
    <br>
    <label>Mô tả sản phẩm : </label><br/>
    <input type="text" name="description" placeholder="Input Description"><br/>
    <label>Giá niêm yết : </label><br/>
    <input type="number" name="price" placeholder="Input Price"/><br/>
    <label>Tỷ lệ chiết khấu phần trăm : </label><br/>
    <input type="number" name="percent"/><br/>
    <input type="submit" id="submit" value="Calculate Discount"/>
</form>

</body>
</html>
