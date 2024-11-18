package com.codegnan.day5.BatchUpdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdatesExample {
	static final String JDBC_URL="jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME="root";
	static final String PASSWORD="Sai@23112002";
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			statement= connection.createStatement();
			
			String insertQuery = "insert into employee values (1111,'Sanjeeth',50000,'hyd')";
			String updateQuery = "update employee set esal = esal +1000 where esal <30000";
			String deleteQuery = "delete from employee where esal >=60000";
			
			statement.addBatch(insertQuery);
			statement.addBatch(updateQuery);
			statement.addBatch(deleteQuery);
			
			int[] updateCounts = statement.executeBatch();
			int totalUpdateCount =0;
			for(int count :updateCounts) {
				totalUpdateCount=+count;
			}
			System.out.println("The Number of Rows Updated: "+totalUpdateCount);
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
