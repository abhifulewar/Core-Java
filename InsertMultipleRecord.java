package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class ConnectionTest
{
	Connection con=null;
	
	
	
	public Connection getConnectionDetails() {//retrun tyoe of this method is Connection---con is of type Connection
		try {
		
			// load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// to establish the connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "avanti@1116");
	
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}

public class InsertMultipleRecord {
	
	Connection con=null;
	PreparedStatement ps=null;
	
	
	
//create a method which should insert data in database
	
	 void insertData(String ename,String address,int salary,String job)throws Exception
	{
		ConnectionTest ct=new ConnectionTest();
		con=ct.getConnectionDetails();
		
		PreparedStatement ps=con.prepareStatement("insert into employee(name,address,salary,job)values(?,?,?,?)");
				
		ps.setString(1, ename);
		ps.setString(2, address);
		
		ps.setInt(3,salary);
		ps.setString(4,job);
				
		int i=ps.executeUpdate();
		
		
	}

	//For INSERTING MULTIPLE  RECORDS USING JDBC
	public static void main(String[] args) throws Exception {
		
		//accept salary and name from user one by one
		InsertMultipleRecord m=new InsertMultipleRecord();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the number of employees to be inserted in record");
		int count=sc.nextInt();
		
		System.out.println("enter the details for new emp");
		
		for(int i=0;i<count;i++)
		{
			
		   
			System.out.println("enter emp name");
		    String ename=sc.next();
		    
		    System.out.println("enter emp address");
		    String address=sc.next();
		    
		   
		     
		     System.out.println("enter sal of emp");
		     int salary=sc.nextInt();
		     
		     System.out.println("enter emp job");
			    String job=sc.next();
			    
		     m.insertData(ename,address, salary,job);
		}
		
		
		
		

	}

}
