package Model;

import java.util.ArrayList;
import java.util.List;
import sebo_one.Categories;



public class CategorieList {
	public List<Categories> categorie = new ArrayList<Categories>();

	public CategorieList() {
		super();
	}

	public List<Categories> getArticles() {
		return categorie;
	}

	public void setArticles(List<Categories> articles) {
		this.categorie = articles;
	}

	

	public void setCategories(List<Categories> categories) {
		// TODO Auto-generated method stub
		
	} 
	


}
