<%--
  Created by IntelliJ IDEA.
  User: long_12360
  Date: 2019/8/29
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="login" method="post">
      <jsp:include page="token.jsp"/>
      <p>用户名：<input type="text" name="user"/></p>
      <p>密码：<input type="password" name="pwd"/></p>
      <p><input type="submit" value="登陆"/></p>


  </form>

</body>
</html>
