package main;

import java.sql.Connection;

import database.JDBCUtil;

public class Test {
	public static void main(String[] args) {
		Connection c = JDBCUtil.connect();
		JDBCUtil.printInfo(c);
		JDBCUtil.disconnect(c);
	}
}
