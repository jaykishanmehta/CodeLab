package com.code.practice.db.mssql.obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleJDBC {

	public static void main(String[] args) {
		
		String userName = "sa";
		String password = "Test@1234";

		//ATLANTISPC-720\SQLEXPRESS
		String url = "jdbc:sqlserver://localhost:1433;databaseName=db_cboemrtst1";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			Statement statement = conn.createStatement();
			String queryString = "select Id,DateAdd(mi, 39, LockedTime) remTime from rwformlog where UniqueId= 'frmReferral160' order by id";
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				System.out.println(rs.getString("remTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
