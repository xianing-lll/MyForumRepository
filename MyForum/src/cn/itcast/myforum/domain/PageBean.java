package cn.itcast.myforum.domain;

import java.util.List;


/**
 * 分页显示功能
 * @author 夏宁
 *
 */
public class PageBean {

	private int currentPage;//当前页码
	private int totalCount;// 总条数
	private int totalPage;// 总页数
	private int currentCount;// 每页条数
	private List<Note> notes;//  每页显示的数据
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
