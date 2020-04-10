package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.myforum.domain.Note;
import cn.itcast.myforum.domain.PageBean;
import cn.itcast.myforum.listener.SessionListener;
import cn.itcast.myforum.service.Noteservicee;

/**
 * Servlet implementation class shouindexServlet
 */
public class shouindexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shouindexServlet() {
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
		int currentPage=1 ,currentCount=20;
		String _currentPage=request.getParameter("currentPage"); //��ȡ����ҳ��
		String _currentCount=request.getParameter("currentCount"); //ÿҳ��ʾ����
		if (_currentPage!=null) {
			currentPage=Integer.parseInt(_currentPage);
		}
		if (_currentCount!=null) {
			currentCount=Integer.parseInt(_currentCount);
		}
		Noteservicee noteservicee=new Noteservicee();
		PageBean pageBean;
		try {
			pageBean = noteservicee.findallNote(currentPage, currentCount);
			request.setAttribute("pageBean", pageBean);
			//System.out.println("������="+pageBean.getTotalCount()+" ��ҳ��="+pageBean.getTotalPage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String count=(String)request.getSession().getAttribute("count"); //sessionͳ����������	
		request.setAttribute("count", count);
		request.setAttribute("category", "shouindexServlet"); //���÷�ҳ��ת·��
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
		return;
	}

}
