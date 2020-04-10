package cn.itcast.myforum.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class shouresponseServlet
 */
public class shouresponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shouresponseServlet() {
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
		String from_nameString=request.getParameter("from_name"); //评论这名字
		String contentString=request.getParameter("content"); //评论内容
		String essayString=request.getParameter("essay");  //文章
		String note_idString=request.getParameter("note_id"); //文章id
		String user_idString=request.getParameter("user_id"); 
		String to_idString=request.getParameter("to_id");
		System.out.println("to_id:"+to_idString);
		request.setAttribute("to_name", from_nameString);
		request.setAttribute("content", contentString);
		request.setAttribute("essay", essayString);
		request.setAttribute("note_id", note_idString);
		request.setAttribute("user_id", user_idString);
		request.setAttribute("to_id", to_idString);
		request.getRequestDispatcher("/client/response.jsp").forward(request, response);
		return;
	}

}
