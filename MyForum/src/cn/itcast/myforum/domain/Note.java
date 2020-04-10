package cn.itcast.myforum.domain;

import java.util.Date;

public class Note extends User{

	private int note_id;
	private String title;
	private String essay;
	private Date time;
	private String timesString;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String getTimesString() {
		return timesString;
	}
	public void setTimesString(String timesString) {
		this.timesString = timesString;
	}
	@Override
	public String toString() {
		return "Note [note_id=" + note_id + ", title=" + title + ", essay=" + essay + ", time=" + time
				+ ", timesString=" + timesString + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getSex()=" + getSex() + ", getAge()=" + getAge() + ", getPhone()=" + getPhone()
				+ ", getResisttimeData()=" + getResisttimeData() + ", getName()=" + getName() + ", getImgurl()="
				+ getImgurl() + ", getUser_id()=" + getUser_id() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
