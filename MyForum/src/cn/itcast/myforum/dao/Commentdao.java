package cn.itcast.myforum.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.myforum.domain.Comment;
import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.utils.DataSourceUtils;

public class Commentdao {

	/**
	 * 添加评论
	 * @throws SQLException 
	 */
	public Boolean addComment(Comment comment) throws SQLException {
		
		String sqlString="insert into comment( note_id, content, from_id, to_id) values(?,?,?,?)";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int num=runner.update(sqlString, comment.getNote_id(),comment.getContent(),comment.getFrom_id(),comment.getTo_id());
		if (num>0) {
			return true;
		} else {

			return false;
		}
	}
	/**
	 * 显示每条文章下的评论
	 * @throws SQLException 
	 */
	public List<Comment> shouComments(int note_id) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sqlString="select * from comment where note_id=?";		
		List<Comment> comments=runner.query(sqlString, new BeanListHandler<Comment>(Comment.class), note_id);

		/**
		 * 查找所有评论者和被评论者的名字
		 */
		for (int i=0; i<comments.size(); i++) {
			String sqlString2="select user.name from user where user.user_id=?";
			String from_name=(String)runner.query(sqlString2,new ScalarHandler(), comments.get(i).getFrom_id());
			comments.get(i).setFrom_name(from_name);
			String sqlString3="select user.name from user where user.user_id=?";
			String to_name=(String)runner.query(sqlString3,new ScalarHandler(), comments.get(i).getTo_id());
			comments.get(i).setTo_name(to_name);
			System.out.println("dao:"+from_name+";"+to_name);
		}
		return comments;
	}
	/**
	 * 评论撤销功能
	 * @throws SQLException 
	 */
	public Boolean deleteComment(int commment_id) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sqlString="delete from comment where comment_id=?";
		int num=runner.update(sqlString, commment_id);
		if (num>0) {
			return true;
		} else {

			return false;
		}
	}

}
