package cn.itcast.myforum.domain;


public class Comment{

	private int comment_id; //评论id
	private int note_id;//评论文章id
	private String content;//评论内容
	private int from_id;//评论者id
	private String from_name;
	private int to_id;//被评论者id
	private String to_name;
	public int getNote_id() {
		return note_id; 
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getFrom_name() {
		return from_name;
	}
	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}


	
	
}
