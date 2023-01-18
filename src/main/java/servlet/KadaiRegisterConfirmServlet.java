package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.KadaiAccount;

/**
 * Servlet implementation class KadaiRegisterConfirmServlet
 */
@WebServlet("/KadaiRegisterConfirmServlet")
public class KadaiRegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KadaiRegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int gen = Integer.parseInt(request.getParameter("gender"));
		String Strgen = gen == 0 ? "男" : "女"; 
		String phone = request.getParameter("phone");
		String mail = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		KadaiAccount account = new KadaiAccount(-1, name, age, Strgen, phone, mail, null, pw, null);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("kadai_data", account);
		
		String view = "WEB-INF/kadai/kadai-confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
