import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.InsertMaterial;
import models.Material;

public class doPostMaterial extends HttpServlet {

	
	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado)
			throws ServletException, IOException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		// resultado.setCharacterEncoding("UTF-8");
		out.flush();
	}
	
	protected void doPost(HttpServletRequest pedido, HttpServletResponse resultado)
			throws ServletException, IOException {
		
		
		String material = pedido.getParameter("conteudo");
		String id_crianca = pedido.getParameter("id_crianca");
		int id_crianca2 = Integer.valueOf(id_crianca);
		String id_atividade = pedido.getParameter("id_atividade");
		int id_atividade2 = Integer.valueOf(id_atividade);
		
		Material mat = new Material();
		
		mat.setConteudo(material);
		mat.setIdCrianca(id_crianca2);
		mat.setIdAtividade(id_atividade2);
		
		
		InsertMaterial im = new InsertMaterial();
		
		int i = im.inserirMaterial(mat);
		if (i> 0) {
			doGet(pedido, resultado);
			System.out.println("Success");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
