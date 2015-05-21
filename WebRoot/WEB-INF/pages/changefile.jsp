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
<title>My JSP 'changefile.jsp' starting page</title>
</head>

<body>


	<form action="servlet/ChagenFileServlet?id=${upfile.id }" method="post">
		<table>
			<tr>
				<td>上传者:</td>
				<td><input type="text" name="username"
					value="${upfile.username }" /></td>
			</tr>

			<tr>
				<td>文件名字：</td>
				<td><input type="text" name="filename"
					value="${upfile.filename }" /></td>
			</tr>

			<tr>
				<td>文件描述:</td>
				<td><textarea rows="5" cols="50" name="description">${upfile.description }</textarea>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="提交" />
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>
