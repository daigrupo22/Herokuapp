package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Sugestao;

public class InsertSugestao {

	// conecta a base de dados
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host é o mysql
	String URL = "mysql://tpzn2w47q6gilzml:dbsvky5oxysh2gmh@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fmdkoq614cpve0ke";
	String USER = "tpzn2w47q6gilzml";
	String PASSWORD = "dbsvky5oxysh2gmh";
	String sql = "INSERT INTO tpzn2w47q6gilzml.sugestao(data, sugestao, id_crianca) VALUE (?,?, ?)";

	Sugestao sug = new Sugestao();

	int resposta;

	public int criarSugestao(Sugestao sug) {

		Date data = sug.getData();
		String sugestao = sug.getSugestao();
		int id_crianca = sug.getIdCrianca();
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setDate(1, data);
			st.setString(2, sugestao);
			st.setInt(3, id_crianca);
			
			resposta = st.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposta;
	}

}
