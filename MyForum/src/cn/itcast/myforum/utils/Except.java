package cn.itcast.myforum.utils;

import java.util.regex.Pattern;

import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.service.Userservice;

import java.util.regex.Matcher;



public class Except {

	Userservice userservice=new Userservice();;
	/**
	 * ��֤����
	 */
	public String email(String email) {
		String msgString=null;
		//��֤�����ʽ
	    String regex = "^(.+)@(.+)$";
	    Pattern pattern = Pattern.compile(regex);     
	    Matcher matcher = pattern.matcher((CharSequence) email);
	    System.out.println(email + " : " + matcher.matches());
	    //��֤�����Ƿ���ע��

	    User user=userservice.resisterchongfu(email);
	    

		if (email==null||email.equals(" ")) {
			msgString="���䲻��Ϊ�գ�";
		}else if (matcher.matches()==false) {
			msgString="�����ʽ����";
		}else if (user!=null) {
			msgString="��������ע�ᣡ";
		}
		return msgString;
	}
	/**
	 * ��֤���������Ƿ����
	 */
	public String password(String password_1, String password_2) {
		String msg=null;
		if (password_1==null||password_1.equals("")||password_2==null||password_2.equals("")) {
			msg="���벻��Ϊ�գ�";
		} else if(!password_1.equals(password_2)) {
			msg="�����������벻ͬ��";
		}
		
		return msg;
	}
	/**
	 * ��֤�绰����
	 */
	public String phone(String phone) {
		String msgString = null;
		boolean result=phone.matches("[0-9]+");
		if (phone==null||phone.equals("")) {
			msgString="���벻��Ϊ�գ�";
		} else if(result==false){

			msgString="�ֻ��Ÿ�ʽ����";
		}
		return msgString;
	}
	/**
	 * ��֤��½�����Ƿ���ȷ
	 */
	public String login(String email, String password) {
		String msgString=null;
		User user=userservice.loginUser(email, password);
		if (email==null||password==null||email.equals("")||password.equals("")) {
			msgString="�˺Ż����벻��Ϊ�գ�";
		} else if (user==null) {
			msgString="�˺Ż��������";
		} 
		
		return msgString;
	}
	/**
	 * ��֤�û����Ƿ�Ϊ��
	 */
	public String name(String name) {
		String msgString=null;
		if (name.equals("")||name==null) {
			msgString="�û�������Ϊ�գ�";
		}
		return msgString;
	}
	/**
	 * ��֤���ӱ��������Ƿ�Ϊ��
	 */
	public String note(String title, String essay) {
		String msgString=null;
		if (title==null||essay==null||title.equals("")||essay.equals("")) {
			msgString="��������ݲ���Ϊ�գ�";
		} 
		
		return msgString;
	}
	/**
	 * ��֤�û����Ƿ�Ϊ��
	 */
	public String text(String text) {
		String msgString=null;
		if (text.equals("")||text==null) {
			msgString="���벻��Ϊ�գ�";
		}
		return msgString;
	}
}
