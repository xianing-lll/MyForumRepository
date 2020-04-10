package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Userservice;
import cn.itcast.myforum.utils.Except;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailString=request.getParameter("emailtext");
		String passwordString=request.getParameter("passwordtext");
		Except except=new Except();
		String msgString=except.login(emailString, passwordString);
		if (msgString==null) {
			Userservice userservice=new Userservice();
			User user=userservice.loginUser(emailString, passwordString);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		} else {

			request.setAttribute("msg", msgString);
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
	}

}
