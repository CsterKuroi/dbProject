package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cart;
import entity.Items;
import util.DBHelper;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String acc=request.getParameter("acc").toString();
		if (acc.equals("creat"))
		{
			String name=request.getParameter("name").toString();
			String city=request.getParameter("city").toString();
			String price=request.getParameter("price").toString();
			String number=request.getParameter("number").toString();
			String picture=request.getParameter("picture").toString();
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				PrintWriter out = response.getWriter();
				conn = DBHelper.getConnection();
				String sql = "insert into items (name,city,price,number,picture) values('" + name + "','" + city + "','" + price + "','" + number +"','" + picture + "')"; 
				out.write(sql);
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
				response.sendRedirect(request.getContextPath()+"/adminindex.jsp");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (acc.equals("modify"))
		{
			String name=request.getParameter("name").toString();
			String city=request.getParameter("city").toString();
			String price=request.getParameter("price").toString();
			String number=request.getParameter("number").toString();
			String picture=request.getParameter("picture").toString();
			String id=request.getParameter("id").toString();
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				PrintWriter out = response.getWriter();
				conn = DBHelper.getConnection();
				String sql = "update items set name='"+ name +"',city='"+city+"',price='"+price+"',number='"+number+"',picture='"+picture+"' where id='"+id+"'";
				out.write(sql);
				stmt = conn.prepareStatement(sql);
				stmt.execute();
				response.sendRedirect(request.getContextPath()+"/adminindex.jsp");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (acc.equals("creatcart"))
		{
			Date date1=new Date(System.currentTimeMillis());
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=format.format(date1);
			String money=request.getParameter("money").toString();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			Cart cart = (Cart)request.getSession().getAttribute("cart");
	         HashMap<Items,Integer> goods = cart.getGoods();
	         Set<Items> items = goods.keySet();
	         Iterator<Items> it = items.iterator();
			try {
				PrintWriter out = response.getWriter();
				conn = DBHelper.getConnection();
				String sql = "insert into carts (date,money) values('"+date+"','"+money+"')";
				out.write(sql);
				stmt = conn.prepareStatement(sql);
				stmt.execute();
				sql = "select id as maxid from carts where id=dbo.func()";
				out.write(sql);
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				rs.next();
				int maxid=rs.getInt("maxid");
				while(it.hasNext())
		         {
		            Items i = it.next();
					sql = "insert into cartitems (cartid,itemid,number) values('"+maxid+"','"+i.getId()+"','"+goods.get(i)+"')";
					out.write(sql);
					stmt = conn.prepareStatement(sql);
					stmt.execute();
		         }
				request.getSession().invalidate();
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (acc.equals("deletecart"))
		{
			int id=Integer.valueOf(request.getParameter("id").toString());
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				PrintWriter out = response.getWriter();
				conn = DBHelper.getConnection();
				String sql = "{call deletecart(?)}";
				out.write(sql);
				stmt = conn.prepareCall(sql);
				stmt.setInt(1,id);
				stmt.execute();
				response.sendRedirect(request.getContextPath()+"/cartlist.jsp");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.doGet(request, response);
	}

}
