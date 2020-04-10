package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Userservice;
import cn.itcast.myforum.utils.SendMail;

/**
 * Servlet implementation class sendmailServlet
 */
public class sendmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendmailServlet() {
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

		String random=random();
		User user=(User)request.getSession().getAttribute("user");
		SendMail sendMail=new SendMail();
		sendMail.sendMail(user.getEmail(), random);
		HttpSession session=request.getSession();
		session.setAttribute("random", random);
		request.getRequestDispatcher("/client/updatepassword.jsp").forward(request, response);
		return;
	}
	public String random() {
		String string="0123456789";
		char[] rands=new char[4];
		for (int i = 0; i < rands.length; i++) {
			int rand=(int)(Math.random()*10);
			rands[i]=string.charAt(rand);
		}
		String random=new String(rands);
		return random;
	}

}
