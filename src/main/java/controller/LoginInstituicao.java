package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginInstituicao {

	public static boolean checkUser(String username, String password) {
		boolean st = false;
		try {

			String DRIVER = "com.mysql.jdbc.Driver";
			String URL = "jdbc:mysql://remotemysql.com:3306";
			String USER = "d4YWRRmazE";
			String PASSWORD = "0HMMHO3mbT";
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM d4YWRRmazE.instituicao I WHERE I.username = ? AND I.password = ?;");
//ArrayList<Crianca> lista = new ArrayList<>();
//ResultSet rs;

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			st = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

}
