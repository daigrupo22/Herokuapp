import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import models.Sugestao;

public class doGetSugestaoTudo extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	
	public doGetSugestaoTudo() {
		
	}

	protected void doGet (HttpServletRequest pedido, HttpServletResponse resultado)
			throws IOException, ServletException {
		PrintWriter out = resultado.getWriter();
		Sugestao sug = new Sugestao();
		
		resultado.setContentType("text/json; charset=utf-8");
		pedido.setCharacterEncoding("UTF-8");
		
		try {
			String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host Ã© o mysql
			String URL = "jdbc:mysql://remotemysql.com:3306";
			String USER = "d4YWRRmazE";
			String PASSWORD = "0HMMHO3mbT";
			String sql = "SELECT *  FROM d4YWRRmazE.sugestao;";
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			
			JSONArray jsonarray = new JSONArray();
			
			JSONObject jsonobject = new JSONObject();
			int i = 0;
			
			while(res.next()) {
				
			JSONObject json = new JSONObject();
				
				String sugestao = res.getString("sugestao");
				Date dataSugestao = res.getDate("data");
				
			    sug.setSugestao(sugestao);
			    sug.setData(dataSugestao);
			    
				json.put("Sugestao", sug.getSugestao());
				json.put("Data", sug.getData());
				
				jsonarray.put(json); 
				jsonobject.put("Sugestões", jsonarray);
				
				i++;
			}
			out = resultado.getWriter();
			                    
			out.print(jsonobject);
			                     //  Close completed
			res.close();   
			st.close();   
			con.close();
		} catch (ClassNotFoundException | SQLException | JSONException e) {
			// TODO Auto-generated catch block
			out.print("get data error!"); 
			e.printStackTrace();
		}
	}
}
