<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="util.DBHelper"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.ArrayList"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>creatitem</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style1.css" />
<style type="text/css">
hr {
	border-color: FF7F00;
}

div {
	float: left;
	margin: 10px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}
</style>
</head>

<body>
		
	<h1>创建商品（管理员）</h1>
	<a href="adminindex.jsp">首页</a> >> 创建商品
	<hr>
	<center>
		<form method="post" action="servlet/ItemServlet" name="creatitem">
			<table border="1" cellpadding="0" cellspacing="0"
				style="border-collapse: collapse" bordercolor="#C0C0C0" width="300">
				<tr>
					<td width="100%" bgcolor="#C0C0C0" align="center"><font
						color="#0000FF">创建商品</font></td>
				</tr>
				<tr>
					<td align="center">名字:<input type="text" name="name"><br>
						产地:<input type="text" name="city"><br> 价格:<input
						type="text" name="price"><br> 数量:<input type="text"
						name="number"><br> 图片:<input type="text"
						name="picture"><br> <input type="submit" value="提 交"><input type="hidden" name="acc" value="creat"> 
					</td>
				</tr>
			</table>
		</form>

	</center>
	<div id="footer">
		Copyright <a href="http://kuro1.com" target="_blank">kuro1</a> &copy;
		2015
	</div>
</body>
</html>
