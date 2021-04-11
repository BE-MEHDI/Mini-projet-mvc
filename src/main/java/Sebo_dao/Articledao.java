package Sebo_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Sebo_dao.DBconnection.DbConnection;
import sebo_one.Article;
import sebo_one.Categories;

public class Articledao implements inter_article{
private Connection con = DbConnection.getConnection();
	
	@Override
	public List<Article> getArticles(Long id) {
		List<Article> articles = new ArrayList<Article>();
		if(id==null) {
			try {
				PreparedStatement ps =con.prepareStatement("SELECT * FROM ARTICLES");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Article article= new Article(rs.getDouble("PRIX"), rs.getString("DESIGNATION"),rs.getInt("STOCK"),rs.getString("CATEGORIE"),rs.getString("PHOTO"));
					article.setCodeArticle(rs.getInt("CodeArticle"));
					articles.add(article);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			PreparedStatement ps;
			try {
				ps =con.prepareStatement("SELECT * FROM ARTICLES WHERE CATEGORIE=?");
				ps.setLong(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Article article= new Article(rs.getDouble("PRIX"), rs.getString("DESIGNATION"),rs.getInt("STOCK"),rs.getString("CATEGORIE"),rs.getString("PHOTO"));
					article.setCodeArticle(rs.getInt("CodeArticle"));
					articles.add(article);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

	@Override
	public List<Categories> getCategories() {
		List<Categories> categories = new ArrayList<Categories>();
		try {
			PreparedStatement ps =con.prepareStatement("SELECT * FROM CATEGORIES");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Categories categorie = new Categories(rs.getString("CAT"));
				categorie.setRefCat(rs.getLong("RefCat"));
				categories.add(categorie);
			}
			ps.close();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return categories;
	}

	@Override
	public Long getCatId(String cat) {
		Long cat_id=null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT RefCat FROM Categories WHERE Cat=?");
			ps.setString(1, cat);
			ResultSet rs=ps.executeQuery();
			if(rs.next())cat_id=rs.getLong("RefCat");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat_id;
	}

	@Override
	public Article getArticle(Long CodeArticle) {
		Article article =new Article();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ARTICLES WHERE CodeArticle=?");
			ps.setLong(1, CodeArticle);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				article.setCodeArticle(rs.getInt("CodeArticle"));
				article.setDesignation(rs.getString("DESIGNATION"));
				article.setPrix(rs.getDouble("PRIX"));
				article.setStock(rs.getInt("STOCK"));
				article.setRefCAt(rs.getString("CATEGORIE"));
				article.setPhoto(rs.getString("PHOTO"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public String getCat(long id) {
		String cat_name = "";
		try {
			String query = "SELECT categories.Cat FROM categories INNER JOIN articles on articles.Categorie=categories.RefCat WHERE articles.Categorie = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setLong(1, id);
			ResultSet res = pstm.executeQuery();
			while(res.next()) {
				cat_name= res.getString("RefCat");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cat_name;
	}

}
