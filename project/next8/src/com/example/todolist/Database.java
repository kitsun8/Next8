package com.example.todolist;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

		private String url = null; //db url
		private String user = null; //db user
		private String password = null; //db pw
		
		public Connection conn = null;

	public Database() {
		this.url = "";
		this.user = "";
		this.password = "";
				
	}

	public Database(String p_url, String p_user, String p_password) {
		this.url = p_url;
		this.user = p_user;
		this.password = p_password;
	}
	
	public boolean connect() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}
	
	public boolean disconnect() {
		try {
			if (conn != null) {
				conn.close();
			}
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
