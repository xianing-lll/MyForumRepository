package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Noteservicee;
import cn.itcast.myforum.utils.Except;

/**
 * Servlet implementation class updatenoteServlet
 */
public class updatenoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatenoteServlet() {
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
	 * 重新编辑我的帖子
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    int id=Integer.parseInt((String)(request.getParameter("note_id")));
		String titleString=request.getParameter("titletext");
		String essayString=request.getParameter("essaytext");
		Except except=new Except();
	    String msgString=except.note(titleString, essayString);
	    if (msgString==null) {
			Noteservicee noteservicee=new Noteservicee();
			
			if (noteservicee.updatemyNote(id, titleString, essayString)==true) {
				request.setAttribute("msg", "更新成功！");
				request.getRequestDispatcher("/client/updatenote.jsp").forward(request, response);
				
			}
		} else {

			
			request.setAttribute("msg", msgString);
			request.getRequestDispatcher("/client/updatenote.jsp").forward(request, response);
		}
		
		
	}

}
