package com.jsnote.dao;

import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import com.jsnote.model.Fruits;


//마이바티스 객체 생성을 위한 클래스
public class FruitsSession {
	
	//네임 스페이스 정의
	private final String namespace = "com.jsnote.map.FruitsMapper";

	//SqlSesstionFactory 객체 생성(싱글톤 패턴) 
	private SqlSessionFactory getSqlSessionFactory() {
		
		String resource = "mybatis-config.xml";
		
		InputStream inputStream;
		
		try {
			//mybatis-config에 정의한 Resource 읽어오는 객체 생성 
			inputStream = Resources.getResourceAsStream(resource);
			
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		//SqlSessionFactoryBuilder() 메서드를 이용하여 SqlSessionFactory 객체 리턴 
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	//전체 과일 리스트 출력
	public List<Fruits> selectAll(){
		List<Fruits> list = null;
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
		  list = sqlSession.selectList("selectAll");
		  }catch(Exception e){
		          e.printStackTrace();
		  }finally{
		          sqlSession.close();
		  }
		  return list;
	}

	//검색한 과일만 출력
	public Fruits selectFruitsByName(String name) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Fruits)sqlSession.selectOne(namespace + ".selectFruitsByName", name);
		} finally {
			sqlSession.close();
		}
	}
	
  	//새로운 과일 추가
	public Integer insertFruits(Fruits kinds) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".insertFruits";
			int result = sqlSession.insert(statement, kinds);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	//과일 이름 변경
	public Integer updateFruits(Fruits kinds) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".updateFruits";
			int result = sqlSession.update(statement, kinds);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	//과일 삭제
	public Integer deleteFruits(String name) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".deleteFruits";
			int result = sqlSession.delete(statement, name);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
