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

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		erreurs.put("motdepasse","");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Long id =(Long)session.getAttribute("client_id");
		if(id!=null) {
			res.sendRedirect(req.getContextPath()+"/accueil");
		}else {
			
			erreurs.replace("nom","");
			erreurs.replace("prenom","");
			erreurs.replace("email","");
			erreurs.replace("motdepasse","");
			req.setAttribute("erreurs", erreurs);
			req.setAttribute("client", new Client());
			req.getRequestDispatcher("inscription.jsp").forward(req, res);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		erreurs.replace("nom","");
		erreurs.replace("prenom","");
		erreurs.replace("email","");
		erreurs.replace("motdepasse","");
		
		String nom=req.getParameter("nom");
		String prenom=req.getParameter("prenom");
		String email=req.getParameter("email");
		String adresse=req.getParameter("adresse");
		int codepostal=req.getParameter("codepostal").equals("")?0:Integer.parseInt(req.getParameter("codepostal"));
		String ville=req.getParameter("ville");
		String motdepasse=req.getParameter("motdepasse");
		Client client = new Client(nom, prenom, email, adresse, codepostal, ville, motdepasse);
		
		if(email.equals("") || motdepasse.equals("") || nom.equals("") || prenom.equals("")) {
			if(nom.equals("")) 
				erreurs.put("nom", "Nom obligatoire!");
			if(prenom.equals("")) 
				erreurs.put("prenom", "Prénom obligatoire!");
			if(email.equals(""))
				erreurs.put("email", "E-mail obligatoire!");
			if(motdepasse.equals(""))
				erreurs.put("motdepasse", "Mot de passe obligatoire!");
			
			req.setAttribute("client", client);
			req.setAttribute("erreurs", erreurs);
			req.getRequestDispatcher("inscrire.jsp").forward(req, res);
			
		}else {
			if(!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) erreurs.put("email", "E-mail erroné!");
			else {
				if(metier.emailUnique(email) || !metier.passwordCheck(motdepasse)) {
				
					if(metier.emailUnique(email)) erreurs.put("email", "E-mail déja existe!");
				
					if(!metier.passwordCheck(motdepasse)) erreurs.put("motdepasse", "Mot de passe doit étre supérieur à 3 caractéres!");
					
					req.setAttribute("client", client);
					req.setAttribute("erreurs", erreurs);
					req.getRequestDispatcher("inscription.jsp").forward(req, res);
				}else {
				
					client = metier.addClient(client);
					
			
					HttpSession session = req.getSession();
					session.setAttribute("client_name", nom+" "+prenom);
					session.setAttribute("client_id", client.getId());

					res.sendRedirect(req.getContextPath()+"/accueil1");
				}	
				
			}
				
		}
	}

}
