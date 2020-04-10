package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.dao.Notedao;
import cn.itcast.myforum.domain.Note;
import cn.itcast.myforum.service.Noteservicee;

/**
 * Servlet implementation class shouupdatenoteServlet
 */
public class shouupdatenoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shouupdatenoteServlet() {
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
		Notedao notedao=new Notedao();
		Note note=null;
		try {
			note=notedao.findNoteById(idString);
			request.setAttribute("note", note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		request.getRequestDispatcher("/client/updatenote.jsp").forward(request, response);
		return;
	}

}
