package personal.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import personal.bean.Members;
import personal.repository.UserRepository;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")

public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/signup.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		request.setCharacterEncoding("utf-8");
		
		
		
		
		Members member = new Members();
		member.setUser(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setNickName(request.getParameter("nickName"));
		
		
		
		
		
		
		
		UserRepository repo = new UserRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		
		if(repo.addUser(member)) {
			
			
			
				
				
				
			
			response.sendRedirect(request.getContextPath() + "/");
			System.out.println("사용자 등록 완료");
		} else {
			request.setAttribute("member", member);
			request.setAttribute("error", "실패 ");
			request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}
	}

}
