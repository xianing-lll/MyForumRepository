package cn.itcast.myforum.web.servlet.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import cn.itcast.myforum.dao.Userdao;
import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Userservice;



/**
 * Servlet implementation class updateheadServlet
 */
public class updateheadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateheadServlet() {
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
		System.out.println("�������ˣ�");
		User user=(User)request.getSession().getAttribute("user");
		String filename=user.getEmail();
		try {
			
			
			DiskFileItemFactory Factory=new DiskFileItemFactory();
			File f=new File("D:\\MyForumImgCache");//
			if(!f.exists()) {
				f.mkdirs();
			}
			Factory.setRepository(f);
			ServletFileUpload fileUpload=new ServletFileUpload(Factory);
			fileUpload.setHeaderEncoding("utf-8");
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			for(FileItem fileItem:fileItems) {
				if(fileItem.isFormField()==true) {
					System.out.println("����ͼƬ��ʽ!");
					
				}else if((fileItem.isFormField()==false)&&(fileItem.getName().trim()!="")&&(fileItem.getName()!=null)) {
					String webPath="/client/user_image/";  //���ͼ��ͼƬ���ļ���
				    String filePath=getServletContext().getRealPath(webPath+filename);//ͼ����Ե�ַ
				    System.out.println(filePath);
				    File file=new File(filePath);
				    file.getParentFile().mkdirs();//�õ��ļ��ĸ�Ŀ¼��������Ŀ¼
				    file.createNewFile();
				    
				    InputStream in=fileItem.getInputStream();
				    FileOutputStream out=new FileOutputStream(file);
				    byte[] buffer=new byte[1024]; 
				    int len;
				    while((len=in.read(buffer))>0) {
				    	out.write(buffer,0,len);
				    }
				    	in.close();
				    	out.close();
				    	fileItem.delete();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		 Userservice userservice=new Userservice();
		 Boolean boolean1 =userservice.updatehead(filename, user.getEmail());
		if (boolean1==true) {
			
			Userdao userdao=new Userdao();
			try {
				user=userdao.findUser(user.getEmail());
				request.getSession().setAttribute("user", user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msg", "�ϴ��ɹ���");
			request.getRequestDispatcher("/client/updatehead.jsp").forward(request, response);
			return;
		} else {

			request.setAttribute("msg", "�ϴ�ʧ�ܣ�");
			request.getRequestDispatcher("/client/updatehead.jsp").forward(request, response);
			return;
		}
	}

}
