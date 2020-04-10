package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import cn.itcast.myforum.domain.Comment;
import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Commentservice;
import cn.itcast.myforum.utils.Except;

/**
 * Servlet implementation class addcommentServlet
 */
public class addcommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcommentServlet() {
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
	 * 向博主发表评论
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String commentString=request.getParameter("comment"); //评论内容
		Except except=new Except();//判断是否为空
		String msg=except.text(commentString);
		int note_idString=Integer.parseInt(request.getParameter("note_id"));
		int to_id=Integer.parseInt(request.getParameter("user_id"));
		
		System.err.println("user_id:"+to_id);
		if (request.getSession().getAttribute("user")==null) {
			response.sendRedirect(request.getContextPath()+"/client/login.jsp");
			return;
		}
		User user=(User) request.getSession().getAttribute("user");		
		int from_idString=user.getUser_id();
		if (msg==null) {		
			Comment comment = new Comment();
			comment.setContent(commentString);
			comment.setNote_id(note_idString);
		    comment.setFrom_id(from_idString);
		    comment.setTo_id(to_id);
		    
			Commentservice commentservice=new Commentservice();
			commentservice.addcomment(comment);
			request.setAttribute("note_id", note_idString);
			request.getRequestDispatcher("/shouessayServlet").forward(request, response);
			return;

		} else {

			request.setAttribute("msg", "评论不能为空！");
			request.setAttribute("note_id", note_idString);
			request.getRequestDispatcher("/shouessayServlet").forward(request, response);
			return;
		}
				
	}

}
