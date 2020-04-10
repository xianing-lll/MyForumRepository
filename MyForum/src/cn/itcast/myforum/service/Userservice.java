package cn.itcast.myforum.service;

import java.sql.SQLException;

import cn.itcast.myforum.dao.Userdao;
import cn.itcast.myforum.domain.User;

public class Userservice {

	Userdao userdao=new Userdao();
	/**
	 * ע�����
	 */
	public Boolean resiger(User user) {
		Boolean numBoolean=null;
		try {
			if (userdao.addUser(user)==true) {
				numBoolean= true;
			} else {

				numBoolean= false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Userservice�㣺ע��ʧ�ܣ�");
			e.printStackTrace();
		}
		return numBoolean;
	}
	/**
	 * ��֤�û����Ƿ��ظ�
	 */
	public User resisterchongfu(String email) {
		User user = null;
		try {
			user=userdao.findUser(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Userservice�㣺��֤�û��Ƿ��ظ�ʧ�ܣ�");
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ��½����
	 */
	public User loginUser(String email, String password) {
		User user = null;
		try {
			user=userdao.findUser(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Userservice�㣺��¼ʧ�ܣ�");
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * �޸��û���Ϣ
	 */
	public Boolean updateUser(String emailString, String name, String phone) {
		Boolean boolean1 = null;
		try {
			boolean1=userdao.updateUser(emailString ,name, phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Userservice�㣺�޸��û���Ϣʧ�ܣ�");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * �޸��û�ͷ��
	 */
	public Boolean updatehead(String imgurl, String email) {
		Boolean boolean1=null;
		try {
			boolean1=userdao.updatehead(imgurl, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("userdao���޸��û�ͷ��ʧ��");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * �޸��û�����
	 */
	public Boolean updatePassword(String email, String password) {
		Boolean boolean1=null;
		try {
			if (userdao.updatePassword(email, password)) {
				boolean1=true;
			} else {

				boolean1=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boolean1;
	}
}
