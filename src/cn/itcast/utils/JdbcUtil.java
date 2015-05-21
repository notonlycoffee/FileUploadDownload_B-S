package cn.itcast.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	private static DataSource ds;
	static {
		ds = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		return ds;
	}

	public static Connection getConnection() {
		Connection conn = tl.get();
		try {
			if (conn == null) {
				conn = ds.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void startTransaction() {
		Connection conn = tl.get();
		if (conn == null) {
			conn = getConnection();
			tl.set(conn);
		}
		try {
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void commitTransaction() {
		Connection conn = tl.get();
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void closeConnection() {

		Connection conn = tl.get();
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				tl.remove();
			}
		}

	}

}
