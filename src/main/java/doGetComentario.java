import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controller.SelectComentario;
import models.Comentario;


public class doGetComentario extends HttpServlet {
	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado)
			throws IOException, ServletException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");
        
		Comentario comentario = new Comentario();
		String id_comentario = pedido.getParameter("comentario");
		int id_comentario2 = Integer.valueOf(id_comentario);
		comentario.setId_comentario(id_comentario2);

		SelectComentario lerCoemntario = new SelectComentario();
		Comentario c = lerCoemntario.retornaComentario(comentario);
		JSONObject json = new JSONObject();

		try {
			json.put("comenatrio", c.getComentario());
			json.put("data", c.getData());
			json.put("avaliacao", c.getAvaliacao());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(json);

}
	}
