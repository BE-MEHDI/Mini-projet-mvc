package Sebo_dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBconnection {
	public static  class DbConnection {
		private static Connection con;
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sebo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static Connection getConnection() {
			return con;
		}
		public static void setConnection(Connection connection) {
			con=connection;
		}
	}

}
