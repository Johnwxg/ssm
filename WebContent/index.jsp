<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta http-equiv="pragma" content="no-cache">  
<meta http-equiv="cache-control" content="no-cache">  
<meta http-equiv="expires" content="0">      
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
<meta http-equiv="description" content="This is my page">  
</head>
<body>
    <center>  
        <h1>用户登录</h1>  
        <s:a action="user_addUI" namespace="/user">添加新用户</s:a>  
        <s:form action="user_login" namespace="/user" method="post">  
            <s:textfield label="用户名" name="user.usernm"></s:textfield>  
            <s:password label="密码" name="user.pwd"></s:password>  
            <s:submit value="登录"></s:submit>  
        </s:form>  
    </center>  
</body>
</html>