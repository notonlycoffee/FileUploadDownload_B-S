<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'allfile.jsp' starting page</title>
</head>

<body>
	<table border="1" width="50%" style="margin:0 auto;">

		<tr>
			<td>文件扩展名</td>
			<td style="text-align: center;">========</td>
			<td>文件数目</td>
		</tr>
		<c:forEach var="type" items="${type }">



			<tr>
				<td>${type.key }</td>
				<td style="text-align: center;">========</td>
				<td>${type.value }个</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
