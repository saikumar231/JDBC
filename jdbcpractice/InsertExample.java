package com.codegnan.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {
static final String JDBC_URL = "jdbc:mysql://localhost:3306/adjava";
static final String USERNAME = "root";
static final String PASSWORD = "Sai@23112002";
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Load and Register Driver Successfully");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("Connection established Successfully");
			statement = connection.createStatement();
			System.out.println("Statement object created");
			//String sqlquery = "Insert into employee(ename,esal,eaddr) values('sai',50000,'NewYork'),('kumar',60000,'USA'),('Raj',70000,'Norway'),('shyam',40000,'London')";
			String sqlquery = "Delete from employee where esal = 500";
			statement.executeUpdate(sqlquery);
			System.out.println("Query Excuted Successfully");

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
