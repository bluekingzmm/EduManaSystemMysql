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

	
		private static String url="jdbc:mysql://localhost:3306/jwglxt?useUicode=ture&characterEncoding=utf-8";	//数据库连接字串
		private static String userName="root";			//数据库用户名称
		private static String driver="com.mysql.jdbc.Driver";		//数据库驱动名称
		private static String pwd="root";			               //数据库用户登陆密码
			//ThreadLocal 当前线程局部变量
		@SuppressWarnings("rawtypes")
		private static ThreadLocal connection=new ThreadLocal();

				//	getConn方法用于获取数据库连接
			/**
			 * synchronized 控制对类成员变量的访问：每个类实例对应一把锁，
			 * 每个 synchronized 方法都必须获得调用该方法的类实例的锁方能执行，
			 * 否则所属线程阻塞，方法一旦执行，就独占该锁，直到从该方法返回时才
			 * 将锁释放，此后被阻塞的线程方能获得该锁，重新进入可执行状态。这种机制
			 * 确保了同一时刻对于每一个类实例，其所有声明为 synchronized 的成员函数
			 * 中至多只有一个处于可执行状态（因为至多只有一个能够获得该类实例对应的锁），
			 * 从而有效避免了类成员变量的访问冲突
			 */ 
			@SuppressWarnings({ "unchecked", "unused" })
			public synchronized static Connection getConn()throws SQLException{
				Connection con=(Connection) connection.get();
				if (con!=null && !con.isClosed()){
					return con;
				}
					try{
						
						@SuppressWarnings("rawtypes")
						Class providerClass=Class.forName(driver);//加载驱动
						con=DriverManager.getConnection(url,userName,pwd);
						//setAutoCommit
						//将此连接的自动提交模式设置为给定状态。如果连接处于自动提交模式下，则将执行其所有 SQL 语句，并将这些语句作为单独的事务提交。
						//否则，其 SQL 语句将成组地进入通过调用 commit 方法或 rollback 方法终止的事务中。默认情况下，新的连接处于自动提交模式下。 
						con.setAutoCommit(false);//禁止事务自动提交
						connection.set(con);
						return con;//返回数据库连接
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					return null;
			}
			//commit 使自从上一次提交/回滚以来进行的所有更改成为持久更改，并释放此 Connection 对象当前保存的所有数据库锁定。
			//  此方法应该只在已禁用自动提交模式时使用。 
			public static void commit(){
				Connection con=(Connection) connection.get();
				try{
					con.commit();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			//回滚事务
			public static void rollback(){
				Connection con=(Connection) connection.get();
				try{
					con.rollback();//事务回滚
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			//释放数据库连接
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
