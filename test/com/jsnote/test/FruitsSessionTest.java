package com.jsnote.test;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.jsnote.dao.FruitsSession;
import com.jsnote.model.Fruits;

public class FruitsSessionTest {
	
	//FruitsSession ��ü ����
	private final FruitsSession fruitsSession = new FruitsSession();

	//�˻��� ���� ���
	public void selectFruitsByName() {
		
		String name = "Bananas";
		Fruits kinds = fruitsSession.selectFruitsByName(name);
		
		//Fruits�� toString() �޼���
		System.out.println(kinds);
		System.out.println(name + " ���  ���� =========================== \n");
	}
	
	//��ü ���� ���
	public void selectAll() {
		List<Fruits> list = fruitsSession.selectAll();
		for(Fruits m: list){
		System.out.println(m.getNo() + " / " + m.getName() + " / " + m.getServingSize()+ " / " + m.getCalories() + " / " + m.getCarbohydrate() + " / " + m.getFat() + " / " + m.getProtein());
	    System.out.println("-----------------------------------------------------------------");
		} 
	}

	//���ο� ���� �ֱ�
	public void insertFruits() {
		int no = 6;
		String name = "Watermelon";
		int servingSize = 100;
		int calories = 30;
		double carbohydrate = 6.99;
		double fat = 0.14;
		double protein = 0.56;

		Fruits kinds = new Fruits();
	
		kinds.setNo(no);
		kinds.setName(name);
		kinds.setServingSize(servingSize);
		kinds.setCalories(calories);
		kinds.setCarbohydrate(carbohydrate);
		kinds.setFat(fat);
		kinds.setProtein(protein);

		Integer result = fruitsSession.insertFruits(kinds);

		System.out.println(result);
		System.out.println(name + " ����  ���� =========================== \n");
	}

	//���� Į�θ� �����ϱ�
	public void updateFruits() {
		
		int no = 1;
		String name = "���";
		
		Fruits kinds = new Fruits();
		
		kinds.setName(name);
		
		Integer result = fruitsSession.updateFruits(kinds);

		System.out.println(result);
		System.out.println(no + "�� ������ �̸� ����  ���� =========================== \n");
	}

	//���� �����ϱ�
	public void deleteFruits() {
		String name = "Grapes";
		
		Integer result = fruitsSession.deleteFruits(name);

		System.out.println(result);
		System.out.println(name + " ���� ���� =========================== \n");
	}

	public static void main(String[] args) {
		FruitsSessionTest test = new FruitsSessionTest();

//		test.selectFruitsByName();
//		test.insertFruits();
//		test.updateFruits();
//		test.deleteFruits();
		
		//��� ��� ���
		test.selectAll();
	}
}
