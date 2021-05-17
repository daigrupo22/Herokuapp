import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import models.Atividade;
import models.Comentario;

public class doGetComentarioTudo extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	
	public doGetComentarioTudo() {
		
	}

	protected void doGet (HttpServletRequest pedido, HttpServletResponse resultado)
			throws IOException, ServletException {
		PrintWriter out = resultado.getWriter();
		Comentario co = new Comentario();
		Atividade at = new Atividade();
		
		resultado.setContentType("text/json; charset=utf-8");
		pedido.setCharacterEncoding("UTF-8");
		
		try {
			String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host Ã© o mysql
			String URL = "jdbc:mysql://remotemysql.com:3306";
			String USER = "d4YWRRmazE";
			String PASSWORD = "0HMMHO3mbT";
			String sql = "SELECT C.comentario, A.nome_atividade, C.data_comentario, C.avaliacao FROM d4YWRRmazE.comentario C, d4YWRRmazE.atividade A where  A.id_atividade = C.id_atividade;";
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			JSONArray jsonarray = new JSONArray();
			
			JSONObject jsonobject = new JSONObject();
			int i = 0;
			
			while(rs.next()) {
				
			JSONObject json = new JSONObject();
				
				String comentario = rs.getString("comentario");
				String nome = rs.getString("nome_atividade");
				Date data = rs.getDate("data_comentario");
				int avaliacao = rs.getInt("avaliacao");
				
				
			    co.setComentario(comentario);
			    at.setNomeAtividade(nome);
			    co.setData(data);
			    co.setAvaliacao(avaliacao);
			    
				json.put("comentario", co.getComentario());
				json.put("Nome da atividade", at.getNomeAtividade());
				json.put("Data", co.getData());
				json.put("Avaliacao", co.getAvaliacao());
				
				jsonarray.put(json); 
				jsonobject.put("Comentários", jsonarray);
				
				i++;
			}
			out = resultado.getWriter();
			                    
			out.print(jsonobject);
			                     //  Close completed
			rs.close();   
			st.close();   
			con.close();
		} catch (ClassNotFoundException | SQLException | JSONException e) {
			// TODO Auto-generated catch block
			out.print("get data error!"); 
			e.printStackTrace();
		}
	}
}



	
	
	
	

