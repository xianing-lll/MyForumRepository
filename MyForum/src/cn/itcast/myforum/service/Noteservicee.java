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
	 * �������
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
			System.out.println("Notedao���������ӹ��ܳ���");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	  *   ����ҳ�������������
	 * @throws SQLException 
	 */
	public PageBean findallNote( int currentPage, int currentCount ) throws SQLException {
		List<Note> list = null;
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(currentPage); //���ҵĵ�ǰҳ
		pageBean.setCurrentCount(currentCount); //ÿҳĬ������
		int totalCount=notedao.findallNodeCount();
		int totalPage=(int)Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);  //��ҳ��
		pageBean.setTotalCount(totalCount); //������
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
			System.out.println("��ѯ��������ʧ�ܣ�");
			e.printStackTrace();
		}
		return pageBean;
	}
	/**
	 * �����ҵ�����
	 * @throws SQLException 
	 */
	public PageBean findallmyNote( String email,  int currentPage, int currentCount) throws SQLException {
		List<Note> list = null;
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(currentPage); //���ҵĵ�ǰҳ
		pageBean.setCurrentCount(currentCount); //ÿҳĬ������
		int totalCount=notedao.findallMyNodeCount(email);
		int totalPage=(int)Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);  //��ҳ��
		pageBean.setTotalCount(totalCount); //������
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
			System.out.println("��ѯ��������ʧ�ܣ�");
			e.printStackTrace();
		}
		return pageBean;
	}
	/**
	 * ģ������
	 * @throws SQLException 
	 */
	public PageBean findNoteByFind( String key,  int currentPage, int currentCount) throws SQLException {
		List<Note> list = null;
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(currentPage); //���ҵĵ�ǰҳ
		pageBean.setCurrentCount(currentCount); //ÿҳĬ������
		int totalCount=notedao.findallNodeCountByFind(key);
		System.out.println("����������"+totalCount);
		int totalPage=(int)Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);  //��ҳ��
		pageBean.setTotalCount(totalCount); //������
		try {
			list=notedao.findNoteByKey(key, currentPage, currentCount);
			for (int i = 0; i < list.size(); i++) { //�޸�ʱ���ʽ
				Date timeDate=list.get(i).getTime();
				SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String date = myDateFormat.format(new Date(timeDate.getTime()));

				list.get(i).setTimesString(date);
			}
			pageBean.setNotes(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ģ����ѯ����ʧ�ܣ�");
			e.printStackTrace();
		}
		return pageBean;
	}
	/**
	 * ɾ���ҵ�����
	 */
	public Boolean deletemyNote(int id) {
		Boolean boolean1 = null;
		try {
			boolean1=notedao.deletemyNote(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao��ִ��ɾ������ʧ�ܣ�");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * ���±༭��������
	 */
	public Boolean updatemyNote(int note_id, String title, String essay) {
		Boolean boolean1=null;
		try {
			boolean1=notedao.updatemyNote(note_id, title, essay);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("dao��༭�������ݴ���");
			e.printStackTrace();
		}
		return boolean1;
	}
	
}
