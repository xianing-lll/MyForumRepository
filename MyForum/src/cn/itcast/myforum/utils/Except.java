package cn.itcast.myforum.utils;

import java.util.regex.Pattern;

import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Userservice;

import java.util.regex.Matcher;



public class Except {

	Userservice userservice=new Userservice();;
	/**
	 * 验证邮箱
	 */
	public String email(String email) {
		String msgString=null;
		//验证邮箱格式
	    String regex = "^(.+)@(.+)$";
	    Pattern pattern = Pattern.compile(regex);     
	    Matcher matcher = pattern.matcher((CharSequence) email);
	    System.out.println(email + " : " + matcher.matches());
	    //验证邮箱是否已注册

	    User user=userservice.resisterchongfu(email);
	    

		if (email==null||email.equals(" ")) {
			msgString="邮箱不能为空！";
		}else if (matcher.matches()==false) {
			msgString="邮箱格式错误！";
		}else if (user!=null) {
			msgString="该邮箱已注册！";
		}
		return msgString;
	}
	/**
	 * 验证两次密码是否相等
	 */
	public String password(String password_1, String password_2) {
		String msg=null;
		if (password_1==null||password_1.equals("")||password_2==null||password_2.equals("")) {
			msg="密码不能为空！";
		} else if(!password_1.equals(password_2)) {
			msg="两次输入密码不同！";
		}
		
		return msg;
	}
	/**
	 * 验证电话号码
	 */
	public String phone(String phone) {
		String msgString = null;
		boolean result=phone.matches("[0-9]+");
		if (phone==null||phone.equals("")) {
			msgString="输入不能为空！";
		} else if(result==false){

			msgString="手机号格式错误！";
		}
		return msgString;
	}
	/**
	 * 验证登陆密码是否正确
	 */
	public String login(String email, String password) {
		String msgString=null;
		User user=userservice.loginUser(email, password);
		if (email==null||password==null||email.equals("")||password.equals("")) {
			msgString="账号或密码不能为空！";
		} else if (user==null) {
			msgString="账号或密码错误！";
		} 
		
		return msgString;
	}
	/**
	 * 验证用户名是否为空
	 */
	public String name(String name) {
		String msgString=null;
		if (name.equals("")||name==null) {
			msgString="用户名不能为空！";
		}
		return msgString;
	}
	/**
	 * 验证帖子标题内容是否为空
	 */
	public String note(String title, String essay) {
		String msgString=null;
		if (title==null||essay==null||title.equals("")||essay.equals("")) {
			msgString="标题或内容不能为空！";
		} 
		
		return msgString;
	}
	/**
	 * 验证用户名是否为空
	 */
	public String text(String text) {
		String msgString=null;
		if (text.equals("")||text==null) {
			msgString="输入不能为空！";
		}
		return msgString;
	}
}
