package cn.itcast.myforum.service;

import java.security.Timestamp;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.itcast.myforum.dao.Notedao;
import cn.itcast.myforum.domain.Note;
import cn.itcast.myforum.domain.PageBean;

public class Noteservicee {

	Notedao notedao=new Notedao();
	/**
	 * 添加帖子
	 */
	public Boolean addNote(String email, String title, String essay) {
		Boolean boolean1=null;
		try {
			if(notedao.addNote(email, title, essay)==true) {
				boolean1=true;
			}else {
				boolean1=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Notedao类的添加帖子功能出错！");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	  *   更具页码查找所有帖子
	 * @throws SQLException 
	 */
	public PageBean findallNote( int currentPage, int currentCount ) throws SQLException {
		List<Note> list = null;
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(currentPage); //查找的当前页
		pageBean.setCurrentCount(currentCount); //每页默认数量
		int totalCount=notedao.findallNodeCount();
		int totalPage=(int)Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);  //总页数
		pageBean.setTotalCount(totalCount); //总条数
		try {
			list=notedao.findallNode(currentPage,currentCount );
			for (int i = 0; i < list.size(); i++) {
				Date timeDate=list.get(i).getTime();
				SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String date = myDateFormat.format(new Date(timeDate.getTime()));

				list.get(i).setTimesString(date);
			}
			pageBean.setNotes(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询所有帖子失败！");
			e.printStackTrace();
		}
		return pageBean;
	}
	/**
	 * 查找我的帖子
	 * @throws SQLException 
	 */
	public PageBean findallmyNote( String email,  int currentPage, int currentCount) throws SQLException {
		List<Note> list = null;
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(currentPage); //查找的当前页
		pageBean.setCurrentCount(currentCount); //每页默认数量
		int totalCount=notedao.findallMyNodeCount(email);
		int totalPage=(int)Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);  //总页数
		pageBean.setTotalCount(totalCount); //总条数
		try {
			list=notedao.findallmyNode(email, currentPage, currentCount);
			for (int i = 0; i < list.size(); i++) {
				Date timeDate=list.get(i).getTime();
				SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String date = myDateFormat.format(new Date(timeDate.getTime()));

				list.get(i).setTimesString(date);
			}
			pageBean.setNotes(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询所有帖子失败！");
			e.printStackTrace();
		}
		return pageBean;
	}
	/**
	 * 模糊搜索
	 * @throws SQLException 
	 */
	public PageBean findNoteByFind( String key,  int currentPage, int currentCount) throws SQLException {
		List<Note> list = null;
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(currentPage); //查找的当前页
		pageBean.setCurrentCount(currentCount); //每页默认数量
		int totalCount=notedao.findallNodeCountByFind(key);
		System.out.println("帖子数量："+totalCount);
		int totalPage=(int)Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);  //总页数
		pageBean.setTotalCount(totalCount); //总条数
		try {
			list=notedao.findNoteByKey(key, currentPage, currentCount);
			for (int i = 0; i < list.size(); i++) { //修改时间格式
				Date timeDate=list.get(i).getTime();
				SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String date = myDateFormat.format(new Date(timeDate.getTime()));

				list.get(i).setTimesString(date);
			}
			pageBean.setNotes(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("模糊查询帖子失败！");
			e.printStackTrace();
		}
		return pageBean;
	}
	/**
	 * 删除我的帖子
	 */
	public Boolean deletemyNote(int id) {
		Boolean boolean1 = null;
		try {
			boolean1=notedao.deletemyNote(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao层执行删除帖子失败！");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * 重新编辑帖子内容
	 */
	public Boolean updatemyNote(int note_id, String title, String essay) {
		Boolean boolean1=null;
		try {
			boolean1=notedao.updatemyNote(note_id, title, essay);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao层编辑帖子内容错误！");
			e.printStackTrace();
		}
		return boolean1;
	}
	
}
