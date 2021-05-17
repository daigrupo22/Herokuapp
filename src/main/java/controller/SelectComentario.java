package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Comentario;

public class SelectComentario {

	// conecta a base de dados
		String DRIVER = "com.mysql.jdbc.Driver";
		// diz que o host é o mysql
		String URL = "mysql://tpzn2w47q6gilzml:dbsvky5oxysh2gmh@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fmdkoq614cpve0ke";
		String USER = "tpzn2w47q6gilzml";
		String PASSWORD = "dbsvky5oxysh2gmh";
		String sql = "SELECT * FROM  tpzn2w47q6gilzml.comentario where id_comentario = ?";
		ResultSet rs;
	
		Comentario com = new Comentario();
		public Comentario retornaComentario(Comentario come) {
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, come.getId_comentario());
				rs = st.executeQuery();
				// executeUpdate(); se for um update
				rs.next();
				// avança no array em ves de criar um vazio

				String comentario = rs.getString("comentario");
				come.setComentario(comentario);
				Integer avaliacao = rs.getInt("avaliacao");
				come.setAvaliacao(avaliacao);
				Date datacom = rs.getDate("data");
	            come.setData(datacom);
				

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return come;
		}
}
