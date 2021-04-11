package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ArticleList;
import Model.CategorieList;
import Sebo_dao.inter_article;
import sebo_one.Article;



public class Catalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private inter_article article_metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/catalogue": {
			if(session.getAttribute("client_id")==null)resp.sendRedirect(req.getContextPath()+"/");
			else{
				ArticleList model=new ArticleList();
				CategorieList cat_model = new CategorieList();
				model.setArticles(article_metier.getArticles(null));
				for (Article article : model.getArticles()) {
					//article.setRefCAt(article_metier.getCat(article.getCodeArticle()));
				}
				cat_model.setCategories(article_metier.getCategories());
				req.setAttribute("model", model);
				req.setAttribute("cat_model", cat_model);
				req.getRequestDispatcher("webform1.jsp").forward(req, resp);
			}
			break;
		}
		case "/detail": {
			if(session.getAttribute("client_id")==null)resp.sendRedirect(req.getContextPath()+"/");
			else {
				Long CodeArticle = Long.parseLong(req.getParameter("CodeArticle"));
				Article article =article_metier.getArticle(CodeArticle);
				req.setAttribute("article", article);
				req.getRequestDispatcher("webform1.jsp").forward(req, resp);
			}
			break;
		}
		default:
			req.getRequestDispatcher("NotFound.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cat_name=req.getParameter("categorie");
		ArticleList model=new ArticleList();
		CategorieList cat_model = new CategorieList();
		
		if(cat_name.equals("all")) {
			model.setArticles(article_metier.getArticles(null));
		}else {
			Long cat_id=article_metier.getCatId(cat_name);
			model.setArticles(article_metier.getArticles(cat_id));
		}
		for (Article article : model.getArticles()) {
		}
		cat_model.setCategories(article_metier.getCategories());
		
		req.setAttribute("model", model);
		req.setAttribute("cat_model", cat_model);
		req.getRequestDispatcher("webform2.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	

}
