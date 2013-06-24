package com.jsnote.test;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class ConnectionTest {
	/**
	 * Connection 테스트
	 */
	Connection con;
	static{
		try{
			// 지정된 캐릭터 라인명을 가지는 클래스 또는 인터페이스에 관련지을 수 있던,Class 객체를 돌려줌
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cne){
			cne.printStackTrace();
		}
	}
	public void connect(){
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"scott", "tiger");
			System.out.println("Connection Success!");
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionTest ct = new ConnectionTest();
		ct.connect();
	}
}
