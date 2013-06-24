package com.jsnote.dao;

import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import com.jsnote.model.Fruits;


//���̹�Ƽ�� ��ü ������ ���� Ŭ����
public class FruitsSession {
	
	//���� �����̽� ����
	private final String namespace = "com.jsnote.map.FruitsMapper";

	//SqlSesstionFactory ��ü ����(�̱��� ����) 
	private SqlSessionFactory getSqlSessionFactory() {
		
		String resource = "mybatis-config.xml";
		
		InputStream inputStream;
		
		try {
			//mybatis-config�� ������ Resource �о���� ��ü ���� 
			inputStream = Resources.getResourceAsStream(resource);
			
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		//SqlSessionFactoryBuilder() �޼��带 �̿��Ͽ� SqlSessionFactory ��ü ���� 
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	//��ü ���� ����Ʈ ���
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

	//�˻��� ���ϸ� ���
	public Fruits selectFruitsByName(String name) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Fruits)sqlSession.selectOne(namespace + ".selectFruitsByName", name);
		} finally {
			sqlSession.close();
		}
	}
	
  	//���ο� ���� �߰�
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

	//���� �̸� ����
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

	//���� ����
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
