package cn.itcast.myforum.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import cn.itcast.myforum.domain.Note;
import cn.itcast.myforum.utils.DataSourceUtils;

public class Notedao {

	/**
	 * ������ӹ���
	 * @throws SQLException 
	 */
	public Boolean addNote(String email,String title, String essay) throws SQLException {
		String sqlString="insert into note(email, title, essay, time) values(?, ?, ?, CURRENT_TIMESTAMP)";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int num=runner.update(sqlString, email, title, essay);
		if (num>0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ɾ������
	 * @throws SQLException 
	 */
	public Boolean deleteNote(String email, String title) throws SQLException {
		String sqlString="delete from note where email=? and title=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int num=runner.update(sqlString, email, title);
		if (num>0) {
			return true;
		} else {

			return false;
		}
	}
	/**
	 * ����ҳ����ʾ���ӱ���
	 * @throws SQLException 
	 */
	public List<Note> findallNode(int currentPage, int currentCount ) throws SQLException {
		String sqlString="select user.user_id,user.name,user.imgurl,note.note_id,note.title,note.essay,note.time from note,user where user.email=note.email order by note_id DESC limit ?, ?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		List<Note> list=runner.query(sqlString, new BeanListHandler<Note>(Note.class), currentCount*(currentPage-1), currentCount);
		return list;
	}
	/**
	 * ��ʾ����������
	 * @throws SQLException 
	 */
	public int findallNodeCount() throws SQLException {
		String sqlString="select COUNT(*) from note";
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		Long count=(Long) queryRunner.query(sqlString, new ScalarHandler());
		return count.intValue(); //��longת��Ϊint����
	}
	/**
	 * ��ʾĳ���û�����������
	 * @throws SQLException 
	 */
	public int findallMyNodeCount(String email) throws SQLException {
		String sqlString="select COUNT(*) from note where email=?";
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		Long count=(Long) queryRunner.query(sqlString, new ScalarHandler(), email);
		return count.intValue(); //��longת��Ϊint����
	}
	/**
	 * ��ʾģ����������������
	 * @throws SQLException 
	 */
	public int findallNodeCountByFind(String key) throws SQLException {
		String sqlString="select COUNT(user.name) from note, user where CONCAT(note.email,note.title,note.essay,user.name)  LIKE '%"+key+"%' and note.email=user.email";
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		Long count=(Long) queryRunner.query(sqlString, new ScalarHandler());
		return count.intValue(); //��longת��Ϊint����
	}
	/**
	 * ��ʾ�ҵ�����
	 * @throws SQLException 
	 */
	public List<Note> findallmyNode(String email, int currentPage, int currentCount) throws SQLException {
		String sqlString="select user.user_id,user.name,user.imgurl,note.note_id,note.title,note.essay,note.time from note,user where note.email=? and user.email=note.email order by note_id DESC limit ?, ?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		List<Note> list=runner.query(sqlString, new BeanListHandler<Note>(Note.class), email, currentCount*(currentPage-1), currentCount);
		return list;
	}
	/**
	 * ��������id����������
	 * @throws SQLException 
	 */
	public Note findNoteById(int id) throws SQLException {
		String sqlString="select note.*, user.* from note, `user` where note_id=? and note.email=user.email";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        Note note=runner.query(sqlString, new BeanHandler<Note>(Note.class), id);
        return note;
	}
	/**
	 * ģ����������
	 * @throws SQLException 
	 */
	public List<Note> findNoteByKey(String key, int currentPage, int currentCount) throws SQLException {
		String sqlString="select note.*, user.* from note, user where CONCAT(note.email,note.title,note.essay, note.time,user.name)  LIKE '%"+key+"%' and note.email=user.email order by note_id DESC limit ?, ?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        List<Note> notes=runner.query(sqlString, new BeanListHandler<Note>(Note.class), currentCount*(currentPage-1), currentCount);
        return notes;
	}
	/**
	 * ��������id,ɾ������
	 * @throws SQLException 
	 */
	public Boolean deletemyNote(int note_id) throws SQLException {
		String sqlString="delete from note where note_id=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int num=runner.update(sqlString, note_id);
		if (num>0) {
			return true;
		} else {

			return false;
		}

	}
	/**
	 * ��������note_id�༭����
	 * @param note_id
	 * @param title
	 * @param essay
	 * @return
	 * @throws SQLException
	 */
	public Boolean updatemyNote(int note_id, String title, String essay) throws SQLException {
		String sqlString="update note set title=?, essay=? where note_id=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int num=runner.update(sqlString, title, essay, note_id);
		if (num>0) {
			return true;
		} else {

			return false;
		}
		
	}
}
