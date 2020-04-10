package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.myforum.service.Noteservicee;

/**
 * Servlet implementation class deletemynoteServlet
 */
public class deletemynoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletemynoteServlet() {
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
	 * É¾³ýÎÒµÄÌû×Ó
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString=request.getParameter("note_id");
		System.out.println(idString);
		int note_id=Integer.parseInt(idString);
		Noteservicee noteservicee=new Noteservicee();
		if (noteservicee.deletemyNote(note_id)==true) {
			request.getRequestDispatcher("/shoumynoteServlet").forward(request, response);
			return;
		} else {

			System.out.println("É¾³ýÊ§°Ü£¡");
		}
		
	}

}
