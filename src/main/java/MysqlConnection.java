package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/xirwe?characterEncoding=utf-8";
		String username = "root";
		String password = "xpar";

		// 获得连接对象
		Connection con = DriverManager.getConnection(url, username, password);

		// 获取执行对象
		Statement sta = con.createStatement();

		String sql = "select * from TTRD_CFETS_B_TRADE_MEMBER";

		// 执行获得结果
		ResultSet result = sta.executeQuery(sql);

		while (result.next()) {
			System.out.println(result.getString("CH_NAME"));
		}

		// 关闭资源
		result.close();
		sta.close();
		con.close();

	}

}
