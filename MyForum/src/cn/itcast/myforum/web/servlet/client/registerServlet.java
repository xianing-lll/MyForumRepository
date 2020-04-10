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
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		// TODO Auto-generated method stub
		String emailString=request.getParameter("emailtext");
		String passwordString=request.getParameter("passwordtext");
		String passwordString_2=request.getParameter("passwordtext_2");
		String sexString=request.getParameter("sextext");
		String ageString=request.getParameter("agetext");
		String phoneString=request.getParameter("phonetext");
		Except except=new Except();
		String emailMsgString=except.email(emailString);
		String passwordMsgString=except.password(passwordString, passwordString_2);
		String phoneMsgString=except.phone(phoneString);
		if(emailMsgString!=null||passwordMsgString!=null||phoneMsgString!=null) {
			request.setAttribute("emailmsg", emailMsgString);
			request.setAttribute("passwordmsg", passwordMsgString);
			request.setAttribute("phonemsg", phoneMsgString);
			request.getRequestDispatcher("/client/register.jsp").forward(request, response);
			return;
		}
		User user=new User();
		user.setEmail(emailString);
		user.setPassword(passwordString);
		user.setSex(sexString);
		user.setAge(Integer.parseInt(ageString));
		user.setPhone(phoneString);
		
		Userservice userservice=new Userservice();
		if (userservice.resiger(user)==true) {
			response.sendRedirect(request.getContextPath()+"/client/login.jsp");
			return;
		} 
		
	}

}
