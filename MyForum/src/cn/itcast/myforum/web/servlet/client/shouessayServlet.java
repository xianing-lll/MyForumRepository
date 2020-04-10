package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.dao.Notedao;
import cn.itcast.myforum.domain.Comment;
import cn.itcast.myforum.domain.Note;
import cn.itcast.myforum.service.Commentservice;
import cn.itcast.myforum.service.Noteservicee;

/**
 * Servlet implementation class shouessayServlet
 */
public class shouessayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shouessayServlet() {
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
		int idString=Integer.parseInt(request.getParameter("note_id"));
		
		Note note_2 = null;
        Notedao notedao=new Notedao();
        try {
			note_2=notedao.findNoteById(idString);
			System.out.println("note_id"+note_2.getNote_id()+"; user_id:"+note_2.getUser_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("note", note_2);
		Commentservice commentservice=new Commentservice();
		List<Comment> comments=commentservice.shouComments(idString);

		request.setAttribute("comments", comments);
		request.getRequestDispatcher("/client/noteessay.jsp").forward(request, response);
		return;
	}

}
