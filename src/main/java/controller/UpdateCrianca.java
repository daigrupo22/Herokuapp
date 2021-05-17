package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Crianca;

public class UpdateCrianca {

	//conecta a base de dados
		String DRIVER = "com.mysql.jdbc.Driver";
		// diz que o host é o mysql
		String URL = "mysql://tpzn2w47q6gilzml:dbsvky5oxysh2gmh@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fmdkoq614cpve0ke";
		String USER = "	tpzn2w47q6gilzml";
		String PASSWORD = "dbsvky5oxysh2gmh";
		String sql = "UPDATE d4YWRRmazE.crianca SET nome_crianca = ?, concelho_crianca = ? WHERE id_crianca = ?";
		int i;
		
		public int atualizarCrianca(Crianca cri) {
			
			String nome_crianca = cri.getNomeCrianca();
			String concelho = cri.getConcelho();
			int id = cri.getIdCrianca();
			
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, nome_crianca);
				st.setString(2, concelho);
				st.setInt(3, id);
				i = st.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}

}
