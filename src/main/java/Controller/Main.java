
package Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
			case "/index1": {
				HttpSession session = req.getSession();
				Long id =(Long)session.getAttribute("client_id");
				if(id!=null) {
					res.sendRedirect(req.getContextPath()+"/accueil1");
					
				}else {
					
					req.getRequestDispatcher("index1.jsp").forward(req, res);
				}
				break;
			}
			case "/accueil1": {
				HttpSession session = req.getSession();
				Enumeration clients = session.getAttributeNames();
				Long id =(Long)session.getAttribute("client_id");
				if(id==null) {
					res.sendRedirect(req.getContextPath()+"/index1");
				}else {
					while(clients.hasMoreElements()) {
						String client = (String) clients.nextElement();
						if(client.equals("client_id") || client.equals("client_name")) {
							String value = session.getAttribute(client).toString();
							req.setAttribute(client, value);
						}
					}
				req.getRequestDispatcher("accueil1.jsp").forward(req, res);
				}
				
				break;
			}
			default:
				req.getRequestDispatcher("NotFound.jsp").forward(req, res);
			}
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("client_id");
		session.removeAttribute("client_name");
		res.sendRedirect(req.getContextPath()+"/index1");
	}

}