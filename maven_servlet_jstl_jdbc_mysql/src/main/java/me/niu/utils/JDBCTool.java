package me.niu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Niu
 * @data 2017年6月20日 上午9:30:56
 */

public class JDBCTool {
	public static final String URL = "jdbc:mysql://127.0.0.1/maven_blog";
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASSWORD = "123";

	private Connection conn = null;
	private PreparedStatement pStatement = null;
	private ResultSet rs = null;

	/**
	 * 静态查询
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet select(String sql) {
		if(conn == null){
			setConnection();
		}
		try {
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public void setConnection() {
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("JDBC: 数据库连接成功！");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 关闭连接
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pStatement != null) {
				pStatement.close();
				System.out.println("JDBC: pStatement已关闭！");
			}
			if (conn != null) {
				conn.close();
				System.out.println("JDBC: 数据库连接关闭！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		JDBCTool jdbcTool = new JDBCTool();
		ResultSet rs = jdbcTool.select("select * from POST");
		try {
			while (rs.next()) {
				System.out.println(rs.getString("SUMMARY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbcTool.close();
	}

}
