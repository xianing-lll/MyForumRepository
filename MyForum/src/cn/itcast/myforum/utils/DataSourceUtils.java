package cn.itcast.myforum.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {

	//ComboPooledDataSource��c3p0��DataSource��ʵ����
		private static DataSource dataSource=new ComboPooledDataSource();
		private static ThreadLocal<Connection> tL=new ThreadLocal<Connection>();
		//ThreadLocal���̳߳�
		public static DataSource getDataSource() {   //DataSource�ýӿڶ���������������
			//���ݿ�������
			return dataSource;
			
		}
		
		/*
		 * ��DBUtils��Ҫ�ֶ���������ʱ�����ø÷������һ������
		 * �ø÷����������ݿ�
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
		 * ��������
		 */
		public static void startTransaction() throws SQLException {
			Connection connection=getConnection();//��ȡһ�����ݿ�����
			if (connection!=null) {
				connection.setAutoCommit(false);
				//false��sql������ύ��Ӧ�ó����𣬳���������commit����rollback���� 
				//true��sql������ύ��commit�������������� 
			}
		}
		
		/*
		 * ��threadlocal���ͷŲ��ر�connection,����������
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
		 * ����ع�
		 */
		public static void rollback() throws SQLException {
			Connection connection=getConnection();
			if (connection!=null) {
				connection.rollback();
			}
		}
	
}
