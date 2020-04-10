package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.domain.Note;
import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Noteservicee;
import cn.itcast.myforum.utils.Except;

/**
 * Servlet implementation class addnoteServlet
 */
public class addnoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnoteServlet() {
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
		User user=(User)request.getSession().getAttribute("user");
		String emailString=user.getEmail();
		System.out.println("session"+emailString);
		String titleString=request.getParameter("titletext");
		String essayString=request.getParameter("essaytext");
		Except except=new Except();
	    String msgString=except.note(titleString, essayString);
	    if (msgString==null) {
			Noteservicee noteservicee=new Noteservicee();
			
			if (noteservicee.addNote(emailString, titleString, essayString)==true) {
				request.setAttribute("msg", "发表成功！");
				request.getRequestDispatcher("/client/addnote.jsp").forward(request, response);
				
			}
		} else {

			
			request.setAttribute("msg", msgString);
			request.getRequestDispatcher("/client/addnote.jsp").forward(request, response);
		}
		
		
	}

}
