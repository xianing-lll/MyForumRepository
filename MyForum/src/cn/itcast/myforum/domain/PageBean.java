package cn.itcast.myforum.domain;

import java.util.List;


/**
 * ��ҳ��ʾ����
 * @author ����
 *
 */
public class PageBean {

	private int currentPage;//��ǰҳ��
	private int totalCount;// ������
	private int totalPage;// ��ҳ��
	private int currentCount;// ÿҳ����
	private List<Note> notes;//  ÿҳ��ʾ������
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	

}