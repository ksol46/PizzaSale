package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.dao;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;
		
		System.out.println(context + " / " + command);
		
		dao dao = new dao();
		
		switch (command) {
		case "/home":
			site = "index.jsp";
			break;
		case "/insert":
			site = "insert.jsp";
			break;
		case "/add":
			int result1 = dao.insert(request, response);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			if(result1 == 1) {
				out.println("<script>");
				out.println("alert('매출전표가 정상적으로 등록 되었습니다!'); location.href='" + context + "';");
				out.println("</script>");
				out.flush();
			} else {
				out.println("<script>");
				out.println("alert('매출전표가 정상적으로 등록 되지 않았습니다!!'); location.href='" + context + "';");
				out.println("</script>");
				out.flush();
			}
			break;
		case "/inqury":
			site = dao.inqury(request, response);
			break;
		case "/branch":
			site = dao.branch(request, response);
			break;
		case "/goods":
			site = "goods.jsp";
			
	}
		
		getServletContext().getRequestDispatcher("/"+site).forward(request, response);
	
	

}
}
