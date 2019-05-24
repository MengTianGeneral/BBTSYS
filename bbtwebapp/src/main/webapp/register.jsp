<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/24
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/regist" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>微信号</td>
            <td><input type="text" name="wechatid"></td>
        </tr>


        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
    </table>
</form>


</body>
</html>
