package com.restbucks;

import java.util.ArrayList;

public class Order {
	
	private String id;
	private boolean takeAway = true;
	private ArrayList<Item> items;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isTakeAway() {
		return takeAway;
	}
	public void setTakeAway(boolean toGo) {
		this.takeAway = toGo;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
