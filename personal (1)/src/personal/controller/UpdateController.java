package personal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Members;
import personal.repository.UserRepository;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/update.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Members origin = (Members) session.getAttribute("user");
		Members target = new Members();
		target.setUser(origin.getUser());
		target.setPassword(request.getParameter("password"));
		target.setNickName(request.getParameter("nick-name"));
		
		
		UserRepository repo = new UserRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		
		if(repo.updateMember(origin, target)){
			session.setAttribute("member", target);
			response.sendRedirect(request.getContextPath() + "/userinfo.jsp");
		} else {
			session.setAttribute("error", "not changed");
			response.sendRedirect(request.getContextPath() + "/update.jsp");
		}
		
		
		
		
		
		
		
		
		
	}

}
