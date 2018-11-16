package com.VendingHibernate;

public class SubItemDesc {
	String PName;
	String name;
	int price;
	int id;
	public SubItemDesc() {}
	public SubItemDesc(String PName,String name, int price) {
		super();
		this.name = name;
		this.price = price;
		this.PName = PName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
