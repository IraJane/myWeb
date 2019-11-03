package personal.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Comment;
import personal.bean.Item;
import personal.bean.Members;
import personal.repository.CommentRepository;

/**
 * Servlet implementation class commentInsertController
 */
@WebServlet("/comment/insert")
public class commentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		Members member = (Members) session.getAttribute("member");
		Item item = (Item) session.getAttribute("item");
		
		Comment comment = new Comment();
		comment.setComment(request.getParameter("comment"));
		comment.setItemId(item.getId());
		comment.setUserId(member.getUser());
		
		CommentRepository repo = new CommentRepository();
		repo.setConnection(application.getAttribute("connection"));
		if (repo.addComment(comment)) {
			session.removeAttribute("comment");
		} else {
			session.setAttribute("comment", comment);
		}
		response.sendRedirect(request.getContextPath() 
				+ "/item?id=" + item.getId());
		
		
		
		
	}

}
