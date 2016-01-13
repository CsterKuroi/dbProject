package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart {
	// 购买商品的集合
	private HashMap<Items, Integer> goods;
	// 购物车的总金额
	private int id;
	private double totalPrice;
	private String date;

	public Cart() {
		goods = new HashMap<Items, Integer>();
		totalPrice = 0.0;
		date="";
	}
	public HashMap<Items, Integer> getGoods() {
		return goods;
	}
	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//添加商品进购物车的方法
	public boolean addGoodsInCart(Items item, int number){
		if (goods.containsKey(item)) {
			goods.put(item, goods.get(item)+number);
		}else {
			goods.put(item, number);
		}		
		calTotalPrice();//重新计算购物车总金额
		return true;
	}
	//删除商品的方法
	public boolean removeGoodsFromCart(Items item){
		goods.remove(item);
		calTotalPrice();//重新计算购物车总金额
		return true;
	}
	//统计购物车的总金额
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Items> keys = goods.keySet();//获得键的集合
		Iterator<Items> it = keys.iterator();//获得迭代器对象
		while (it.hasNext()) {
			Items i = it.next();
			sum += i.getPrice()*goods.get(i);
		}
		this.setTotalPrice(sum);//设置购物车的总金额
		return sum;
	}
}
