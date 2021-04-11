package Sebo_dao;

import java.util.List;
import sebo_one.Article;
import sebo_one.Categories;

public interface inter_article {
	public List<Article> getArticles(Long id);
	public Article getArticle(Long CodeArticle);
	public List<Categories> getCategories();
	public Long getCatId(String cat);
	public String getCat(long i);

}
