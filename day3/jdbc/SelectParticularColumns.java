package com.codegnan.day3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectParticularColumns {
	static final String jdbc_url = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "Sai@23112002";
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset =  null;
		try {
			connection = DriverManager.getConnection(jdbc_url, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String selectQuery = "select ename,esal from employee";
			resultset = statement.executeQuery(selectQuery);
			System.out.println("ENAME\tESAL");	
			
			while(resultset.next()) {
				System.out.println(resultset.getString(1)+"\t"+resultset.getDouble(2));		
				System.out.println("============================================");		

			}
		} catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(resultset!=null) {
				try {
					resultset.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!= null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}