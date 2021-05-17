package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Comentario;

public class InsertComentario {
	
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host é o mysql
	String URL = "mysql://tpzn2w47q6gilzml:dbsvky5oxysh2gmh@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fmdkoq614cpve0ke";
	String USER = "tpzn2w47q6gilzml";
	String PASSWORD = "dbsvky5oxysh2gmh";
	String sql = "INSERT INTO tpzn2w47q6gilzml.comentario(comentario, data_comentario, avaliacao, id_atividade, id_crianca) VALUE (?,?,?,?,?)";
	
	Comentario co = new Comentario();
	
	int resposta;
	public int InsertComentario(Comentario comen) {
		
		String comentario = comen.getComentario();
		Date data = comen.getData();
		int avaliacao = comen.getAvaliacao();
		int id_atividade = comen.getId_atividade();
		int id_crianca = comen.getId_crianca();
		
	
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	        PreparedStatement st = con.prepareStatement(sql);
	        
	        st.setString(1, comentario);
	        st.setDate(2, data);
	        st.setInt(3, avaliacao);
	        st.setInt(4,id_atividade);
	        st.setInt(5,id_crianca);
			        
	        resposta = st.executeUpdate();
	           
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 	
		return resposta;
	}
	
	

}
