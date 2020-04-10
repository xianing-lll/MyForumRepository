package cn.itcast.myforum.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {

	//ComboPooledDataSource是c3p0中DataSource的实现类
		private static DataSource dataSource=new ComboPooledDataSource();
		private static ThreadLocal<Connection> tL=new ThreadLocal<Connection>();
		//ThreadLocal是线程池
		public static DataSource getDataSource() {   //DataSource该接口定义了两个方法与
			//数据库获得链接
			return dataSource;
			
		}
		
		/*
		 * 当DBUtils需要手动控制事务时，调用该方法获得一个连接
		 * 用该方法连接数据库
		 */
		public static Connection getConnection() throws SQLException {
			Connection condition=tL.get();
			if (condition==null) {
				condition=dataSource.getConnection();
				tL.set(condition);
			}
			return condition;
		}
		
		/*
		 * 开启事务
		 */
		public static void startTransaction() throws SQLException {
			Connection connection=getConnection();//获取一个数据库连接
			if (connection!=null) {
				connection.setAutoCommit(false);
				//false：sql命令的提交由应用程序负责，程序必须调用commit或者rollback方法 
				//true：sql命令的提交（commit）由驱动程序负责 
			}
		}
		
		/*
		 * 从threadlocal中释放并关闭connection,并结束事务
		 */
		public static void releaseAndCloseConnection() throws SQLException {
			Connection connection=getConnection();
			if (connection!=null) {
				connection.commit();
				tL.remove();
				connection.close();
			}
		}
		
		/*
		 * 事务回滚
		 */
		public static void rollback() throws SQLException {
			Connection connection=getConnection();
			if (connection!=null) {
				connection.rollback();
			}
		}
	
}
