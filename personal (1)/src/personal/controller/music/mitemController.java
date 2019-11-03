package personal.controller.music;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Comment2;
import personal.bean.Item2;
import personal.repository.Comment2Repository;
import personal.repository.Item2Repository;

/**
 * Servlet implementation class mitemController
 */
@WebServlet("/mitem")
public class mitemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mitemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object con = getServletContext().getAttribute("connection");
		int id = Integer.valueOf(request.getParameter("id"));
		
		Item2Repository repo = new Item2Repository();
		repo.setConnection(con);
		Item2 item = repo.getItem(id);
		
		if(item!=null){
			
			
			Comment2Repository crepo = new Comment2Repository();
			crepo.setConnection(con);
			List<Comment2> comments = crepo.list(item.getId2());
			
			request.setAttribute("comments", comments);
			System.out.println(comments.size());
			
			
			
			
			session.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/mitem.jsp").forward(request, response);
		} else {
			System.out.println("문제발생");
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
