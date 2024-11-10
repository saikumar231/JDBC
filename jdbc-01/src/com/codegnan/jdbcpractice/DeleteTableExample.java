package com.codegnan.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTableExample {
static final String JDBC_URL = "jdbc:mysql://localhost:3306/adjava";
static final String USERNAME = "root";
static final String PASSWORD = "Sai@23112002";
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String sqlQuery = "drop table employee";
			statement.executeUpdate(sqlQuery);
			
			System.out.println("Employee Table Deleted Successfully.....");
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
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
