package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Crianca;

public class SelectCrianca {

	String DRIVER = "com.mysql.jdbc.Driver"; // conecta a base de dados
	String URL = "mysql://tpzn2w47q6gilzml:dbsvky5oxysh2gmh@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fmdkoq614cpve0ke";
	String USER = "tpzn2w47q6gilzml";
	String PASSWORD = "dbsvky5oxysh2gmh";
	String sql = "SELECT * FROM  tpzn2w47q6gilzml.crianca where id_crianca = ?";
	ResultSet rs;

	Crianca crianca = new Crianca();

	public Crianca retornaCrianca(Crianca cri) {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cri.getIdCrianca());
			rs = st.executeQuery();
			rs.next(); // avança no array em ves de criar um vazio

			String nomeCrianca = rs.getString("nome_crianca");
			cri.setNomeCrianca(nomeCrianca);

			Integer idadeCrianca = rs.getInt("idade");
			cri.setIdade(idadeCrianca);

			String concelhoCrianca = rs.getString("concelho");
			cri.setConcelho(concelhoCrianca);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cri;

	}
}
