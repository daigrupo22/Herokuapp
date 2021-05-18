	import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.InsertSugestao;
import models.Sugestao;

public class doPostSugestao extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado)
			throws ServletException, IOException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");
		out.flush();
	}

	protected void doPost(HttpServletRequest pedido, HttpServletResponse resultado)
			throws ServletException, IOException {

		String data = pedido.getParameter("data");
		Date data2 = Date.valueOf(data);
		String sugestao = pedido.getParameter("sugestao");
		String id_crianca = pedido.getParameter("id_crianca");
		int id_crianca2 = Integer.valueOf(id_crianca);
		
		Sugestao sug = new Sugestao();

		sug.setData(data2);
		sug.setSugestao(sugestao);
		sug.setIdCrianca(id_crianca2);

		InsertSugestao is = new InsertSugestao();

		int i = is.criarSugestao(sug);
		if (i > 0) {
			doGet(pedido, resultado);
			System.out.println("Success");
		}
	}

}
