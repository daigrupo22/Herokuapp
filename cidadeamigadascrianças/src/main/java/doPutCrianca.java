import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UpdateCrianca ;
import models.Crianca ;

public class doPutCrianca extends HttpServlet {
	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		//resultado.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
		String nome_crianca = pedido.getParameter("nome_crianca");
		String concelho = pedido.getParameter("concelho");
		String id = pedido.getParameter("id_crianca");
		System.out.println(id);
		int id_crianca = Integer.valueOf(id);
		
		Crianca  cri = new Crianca();
		cri.setNomeCrianca(nome_crianca);
		cri.setConcelho(concelho);
		cri.setIdCrianca(id_crianca);
		
		UpdateCrianca  atualizar = new UpdateCrianca ();
		int i = atualizar.atualizarCrianca(cri);
		
		if(i>0) {
			doGet(pedido, resultado);
			System.out.println("Sucesso");
		}
	}
}
