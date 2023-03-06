package com.shopping.dao;

import java.sql.*;

import com.shopping.bean.EcUser;
import com.shopping.utils.ConnUtils;

public class UserDao {
	public EcUser doLogin(String loginName,String password)   {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_user where LOGIN_NAME=? and `PASSWORD`=?";
		    preSta=conn.prepareStatement(sql);
		    preSta.setString(1, loginName);
		    preSta.setString(2, password);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
			EcUser user=new EcUser();
			user.setId(rs.getInt(1));
			user.setLoginName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setRole(rs.getInt(9));
			return user;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return null;
	}

	public  int doRegister(EcUser user) {
		Connection conn=null;
		PreparedStatement preSta=null;
		int i=0;
		try {
			conn=ConnUtils.getConnection();
			String sql="insert into ec_user(LOGIN_NAME,PASSWORD,NAME,SEX,ADDRESS,PHONE,ROLE) values(?,?,?,?,?,?,1);";
		    preSta=conn.prepareStatement(sql); 
		    preSta.setString(1,user.getLoginName());
		    preSta.setString(2,user.getPassword());
		    preSta.setString(3,user.getName());
		    preSta.setInt(4,user.getSex());
		    preSta.setString(5,user.getAddress());
		    preSta.setString(6,user.getPhone());
		    i=preSta.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta);
		}
		return i;
		
		
	}
	
}