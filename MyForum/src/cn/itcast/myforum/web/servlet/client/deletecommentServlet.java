package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.dao.Commentdao;

/**
 * Servlet implementation class deletecommentServlet
 */
public class deletecommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecommentServlet() {
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
	 * 评论撤销
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    int commment_id=Integer.parseInt(request.getParameter("comment_id"));
	    int note_id=Integer.parseInt(request.getParameter("note_id"));
	    Commentdao commentdao=new Commentdao();

		try {
			commentdao.deleteComment(commment_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除评论出错！");
			e.printStackTrace();
		}
	   
			request.setAttribute("note_id", note_id);
			request.getRequestDispatcher("/shouessayServlet").forward(request, response);
			return;

	}

}
