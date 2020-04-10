package cn.itcast.myforum.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.myforum.dao.Commentdao;
import cn.itcast.myforum.domain.Comment;

public class Commentservice {

	Commentdao commentdao=new Commentdao();
	/**
	 * �������
	 */
	public Boolean addcomment(Comment comment) {
		Boolean boolean1=null;
		try {
			boolean1=commentdao.addComment(comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao��������۳���");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * ��ʾ��������
	 */
	public List<Comment> shouComments(int note_id) {
	
		List<Comment> comments=null;
		try {
			comments=commentdao.shouComments(note_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao����ʾ����ʧ�ܣ�");
			e.printStackTrace();
		}
		return comments;
	}
}
