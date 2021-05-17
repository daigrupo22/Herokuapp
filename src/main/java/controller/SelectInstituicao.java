package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Instituicao;

public class SelectInstituicao {

	String DRIVER = "com.mysql.jdbc.Driver"; // conecta a base de dados
	String URL = "mysql://tpzn2w47q6gilzml:dbsvky5oxysh2gmh@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fmdkoq614cpve0ke";
	String USER = "tpzn2w47q6gilzml";
	String PASSWORD = "dbsvky5oxysh2gmh";
	String sql = "SELECT * FROM  tpzn2w47q6gilzml.instituição where id_instituicao = ?";
	ResultSet rs;

	Instituicao instituicao = new Instituicao();

	public Instituicao retornaInstituicao(Instituicao inst) {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, inst.getIdInstituicao());
			rs = st.executeQuery();
			rs.next();

			String nomeInstituicao = rs.getString("nome_instituicao");
			inst.setNomeInstituicao(nomeInstituicao);

			String concelhoInstituicao = rs.getString("concelho");
			inst.setConcelho(concelhoInstituicao);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inst;

	}
}
