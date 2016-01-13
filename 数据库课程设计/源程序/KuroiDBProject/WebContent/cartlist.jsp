<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Cart"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>cart</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style1.css" />
<script language="javascript">
	function delcfm() {
		if (!confirm("确认要删除？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<h1>历史清单</h1>
	<a href="index.jsp">首页</a> >> 历史清单
	<hr>
	<div id="shopping">
		<form action="" method="POST">
			<table>
				<tr>
					<th>编号</th>
					<th>日期</th>
					<th>金额</th>
					<th>操作</th>
				</tr>
				<!-- 循环的开始 -->
				<%
					ItemsDAO itemsDao = new ItemsDAO();
					ArrayList<Cart> list = itemsDao.getAllCarts();
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							Cart cart = list.get(i);
				%>
				<tr id="product_id_2">
					<td class="number"><%=cart.getId()%></td>
					<td class="number"><%=cart.getDate()%></td>
					<td class="number"><%=cart.getTotalPrice()%></td>
					<td class="delete"><a
						href="servlet/ItemServlet?acc=deletecart&id=<%=cart.getId()%>"
						onclick="delcfm();">删除</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</form>
	</div>
	<div id="footer">
		Copyright <a href="http://kuro1.com" target="_blank">kuro1</a> &copy;
		2015
	</div>
</body>
</html>
