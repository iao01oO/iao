package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.bean.EcArticle;
import com.shopping.bean.EcArticleType;
import com.shopping.bean.EcUser;
import com.shopping.bean.ShopCar;
import com.shopping.utils.ConnUtils;

public class ShopDao {

	public List<EcArticle> queryAllArctile() {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticle> articleList=new ArrayList<EcArticle>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article";
		    preSta=conn.prepareStatement(sql);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
	public List<EcArticle> queryAllArctile(int pageNum,int pageSize) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticle> articleList=new ArrayList<EcArticle>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article limit ?,?";
		    preSta=conn.prepareStatement(sql);
		    preSta.setInt(1, pageSize*(pageNum-1));
		    preSta.setInt(2, pageSize);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
	public List<EcArticleType> queryAllArctileType(){
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticleType> articleTypeList=new ArrayList<EcArticleType>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article_type";
		    preSta=conn.prepareStatement(sql);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticleType articleType=new EcArticleType();
		    	articleType.setCode(rs.getString(1));
		    	articleType.setName(rs.getString(2));
		    	articleType.setRemark(rs.getString(3));
		    	articleTypeList.add(articleType);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleTypeList;
		
	}
	public List<EcArticle> queryAllArctileByType(String remark) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticle> articleList=new ArrayList<EcArticle>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article a left join ec_article_type b on a.TYPE_CODE=b.`CODE` where b.REMARK=? ";
		    preSta=conn.prepareStatement(sql);
		    preSta.setString(1, remark);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
	public List<EcArticle> queryAllArctileByType(String remark,int pageNum,int pageSize) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticle> articleList=new ArrayList<EcArticle>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article a left join ec_article_type b on a.TYPE_CODE=b.`CODE` where b.REMARK=? limit ?,?";
		    preSta=conn.prepareStatement(sql);
		    preSta.setString(1, remark);
		    preSta.setInt(2, pageSize*(pageNum-1));
		    preSta.setInt(3, pageSize);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
	public List<EcArticle> queryAllArctileByTitle(String title) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticle> articleList=new ArrayList<EcArticle>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article a left join ec_article_type b on a.TYPE_CODE=b.`CODE` where a.TITLE like ?";
		    preSta=conn.prepareStatement(sql);
		    preSta.setString(1, "%"+title+"%");
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
		public List<EcArticle> queryAllArctileByTitle(String title,int pageNum,int pageSize) {
			Connection conn=null;
			PreparedStatement preSta=null;
			ResultSet rs=null;
			List<EcArticle> articleList=new ArrayList<EcArticle>();
			try {
				conn=ConnUtils.getConnection();
				String sql="select * from ec_article a left join ec_article_type b on a.TYPE_CODE=b.`CODE` where a.TITLE like ? limit ?,?";
			    preSta=conn.prepareStatement(sql);
			    preSta.setString(1, "%"+title+"%");
			    preSta.setInt(2, pageSize*(pageNum-1));
			    preSta.setInt(3, pageSize);
			    rs=preSta.executeQuery();
			    while(rs.next()) {
			    	EcArticle article=new EcArticle();
			    	article.setId(rs.getInt(1));
			    	article.setTitle(rs.getString(3));
			    	article.setSupplier(rs.getString(4));
			    	article.setPrice(rs.getDouble(5));
			    	article.setDiscount(rs.getDouble(6));
			    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
			    	article.setLocality(rs.getString(7));
			    	article.setStorage(rs.getInt(9));
			    	article.setImage(rs.getString(10));
			    	article.setDescription(rs.getString(11));
			    	articleList.add(article);
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnUtils.closeConn(conn, preSta, rs);
			}
			return articleList;
	}
	public List<EcArticle> queryAllArctileByTitleAndRemark(String title,String remark) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticle> articleList=new ArrayList<EcArticle>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article a left join ec_article_type b on a.TYPE_CODE=b.`CODE` where a.TITLE like ? and b.REMARK=?";
		    preSta=conn.prepareStatement(sql);
		    preSta.setString(1, "%"+title+"%");
		    preSta.setString(1, remark);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
	public EcArticle queryActileById(int id) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article where id=?";
		    preSta=conn.prepareStatement(sql);
		    preSta.setInt(1,id);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	return article;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return null;
	}
	public List<EcArticle> queryAllArctileByTitleAndRemark(String title,String remark,int pageNum,int pageSize) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<EcArticle> articleList=new ArrayList<EcArticle>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select * from ec_article a left join ec_article_type b on a.TYPE_CODE=b.`CODE` where a.TITLE like ? and b.REMARK=? ";
		    preSta=conn.prepareStatement(sql);
		    preSta.setString(1, "%"+title+"%");
		    preSta.setString(1, remark);
		    preSta.setInt(2, pageSize*(pageNum-1));
		    preSta.setInt(3, pageSize);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	EcArticle article=new EcArticle();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
	public int addShopCar(int articleId, int buyNum, int userId) {
		Connection conn=null;
		PreparedStatement preSta=null;
		int i=0;
		try {
			conn=ConnUtils.getConnection();
			String sql="insert into ec_shopcar(articleId,buyNum,userId) values(?,?,?)";
		    preSta=conn.prepareStatement(sql);
		    preSta.setInt(1, articleId);
		    preSta.setInt(2, buyNum);
		    preSta.setInt(3, userId);
		    preSta.executeUpdate();   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta);
		}
		return i;
	}
	public List<ShopCar> myShopCar(Integer id) {
		Connection conn=null;
		PreparedStatement preSta=null;
		ResultSet rs=null;
		List<ShopCar> articleList=new ArrayList<ShopCar>();
		try {
			conn=ConnUtils.getConnection();
			String sql="select a.*,s.buyNum from ec_article a LEFT JOIN ec_shopcar s on a.id=s.articleId where s.userId=?";
		    preSta=conn.prepareStatement(sql);
		    preSta.setInt(1, id);
		    rs=preSta.executeQuery();
		    while(rs.next()) {
		    	ShopCar article=new ShopCar();
		    	article.setId(rs.getInt(1));
		    	article.setTitle(rs.getString(3));
		    	article.setSupplier(rs.getString(4));
		    	article.setPrice(rs.getDouble(5));
		    	article.setDiscount(rs.getDouble(6));
		    	article.setDiscountPrice(String.format("%.2f", article.getDiscount()*article.getPrice()));
		    	article.setLocality(rs.getString(7));
		    	article.setStorage(rs.getInt(9));
		    	article.setImage(rs.getString(10));
		    	article.setDescription(rs.getString(11));
		    	article.setBuyNum(rs.getInt(14));
		    	articleList.add(article);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtils.closeConn(conn, preSta, rs);
		}
		return articleList;
	}
	

}
