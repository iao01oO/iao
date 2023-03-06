package com.shopping.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnUtils {
	public static Connection getConnection() throws Exception  {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shopping?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong&useAffectedRows=true","root","123456");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void closeConn(Connection conn,PreparedStatement preSta,ResultSet rs) {
		try {
			if(conn!=null) {
			conn.close();
		}
		if(preSta!=null) {
			preSta.close();
		}
		if(rs!=null) {
			rs.close();
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
	public static void closeConn(Connection conn,PreparedStatement preSta) {
		try {
			if(conn!=null) {
			conn.close();
		}
		if(preSta!=null) {
			preSta.close();
		}
	
	}catch(SQLException e) {
		e.printStackTrace();
	}

}
}
