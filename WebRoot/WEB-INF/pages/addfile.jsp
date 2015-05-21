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
<title>My JSP 'addfile.jsp' starting page</title>
</head>

<body style="text-align: center;width:40%;margin:0 auto;">


	<form action="servlet/UpfileServlet" method="post"enctype="multipart/form-data">

		<table border="1" frame="border">
		
		
			<tr>
				<td>上传用户：</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="file" name="file" /></td>
			</tr>

			<tr>
				<td>文件描述：</td>
				<td><textarea rows="5" cols="50" name="description"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="提交" /></td>
			</tr>

		</table>
	</form>

</body>
</html>
