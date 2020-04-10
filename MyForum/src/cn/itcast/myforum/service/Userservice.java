package cn.itcast.myforum.service;

import java.sql.SQLException;

import cn.itcast.myforum.dao.Userdao;
import cn.itcast.myforum.domain.User;

public class Userservice {

	Userdao userdao=new Userdao();
	/**
	 * 注册操作
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
			System.out.println("Userservice层：注册失败！");
			e.printStackTrace();
		}
		return numBoolean;
	}
	/**
	 * 验证用户名是否重复
	 */
	public User resisterchongfu(String email) {
		User user = null;
		try {
			user=userdao.findUser(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Userservice层：验证用户是否重复失败！");
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 登陆操作
	 */
	public User loginUser(String email, String password) {
		User user = null;
		try {
			user=userdao.findUser(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Userservice层：登录失败！");
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 修改用户信息
	 */
	public Boolean updateUser(String emailString, String name, String phone) {
		Boolean boolean1 = null;
		try {
			boolean1=userdao.updateUser(emailString ,name, phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Userservice层：修改用户信息失败！");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * 修改用户头像
	 */
	public Boolean updatehead(String imgurl, String email) {
		Boolean boolean1=null;
		try {
			boolean1=userdao.updatehead(imgurl, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("userdao层修改用户头像失败");
			e.printStackTrace();
		}
		return boolean1;
	}
	/**
	 * 修改用户密码
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
