package com.itcast.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
	

	public static void main(String[] args)throws Exception {
	//1.加载驱动
	Class.forName("com.mysql.jdbc.Driver");
	//2.获取连接   connection(  DriverManager 驱动)
	String url="jdbc:mysql://127.0.0.1:3306/mybatis-912";
	String user="root";
	String password="214719";
	Connection connection = DriverManager.getConnection(url,user,password);
	//3.获取预编译对象 prepareStatement
	String sql ="select*from tb_user where id =?";
	PreparedStatement prepareStatement = connection.prepareStatement(sql);
	//4.设置参数
	prepareStatement.setLong(1, 1l);
	//5.执行查询，获取结果集
	ResultSet resultSet = prepareStatement.executeQuery();
	//6.处理结果集
	while(resultSet.next()){
		System.out.println("user_name");
		System.out.println("password");
		System.out.println("age");
	}
	//7.关闭连接，释放资源
	resultSet.close();
	prepareStatement.close();
	connection.close();
	}
}
