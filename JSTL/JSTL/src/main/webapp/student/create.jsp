<%--
  Created by IntelliJ IDEA.
  User: KILL YOU
  Date: 6/29/2021
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Student</h1>
<form action="/student" method="post">
    <input type="hidden" name="action" value="create">
    <table>
        <tr>
            <td>ID:</td>
            <td>
                <input type="number" name="id">
            </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="number" name="gender">
            </td>
        </tr>
        <tr>
            <td>Point:</td>
            <td>
                <input type="number" name="point">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
