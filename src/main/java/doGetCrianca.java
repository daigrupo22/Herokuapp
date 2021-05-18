import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controller.SelectCrianca;
import models.Crianca;

public class doGetCrianca extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado)
			throws IOException, ServletException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");

		Crianca crianca = new Crianca();
		String id_crianca = pedido.getParameter("crianca");
		int id_crianca2 = Integer.valueOf(id_crianca);
		crianca.setIdCrianca(id_crianca2);

		SelectCrianca lerCrianca = new SelectCrianca();
		Crianca c = lerCrianca.retornaCrianca(crianca);
		JSONObject json = new JSONObject();

		try {
			json.put("nome_crianca", c.getNomeCrianca());
			json.put("idade", c.getIdade());
			json.put("concelho", c.getConcelho());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(json);

	}
}
