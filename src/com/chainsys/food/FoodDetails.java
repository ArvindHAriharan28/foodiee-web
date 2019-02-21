package com.chainsys.food;

public class FoodDetails {

	private int id;
	private String name;
	private String category;
	private int price;
	private int availability;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "FoodDetails [id=" + id + ", name=" + name + ", category="
				+ category + ", price=" + price + ", availability="
				+ availability + "]";
	}
	
	
}

