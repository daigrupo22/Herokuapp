import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controller.SelectInstituicao;
import models.Instituicao;

public class doGetInstituicao extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado)
			throws IOException, ServletException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");

		Instituicao instituicao = new Instituicao();
		String id_instituicao = pedido.getParameter("instituicao");
		int id_instituicao2 = Integer.valueOf(id_instituicao);
		instituicao.setIdInstituicao(id_instituicao2);

		SelectInstituicao lerInstituicao = new SelectInstituicao();
		Instituicao i = lerInstituicao.retornaInstituicao(instituicao);
		JSONObject json = new JSONObject();

		try {
			json.put("nome_instituicao", i.getNomeInstituicao());
			json.put("concelho", i.getConcelho());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(json);

	}
}
