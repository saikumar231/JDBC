package com.codegnan.day6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionsDemo {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "Sai@23112002";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			statement=connection.createStatement();
			System.out.println("Date Before Transaction");
			String sqlQuery	="select *from accounts";
			resultSet = statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"-----"+resultSet.getDouble(2));
			}
			System.out.println("\n Transaction Begins");
			//disable  auto commit mode
			connection.setAutoCommit(false);
			
			statement.executeUpdate("update accounts set balance = balance-10000 where name = 'sunny'");
			statement.executeUpdate("update accounts set balance = balance+10000 where name = 'sai'");
			
			//confirm the transaction
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Can you please confirm the transaction of 10000 Rs[yes/no]");
			String option = scanner.next();
			if(option.equalsIgnoreCase("yes")) {
				connection.commit();
				System.out.println("Transaction commited");
			}else {
				connection.rollback();
				System.out.println("Transaction rollback");
			}
			System.out.println("Date Before Transaction");
			String sqlQuery1	="select *from accounts";
			resultSet = statement.executeQuery(sqlQuery1);
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"-----"+resultSet.getDouble(2));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}	
			}
		}
	}

}
