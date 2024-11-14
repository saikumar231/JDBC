package com.codegnan.day4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadOperationWithSelect {
	
	static final String JDBC_URL="jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME="root";
	static final String PASSWORD="Sai@23112002";

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Scanner sc=new Scanner(System.in);
		
		
		try {
			connection=DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			//String selectQuery="select * from employee where eno=?";
			String selectQuery="select * from employee where esal=?";
			preparedStatement=connection.prepareStatement(selectQuery);
			
			System.out.println("Enter the Employee Number : ");
			int eno=sc.nextInt();
			
			preparedStatement.setInt(1,eno);
			
			resultSet=preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				int empNumber=resultSet.getInt("eno");
				String empName=resultSet.getString("ename");
				double empSalary=resultSet.getDouble("esal");
				String empAddr=resultSet.getString("eaddr");
				
				System.out.println("Employee Details : ");
				System.out.println("=====================================");
				System.out.println("ENO\tENAME\tESAL\tEADDR");
				System.out.print(empNumber+"\t");
				System.out.print(empName+"\t");
				System.out.print(empSalary+"\t");
				System.out.print(empAddr);
			}
			else {
				System.out.println("Record not found with employee number : "+eno);
			}
			
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
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