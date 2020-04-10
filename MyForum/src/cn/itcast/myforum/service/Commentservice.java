package cn.itcast.myforum.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.myforum.dao.Commentdao;
import cn.itcast.myforum.domain.Comment;

public class Commentservice {

	Commentdao commentdao=new Commentdao();
	/**
	 * 添加评论
	 */
	public Boolean addcomment(Comment comment) {
		Boolean boolean1=null;
		try {
			boolean1=commentdao.addComment(comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao层添加评论出错！");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * 显示博主评论
	 */
	public List<Comment> shouComments(int note_id) {
	
		List<Comment> comments=null;
		try {
			comments=commentdao.shouComments(note_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao层显示评论失败！");
			e.printStackTrace();
		}
		return comments;
	}
}
