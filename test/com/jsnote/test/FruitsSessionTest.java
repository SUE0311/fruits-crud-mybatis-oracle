package com.jsnote.test;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.jsnote.dao.FruitsSession;
import com.jsnote.model.Fruits;

public class FruitsSessionTest {
	
	//FruitsSession 객체 생성
	private final FruitsSession fruitsSession = new FruitsSession();

	//검색한 과일 출력
	public void selectFruitsByName() {
		
		String name = "Bananas";
		Fruits kinds = fruitsSession.selectFruitsByName(name);
		
		//Fruits의 toString() 메서드
		System.out.println(kinds);
		System.out.println(name + " 출력  성공 =========================== \n");
	}
	
	//전체 과일 출력
	public void selectAll() {
		List<Fruits> list = fruitsSession.selectAll();
		for(Fruits m: list){
		System.out.println(m.getNo() + " / " + m.getName() + " / " + m.getServingSize()+ " / " + m.getCalories() + " / " + m.getCarbohydrate() + " / " + m.getFat() + " / " + m.getProtein());
	    System.out.println("-----------------------------------------------------------------");
		} 
	}

	//새로운 과일 넣기
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
		System.out.println(name + " 삽입  성공 =========================== \n");
	}

	//과일 칼로리 변경하기
	public void updateFruits() {
		
		int no = 1;
		String name = "사과";
		
		Fruits kinds = new Fruits();
		
		kinds.setName(name);
		
		Integer result = fruitsSession.updateFruits(kinds);

		System.out.println(result);
		System.out.println(no + "번 과일의 이름 변경  성공 =========================== \n");
	}

	//과일 삭제하기
	public void deleteFruits() {
		String name = "Grapes";
		
		Integer result = fruitsSession.deleteFruits(name);

		System.out.println(result);
		System.out.println(name + " 삭제 성공 =========================== \n");
	}

	public static void main(String[] args) {
		FruitsSessionTest test = new FruitsSessionTest();

//		test.selectFruitsByName();
//		test.insertFruits();
//		test.updateFruits();
//		test.deleteFruits();
		
		//모든 결과 출력
		test.selectAll();
	}
}
