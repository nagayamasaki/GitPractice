package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KadaiAccountDAO;
import dto.KadaiAccount;

/**
 * Servlet implementation class KadaiRegisterExecuteServlet
 */
@WebServlet("/KadaiRegisterExecuteServlet")
public class KadaiRegisterExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KadaiRegisterExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();

			KadaiAccount account = (KadaiAccount)session.getAttribute("kadai_data");
			
			int result = KadaiAccountDAO.registerAccount(account);
				
			String path = "";
			if(result == 1) {
				session.removeAttribute("kadai_data");
					
				path = "WEB-INF/kadai/kadai-success.jsp";
			} else {
				path = "WEB-INF/kadai/kadai-form.jsp?error=1";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
