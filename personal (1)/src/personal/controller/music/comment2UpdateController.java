package personal.controller.music;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import personal.bean.Comment2;
import personal.bean.Item2;
import personal.bean.Members;
import personal.repository.Comment2Repository;


/**
 * Servlet implementation class comment2UpdateController
 */
@WebServlet("/comment2/update")
public class comment2UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment2UpdateController() {
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
		int commentId = Integer.parseInt(request.getParameter("id"));
		String commentBody = request.getParameter("comment");
		Members member = (Members) session.getAttribute("member");
		Item2 item = (Item2) session.getAttribute("item");
		
		Comment2 comment = new Comment2();
		comment.setId2(commentId);
		comment.setComment2(commentBody);
		comment.setUserId2(member.getUser());
		
		Comment2Repository repo = new Comment2Repository();
		repo.setConnection(application.getAttribute("connection"));
		repo.updateComment(comment);
		
		response.sendRedirect(request.getContextPath() 
				+ "/mitem?id=" + item.getId2());
	}

}
