<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>index</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	<h1>商品</h1>
	<a href="index.jsp">首页</a> >> 商品列表 &nbsp;&nbsp;&nbsp;
	<!-- 	<a href="creatitem.jsp">添加商品</a>&nbsp;&nbsp;&nbsp; -->
	<a href="cart.jsp">购物清单</a>&nbsp;&nbsp;&nbsp;
	<a href="cartlist.jsp">历史清单</a>
	<hr>

	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<td>
					<!-- 商品循环开始 --> <% 
               ItemsDAO itemsDao = new ItemsDAO(); 
               ArrayList<Items> list = itemsDao.getAllItems();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Items item = list.get(i);
           %>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=item.getId()%>"><img
									src="images/<%=item.getPicture()%>" width="120" height="90"
									border="1" /></a>
							</dt>
							<dd class="dd_name"><%=item.getName() %></dd>
							<dd class="dd_city">
								产地:<%=item.getCity() %>&nbsp;&nbsp;价格:￥
								<%=item.getPrice() %></dd>
						</dl>
					</div> <!-- 商品循环结束 --> <%
                   }
              } 
          %>
				</td>
			</tr>
		</table>
	</center>
	<div id="footer">
		Copyright <a href="http://kuro1.com" target="_blank">kuro1</a> &copy;
		2015  <a href="adminindex.jsp" >管理员</a>
	</div>
</body>
</html>
