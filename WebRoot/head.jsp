<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>页头</title>

  </head>
  
  <body style="text-align: center;">
  	<h1>文件上传与下载</h1>
  
    <a href="servlet/UpfileServlet" target="main">上传文件</a>
    <a href="servlet/ListFileServlet" target="main">下载文件</a>
  </body>
</html>
