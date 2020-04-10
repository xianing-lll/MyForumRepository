package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.domain.Note;
import cn.itcast.myforum.domain.PageBean;
import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Noteservicee;
import cn.itcast.myforum.service.Userservice;

/**
 * Servlet implementation class shoumynoteServlet
 */
public class shoumynoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoumynoteServlet() {
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
		//验证是否登录
		if (request.getSession().getAttribute("user")==null||request.getSession().getAttribute("user").equals("")) {
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		int currentPage=1 ,currentCount=20;
		String _currentPage=request.getParameter("currentPage"); //获取请求页数
		String _currentCount=request.getParameter("currentCount"); //每页显示数量
		if (_currentPage!=null) {
			currentPage=Integer.parseInt(_currentPage);
		}
		if (_currentCount!=null) {
			currentCount=Integer.parseInt(_currentCount);
		}
		User user=(User)request.getSession().getAttribute("user");
		String emailString=user.getEmail();
		Noteservicee noteservicee=new Noteservicee();
		PageBean pageBean = null;
		try {
			pageBean = noteservicee.findallmyNote(emailString, currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("delete", "删除");
		request.setAttribute("update", "重新编辑");
		request.setAttribute("category", "shoumynoteServlet"); //设置分页跳转路径
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
		return;
	}

}
