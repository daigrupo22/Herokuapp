import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controller.SelectSugestao;
import models.Sugestao;

public class doGetSugestao extends HttpServlet {

	protected void doGet (HttpServletRequest pedido, HttpServletResponse resultado)
			throws IOException, ServletException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");
	
	Sugestao sug = new Sugestao();
	String idSugestao1 = pedido.getParameter("sug");
	int idSugestao2 = Integer.valueOf(idSugestao1);
	sug.setIdSugestao(idSugestao2);
	
	SelectSugestao ler = new SelectSugestao();
	Sugestao s = ler.retornaSugestao(sug);
	JSONObject json = new JSONObject();
	
	try {
		json.put("sugestao", s.getSugestao());
		json.put("data", s.getData());
	}
	
	catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    out.print(json);
}
}