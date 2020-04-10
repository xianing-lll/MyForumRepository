package cn.itcast.myforum.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.impl.NewPooledConnection;

import cn.itcast.myforum.domain.User;
import cn.itcast.myforum.utils.DataSourceUtils;

public class Userdao {

	/**
	 * 添加用户
	 * @throws SQLException 
	 */
	public Boolean addUser(User user) throws SQLException {
		String sqlString="insert into user(email, password, sex, age, phone, registertime, name, imgurl) values( ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?,'moren.jpg')";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int num=runner.update(sqlString, user.getEmail(),user.getPassword(), user.getSex(), user.getAge(), user.getPhone(), user.getEmail());
		if (num>0) {
			return true;
		} else {

		return false;
		}
	}
	/**
	 * 修改用户
	 * @throws SQLException 
	 */
	public Boolean updateUser(String emailString, String nameString, String phoneString) throws SQLException {
		
		String sqlString="update user set phone=?, name=? where email=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int num=runner.update(sqlString, phoneString, nameString, emailString);
		if (num>0) {
			return true;
		} else {
		return false;
		}
	}
	/**修改用户密码
	 * @throws SQLException 
	 * 
	 */
	public Boolean updatePassword(String email, String password) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sqlString="update user set password=? where email=?";
		int num=runner.update(sqlString, password, email);
		if (num>0) {
			return true;
		} else {

			return false;
		}
	}
	/**
	 * 根据email和密码查找用户
	 * @throws SQLException 
	 */
	public User findUser(String email, String password) throws SQLException {
		String sqlString="select * from user where email=? and password=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		User user=(User)runner.query(sqlString, new BeanHandler<User>(User.class) , email, password);
		return user;
		
	}
	/**
	 * 根据email查找用户
	 * @throws SQLException 
	 */
	public User findUser(String email) throws SQLException {
		System.out.println("email"+email);
		String sqlString="select * from user where email=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		User user=(User)runner.query(sqlString, new BeanHandler<User>(User.class) , email);
		return user;
		
	}
	/**
	 * 更改用户头像
	 * @throws SQLException 
	 */
	public Boolean updatehead(String imgurl, String email) throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sqlString="update user set imgurl=? where email=?";
		int num=runner.update(sqlString, imgurl, email);
		if (num>0) {
			return true;
		} else {

			return false;
		}
	}
	
}
