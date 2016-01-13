package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action;//表示购物车的动作,add,show,delete
	//商品业务逻辑类的对象
	private ItemsDAO iDao = new ItemsDAO();
	public CartServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		if (request.getParameter("action")!=null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) {//如果是添加商品进购物车
				if (addTocart(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			if (action.equals("show")) {//如果是显示购物车
//				showCart(request, response);
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			if (action.equals("delete")) {
				if (deleteFormCart(request, response)) {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * 从购物车里面删除商品
	 */
	private boolean deleteFormCart(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Items items = iDao.getItemsById(Integer.parseInt(id));
		if (cart.removeGoodsFromCart(items)) {
			return true;
		}
		return false;
	}

	/**
	 * @param request
	 * @param response
	 * 添加商品进购物车的方法
	 */
	private boolean addTocart(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = iDao.getItemsById(Integer.parseInt(id));
		
		//是否是第一次给购物车添加商品，需要给session中创建一个新的购物车对象
		if (request.getSession().getAttribute("cart")==null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
