package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart {
	// ������Ʒ�ļ���
	private HashMap<Items, Integer> goods;
	// ���ﳵ���ܽ��
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
	
	//�����Ʒ�����ﳵ�ķ���
	public boolean addGoodsInCart(Items item, int number){
		if (goods.containsKey(item)) {
			goods.put(item, goods.get(item)+number);
		}else {
			goods.put(item, number);
		}		
		calTotalPrice();//���¼��㹺�ﳵ�ܽ��
		return true;
	}
	//ɾ����Ʒ�ķ���
	public boolean removeGoodsFromCart(Items item){
		goods.remove(item);
		calTotalPrice();//���¼��㹺�ﳵ�ܽ��
		return true;
	}
	//ͳ�ƹ��ﳵ���ܽ��
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Items> keys = goods.keySet();//��ü��ļ���
		Iterator<Items> it = keys.iterator();//��õ���������
		while (it.hasNext()) {
			Items i = it.next();
			sum += i.getPrice()*goods.get(i);
		}
		this.setTotalPrice(sum);//���ù��ﳵ���ܽ��
		return sum;
	}
}
