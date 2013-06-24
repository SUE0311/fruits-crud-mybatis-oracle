package com.jsnote.model;

public class Fruits {
	
	private int no;
	private String name;
	private int servingSize;
	private double calories;
	private double carbohydrate;
	private double fat;
	private double protein;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getServingSize() {
		return servingSize;
	}
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public double getCarbohydrate() {
		return carbohydrate;
	}
	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	
	@Override
	public String toString() {
		return "Fruits [no=" + no + ", name=" + name + ", servingSize(mg)="
				+ servingSize + ", calories(cal)=" + calories + ", carbohydrate(g)="
				+ carbohydrate + ", fat(g)=" + fat + ", protein(g)=" + protein + "]";
	}
}