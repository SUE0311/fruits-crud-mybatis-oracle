package com.jsnote.test;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class ConnectionTest {
	/**
	 * Connection �׽�Ʈ
	 */
	Connection con;
	static{
		try{
			// ������ ĳ���� ���θ��� ������ Ŭ���� �Ǵ� �������̽��� �������� �� �ִ�,Class ��ü�� ������
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
