/**
 * 
 */
package com.edu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public abstract class DataBase {

	
		private static String url="jdbc:mysql://localhost:3306/jwglxt?useUicode=ture&characterEncoding=utf-8";	//���ݿ������ִ�
		private static String userName="root";			//���ݿ��û�����
		private static String driver="com.mysql.jdbc.Driver";		//���ݿ���������
		private static String pwd="root";			               //���ݿ��û���½����
			//ThreadLocal ��ǰ�ֲ߳̾�����
		@SuppressWarnings("rawtypes")
		private static ThreadLocal connection=new ThreadLocal();

				//	getConn�������ڻ�ȡ���ݿ�����
			/**
			 * synchronized ���ƶ����Ա�����ķ��ʣ�ÿ����ʵ����Ӧһ������
			 * ÿ�� synchronized �����������õ��ø÷�������ʵ����������ִ�У�
			 * ���������߳�����������һ��ִ�У��Ͷ�ռ������ֱ���Ӹ÷�������ʱ��
			 * �����ͷţ��˺��������̷߳��ܻ�ø��������½����ִ��״̬�����ֻ���
			 * ȷ����ͬһʱ�̶���ÿһ����ʵ��������������Ϊ synchronized �ĳ�Ա����
			 * ������ֻ��һ�����ڿ�ִ��״̬����Ϊ����ֻ��һ���ܹ���ø���ʵ����Ӧ��������
			 * �Ӷ���Ч���������Ա�����ķ��ʳ�ͻ
			 */ 
			@SuppressWarnings({ "unchecked", "unused" })
			public synchronized static Connection getConn()throws SQLException{
				Connection con=(Connection) connection.get();
				if (con!=null && !con.isClosed()){
					return con;
				}
					try{
						
						@SuppressWarnings("rawtypes")
						Class providerClass=Class.forName(driver);//��������
						con=DriverManager.getConnection(url,userName,pwd);
						//setAutoCommit
						//�������ӵ��Զ��ύģʽ����Ϊ����״̬��������Ӵ����Զ��ύģʽ�£���ִ�������� SQL ��䣬������Щ�����Ϊ�����������ύ��
						//������ SQL ��佫����ؽ���ͨ������ commit ������ rollback ������ֹ�������С�Ĭ������£��µ����Ӵ����Զ��ύģʽ�¡� 
						con.setAutoCommit(false);//��ֹ�����Զ��ύ
						connection.set(con);
						return con;//�������ݿ�����
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					return null;
			}
			//commit ʹ�Դ���һ���ύ/�ع��������е����и��ĳ�Ϊ�־ø��ģ����ͷŴ� Connection ����ǰ������������ݿ�������
			//  �˷���Ӧ��ֻ���ѽ����Զ��ύģʽʱʹ�á� 
			public static void commit(){
				Connection con=(Connection) connection.get();
				try{
					con.commit();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			//�ع�����
			public static void rollback(){
				Connection con=(Connection) connection.get();
				try{
					con.rollback();//����ع�
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			//�ͷ����ݿ�����
			public synchronized static void releaseConnection(Connection connection){
				try{
					if (connection!= null && !connection.isClosed())
						connection.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				connection=null;
			}
			
			public static void main(String[] args){
				try{
					DataBase.getConn();
					System.out.println("ok");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
}
