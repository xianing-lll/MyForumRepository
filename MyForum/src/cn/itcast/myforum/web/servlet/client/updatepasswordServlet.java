package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.service.Userservice;
import cn.itcast.myforum.utils.Except;

/**
 * Servlet implementation class updatepasswordServlet
 */
public class updatepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepasswordServlet() {
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
		String email=request.getParameter("email");
		String indentify= request.getParameter("indentifytext");
		String passwordString= request.getParameter("passwordtext");
		String againString=request.getParameter("again_passwordtext");
		String randomString=(String)request.getSession().getAttribute("random");
		System.out.println(randomString);
		Except except=new Except();
		String msgString=except.password(passwordString, againString);
		if (!indentify.equals(randomString)) {
			
			request.setAttribute("msg_2", "验证码错误");
			request.getRequestDispatcher("/client/updatepassword.jsp").forward(request, response);
			return;
		} else if(msgString!=null){
			
			request.setAttribute("msg", msgString);
			request.getRequestDispatcher("/client/updatepassword.jsp").forward(request, response);
			return;
		}else {
			Userservice userservice=new Userservice();
			userservice.updatePassword(email, passwordString);
			request.setAttribute("msg_2", "密码修改成功！");
			request.getRequestDispatcher("/client/updatepassword.jsp").forward(request, response);
			return;
		}
	}

}
