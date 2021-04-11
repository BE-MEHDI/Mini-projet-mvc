package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Sebo_dao.Clientdao;
import Sebo_dao.Inter_client;
import sebo_one.Client;



public class Identification extends HttpServlet {

	private Inter_client metier;  
	private Map<String,String> erreurs;
	@Override
	public void init() throws ServletException {
		metier=new Clientdao();
		erreurs = new HashMap<String, String>();
		erreurs.put("nom","");
		erreurs.put("prenom","");
		erreurs.put("email","");
		erreurs.put("general","");
		erreurs.put("MotPasse","");
	}
	
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Long id =(Long)session.getAttribute("client_id");
		if(id!=null) {
			res.sendRedirect(req.getContextPath()+"/accueil1");
		}else {
			erreurs.replace("nom","");
			erreurs.replace("prenom","");
			erreurs.replace("email","");
			erreurs.replace("MotPasse","");
			erreurs.replace("general","");
			req.setAttribute("erreurs", erreurs);
			req.getRequestDispatcher("identification.jsp").forward(req, res);
		}
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String motdepasse=req.getParameter("MotPasse");
		Client client = metier.identifier(email, motdepasse);
		
	
		erreurs.replace("general","");
		erreurs.replace("email","");
		erreurs.replace("MotPasse","");
		
		if(email.equals("") || motdepasse.equals("")) {
			if(email.equals(""))
				erreurs.put("email", "E-mail obligatoire!");
			if(motdepasse.equals(""))
				erreurs.put("motdepasse", "Mot de passe obligatoire!");
			
			req.setAttribute("erreurs", erreurs);
			req.setAttribute("email", email);
			req.getRequestDispatcher("identification.jsp").forward(req, res);
		}
		else {
			if(client!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("client_name", client.getNom()+" "+client.getPrenom());
				session.setAttribute("client_id", client.getId());
				res.sendRedirect(req.getContextPath()+"/accueil1");
			}else {
				erreurs.put("general","E-mail ou mot de passe est invalide!");
				req.setAttribute("erreurs", erreurs);
				req.setAttribute("email", email);
				req.getRequestDispatcher("identification.jsp").forward(req, res);
			}
		}
	}
}
