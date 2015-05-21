<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'listfile.jsp' starting page</title>
    
    <style>
    	table {
    		width:70%;margin:0 auto;text-align: center;
    	}
    </style>
    
  </head>
  
  <body style="text-align: center;">


	<table border="1">
		<tr>
			<td>文件名字</td>
			<td>上传时间</td>
			<td>文件描述</td>
			<td>上传者</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="upfile" items="${list }">
			<tr>
				<td style="width:200px;">${upfile.filename }</td>
				<td>${upfile.uptime }</td>
				<td>${upfile.description }</td>
				<td>${upfile.username }</td>
				<td>
					<a href="servlet/DownLoadServlet?id=${upfile.id }">下载</a>
					<a href="servlet/ChagenFileServlet?id=${upfile.id }">修改文件</a>
					<a href="servlet/DeleteFileservlet?id=${upfile.id }">删除</a>
				</td>
			</tr>
			
			
		</c:forEach>
		
		
	</table>
	
	<a style="display: inline-block;margin:20px 0 0 0 ;padding:5px 5px;background:yellow;border-radius:5px;" href="<%=basePath%>servlet/AllFileServlet">文件汇总报告</a>


  </body>
</html>
