package personal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import personal.bean.Item;
import personal.bean.Item2;
import personal.repository.Item2Repository;
import personal.repository.ItemRepository;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		pageStr = pageStr == null ? "1" : pageStr;
		int page = Integer.parseInt(pageStr);
		int minPage = page > 2 ? page - 2 : 1;
		int maxPage = minPage + 4;
		
		
		
		
		
		
		ItemRepository repo = new ItemRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		
		List<Item> items = repo.list(page);
		request.setAttribute("items", items);
		request.setAttribute("minPage", minPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("curPage", page);
		
		
		
		String pageStr2 = request.getParameter("page2");
		pageStr2 = pageStr2 == null ? "1" : pageStr2;
		int page2 = Integer.parseInt(pageStr2);
		int minPage2 = page2 > 2 ? page2 - 2 : 1;
		int maxPage2 = minPage2 + 4;
		
		Item2Repository repo2 = new Item2Repository();
		repo2.setConnection(getServletContext().getAttribute("connection"));
		List<Item2> items2 = repo2.list(page2);
		request.setAttribute("items2", items2);
		request.setAttribute("minPage", minPage2);
		request.setAttribute("maxPage", maxPage2);
		request.setAttribute("curPage", page2);
		
		
		
		
		
		
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/main.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
