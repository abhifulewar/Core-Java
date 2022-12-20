package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Preparedstmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// to update emp data---- input data from user
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter emp id whose sal is to be updated");
			
			int empid=sc.nextInt();
			
			System.out.println("enter new sal");
			int newsalary=sc.nextInt();
			
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // load the driver class
			// to establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "avanti@1116");

			// for parameterized query ----use prepared statement ---for creating ref var of parep statemnt has d in it and method doesnt have d i.e only prepareStatement
			PreparedStatement ps=   con.prepareStatement("update employee set salary=? where id=?");
	        
			//param index ---starts from 1---for param query ?1=1 and ?2= index 2
			ps.setInt(1, newsalary);
			ps.setInt(2, empid);
			
			//method for execution of prep stmt// for select query---method is execute query
			
			
			int count=ps.executeUpdate();
			
			System.out.println("num of records updated"+count);
		
			
			System.out.println("terminated program succ");
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
		
}
}