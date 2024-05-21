package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
		
	Connection conn;
		public void getConnectionfromDb(String url, String uname, String password) {
			try {
				Driver driver= new Driver();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url, uname, password);
				}catch(Exception e) {
				
				}
		
		}
		public void closeConnection() throws SQLException {
			try {
			conn.close();
			}catch(Exception e) {
				
			}
		}
		
		public void getConnection() {
			try {
				Driver driver= new Driver();
				DriverManager.registerDriver(driver);
				DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
				
			}catch(Exception e) {
				
			}
		}
		
		public ResultSet executeSelectQuery(String query) throws SQLException {
		
		ResultSet result =null;
		
		try  {
			Statement stat = conn.createStatement();
			result=stat.executeQuery(query);
		}catch(Exception e) {
			
		}
		
		return result;
	}
		
	public int executeNonselectQuery(String query) {
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		return result;
	}
	

}
