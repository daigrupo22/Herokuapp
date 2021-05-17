package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Material;

public class InsertMaterial {


	// conecta a base de dados
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host é o mysql
	String URL = "mysql://tpzn2w47q6gilzml:dbsvky5oxysh2gmh@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fmdkoq614cpve0ke";
	String USER = "tpzn2w47q6gilzml";
	String PASSWORD = "dbsvky5oxysh2gmh";
	String sql = "INSERT INTO tpzn2w47q6gilzml.crianca(nome_crianca, idade, concelho_crianca, username, password, email) VALUE (?,?,?,?,?,?)";
	
	Material mat = new Material();
	
	int resposta;
	
	public int inserirMaterial(Material m) {
		
		String material = m.getConteudo();
		int id_crianca = m.getIdCrianca();
		int id_atividade = m.getIdAtividade();
				
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, material);
			st.setInt(2, id_crianca);
			st.setInt(3, id_atividade);
			
			
			resposta = st.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposta;
		
		
		
		
		
		
	}
	
	
	
	
	
}
