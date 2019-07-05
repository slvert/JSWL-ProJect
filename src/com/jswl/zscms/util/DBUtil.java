package com.jswl.zscms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jswl.zscms.exception.SysException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接中间件使用c3p0数据库连接池
 * @author Abeni
 *
 */
public final class DBUtil {
	//声明一个静态的数据库连接池数据源
	static ComboPooledDataSource cpds=null;
	static {
		//创建数据库连接池数据源
		cpds=new ComboPooledDataSource();
	}
	
	/**
	 * 使用c3p0获得数据库连接的方法
	 * @return
	 */
	private Connection getConn() {
		Connection conn=null;
		try {
			//通过数据库连接池数据源对象获取数据库连接
			conn=cpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回连接
		return conn;
	}
	/**
	 * 对数据库进行增删改的方法
	 * @param sql 语句
	 * @param obj 数组 参数
	 * @return
	 * @throws SysException 自定义异常类
	 */
	public int update(String sql,Object [] obj) throws SysException {
		//创建连接对象
		Connection conn=null;
		//创建预编译对象 
		PreparedStatement ps=null;
		//定义int类型 结果
		int result=0;
		try {
			//接收连接对象 调用连接数据库的方法
			conn=getConn();
			//预编译对象 传入sql语句
			ps=conn.prepareStatement(sql);
			//判断 数据不等于空才能传参
			if (obj!=null) {
				//遍历数组
				for (int i = 0; i < obj.length; i++) {
					// 把数组的信息放到sql语句里 i+1代表null的值 ,
					//obj[i]代表数组里的字符串对应存到?占位符的位置
						ps.setObject(i+1, obj[i]);
				}
			}
			//调用预编译的增删改方法
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//抛出自定义异常
			throw new SysException(106, "系统异常，请联系管理员");
		}finally {
			//关闭资源
			close(conn, ps, null);
		}
		//返回结果
		return result;
	}
	/**
	 * 对数据库进行查询的方法
	 * @param sql 语句
	 * @param obj 参数
	 * @return 返回类型  集合 泛型Map
	 * @throws SysException 自定义异常类
	 */
	public List<Map<String, String>> query(String sql,Object [] obj) throws SysException {
		//创建连接对象
		Connection conn=null;
		//创建预编译对象 
		PreparedStatement ps=null;
		//创建结果集
		ResultSet rs=null;
		//创建list集合
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		try {
			//接收连接对象 调用连接数据库的方法
			conn=getConn();
			//预编译对象 传入sql语句
			ps=conn.prepareStatement(sql);
			// 传参 判空
			if (obj!=null) {
			//遍历数组
				for (int i = 0; i < obj.length; i++) {
				// 把数组的信息放到sql语句里 i+1代表null的值 ,
				//obj[i]代表数组里的字符串对应存到?占位符的位置
					ps.setObject(i+1, obj[i]);
			}
		}
		//获得结果集
		rs=ps.executeQuery();
		//获得结果集 结构
		ResultSetMetaData rsmd=rs.getMetaData();
		//遍历结果集 是否有下一个结果  有为true 没有为false
		while (rs.next()) {
		//创建Map集合
			Map<String, String> map=new HashMap<String, String>();
			//	遍历				结果集
				for (int i = 0; i <rsmd.getColumnCount() ; i++) {
				//获得键 从结果集结构中
				String key=rsmd.getColumnName(i+1);
				//获得值 从结果中
				String value=rs.getString(i+1);
				//存入map
				map.put(key, value);
				}
				//将map存入list
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return list;
	}
	/**
	 * 关闭资源的方法
	 * @param conn 连接
	 * @param ps 预编译对象
	 * @param rs 结果集
	 */
	public void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		
			try {
				//结果集
				if (rs!=null) {
				rs.close();
				}
				//预编译对象
				if (ps!=null) {
					ps.close();
				}
				//连接
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
		
	
}
