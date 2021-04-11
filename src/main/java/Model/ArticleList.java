package Model;

import java.util.ArrayList;
import java.util.List;

import sebo_one.Article;

public class ArticleList {
	public List<Article> articles = new ArrayList<Article>(); 

	public ArticleList() {
		super();
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
