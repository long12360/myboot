<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<body>
<h2>测试页面</h2>
<h1><a href="test">test</a></h1>
<h2><a href="login.jsp">login</a></h2>
</body>
</html>
