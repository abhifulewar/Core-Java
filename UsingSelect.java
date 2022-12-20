package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsingSelect {

	//for select query---display all table data
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//loaded driver class
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "avanti@1116"); //establish connection with db
	        PreparedStatement ps=con.prepareStatement("select * from employee");
	      

	        //create ref var of Result set interface to store the data from table---to store set of record for that we need ref var of type resultset
	       ResultSet rs= ps.executeQuery();
	       
	       //rs is going to point the next record
	       while(rs.next()) //to check if next record is present
	       {
	    	   //etString(columnIndex
	    	   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
	       }
	       ps.close();
	       con.close();
	        
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
