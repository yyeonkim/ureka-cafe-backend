package com.shop.cafe.dto;

public class Product {
	
	private int prodCode, price;
	private String prodName, prodImg;
	
	public Product() {} // Controller에서 RequestBody를 받아 역직렬화를 할 경우 디폴트 생성자가 없으면 에러 발생

	public Product(int prodCode, int price, String prodName, String prodImg) {
		this.prodImg = prodImg;
		this.price = price;
		this.prodCode = prodCode;
		this.prodName = prodName;
	}

	public int getProdCode() {
		return prodCode;
	}

	public int getPrice() {
		return price;
	}

	public String getProdName() {
		return prodName;
	}

	public String getProdImg() {
		return prodImg;
	}

	@Override
	public String toString() {
		return "Product [prodCode=" + prodCode + ", price=" + price + ", prodName=" + prodName + ", prodImg=" + prodImg
				+ "]";
	}
}
