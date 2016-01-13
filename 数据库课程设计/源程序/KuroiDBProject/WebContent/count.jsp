<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%@ page
	import="org.jfree.chart.ChartFactory,org.jfree.chart.JFreeChart,
	java.awt.Font,
	org.jfree.chart.axis.CategoryAxis,
	org.jfree.chart.axis.CategoryLabelPositions,
	org.jfree.chart.plot.PlotOrientation,
org.jfree.chart.servlet.ServletUtilities,
org.jfree.data.category.DefaultCategoryDataset,
org.jfree.chart.StandardChartTheme"%>
<%@ page import="org.jfree.chart.*,org.jfree.chart.plot.*,org.jfree.chart.labels.*,
org.jfree.data.category.*,java.awt.*,org.jfree.ui.*,org.jfree.chart.renderer.category.BarRenderer3D,
org.jfree.chart.servlet.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存统计</title>
</head>
<body>
	<h1>库存统计（管理员）</h1>
	<a href="adminindex.jsp">首页</a> >> 库存统计
	<hr>
	<%
               ItemsDAO itemsDao = new ItemsDAO(); 
               ArrayList<Items> list = itemsDao.getAllItems();
               DefaultCategoryDataset dataset = new DefaultCategoryDataset();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Items item = list.get(i);
	                  dataset.addValue(item.getNumber(), item.getCity(), item.getName());
	               }
               }
             //创建主题样式  
               StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
               //设置标题字体  
               standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
               //设置图例的字体  
               standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
               //设置轴向的字体  
               standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
               //应用主题样式  
               ChartFactory.setChartTheme(standardChartTheme);  
               JFreeChart chart = ChartFactory.createBarChart3D("库存统计图",
                       "商品",
                       "库存",
                       dataset,
                       PlotOrientation.VERTICAL,
                       false,
                       false,
                       false);
               CategoryPlot plot = chart.getCategoryPlot(); 
               CategoryAxis categoryAxis = plot.getDomainAxis();
               // 横轴上的 Lable 90度倾斜
               categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
             //设置网格背景颜色
             plot.setBackgroundPaint(Color.white);
             //设置网格竖线颜色
             plot.setDomainGridlinePaint(Color.pink);
             //设置网格横线颜色
             plot.setRangeGridlinePaint(Color.pink);
              
             //显示每个柱的数值，并修改该数值的字体属性
             BarRenderer3D renderer = new BarRenderer3D();
             renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
             renderer.setBaseItemLabelsVisible(true);
              
             //默认的数字显示在柱子中，通过如下两句可调整数字的显示
             //注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
             renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
             renderer.setItemLabelAnchorOffset(10D);
           //设置每个地区所包含的平行柱的之间距离
             renderer.setItemMargin(0.4);
             plot.setRenderer(renderer);
             
     String filename = ServletUtilities.saveChartAsPNG(chart, 420, 300, null, session);
     String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;
    %>
	<img src="<%= graphURL %>" width=50% height=50% border=0>
</body>
</html>