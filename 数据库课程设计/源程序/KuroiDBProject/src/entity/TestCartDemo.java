package entity;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestCartDemo {
	public static void main(String[] args) {
		//先创建两个商品的对象
		Items i1 = new Items(1, "沃特篮球鞋","温州",200, 500, "001.jpg");
		Items i2 = new Items(2, "李宁运动鞋","广州",300, 500, "002.jpg");
		Items i3 = new Items(1, "沃特篮球鞋","温州",200, 500, "001.jpg");
		Cart c = new Cart();
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		//再次购买沃特篮球鞋，购买三双
		c.addGoodsInCart(i3, 3);
		//变量购物商品的集合
		Set<Map.Entry<Items, Integer>> items = c.getGoods().entrySet();
		for (Entry<Items, Integer> entry : items) {
			System.out.println(entry);
		}
		System.out.println("购物车的总金额:"+c.getTotalPrice());
	}
}
