package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import cn.itcast.myforum.dao.Userdao;
import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Userservice;
import cn.itcast.myforum.utils.Except;

/**
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
	 * 更新个人信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameString=request.getParameter("nametext");
		String phoneString=request.getParameter("phonetext");
		User user = (User) request.getSession().getAttribute("user");
		String emailString=user.getEmail();
		Except except=new Except();
		String namemsgString=except.name(nameString);
		String phonemsgString=except.phone(phoneString);
		if (namemsgString==null||phonemsgString==null) {
			String msgString=null;
			Userservice userservice=new Userservice();
			Boolean boolean1=userservice.updateUser(emailString ,nameString, phoneString);
			if (boolean1=true) {
				Userdao userdao=new Userdao();
				User user2 = null;
				try {
					user2 = userdao.findUser(emailString);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("dao层根据email查找用户失败！");
					e.printStackTrace();
				}
				
				request.getSession().setAttribute("user", user2);
				msgString="信息更新成功！";
			} else {

				msgString="信息更新失败！";
			}
			request.setAttribute("updatemsg", msgString);
			request.getRequestDispatcher("/client/updateUser.jsp").forward(request, response);
			return;
		} else {
		
			request.setAttribute("namemsg", namemsgString);
			request.setAttribute("phonemsg", phonemsgString);
			request.getRequestDispatcher("/client/updateUser.jsp").forward(request, response);
			return;
		}
	}

}
