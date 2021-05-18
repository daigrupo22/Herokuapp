import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UpdateAtividade;
import models.Atividade;

public class doPutAtividade extends HttpServlet  {
	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
		String nome_atividade = pedido.getParameter("nome_atividade");
		String descricao = pedido.getParameter("descricao");
		String parceiros = pedido.getParameter("parceiro");
		String data_i = pedido.getParameter("data_i");
    	Date data_i2 = Date.valueOf(data_i);
		String data_f = pedido.getParameter("data_f");
    	Date data_f2 = Date.valueOf(data_f);
		String id = pedido.getParameter("id_atividade");	
		System.out.println(id);
		int id_atividade = Integer.valueOf(id);
		
		
		Atividade at = new Atividade();
		at.setNomeAtividade(nome_atividade);
		at.setDescricao(descricao);
		at.setParceiro(parceiros);
		at.setData(data_i2);
		at.setData_fim(data_f2);
		at.setIdAtividade(id_atividade);

		UpdateAtividade atualizar = new UpdateAtividade();
		int i = atualizar.atualizarAtividade(at);
		
		if(i>0) {
			doGet(pedido, resultado);
			System.out.println("Sucesso");
		}
	}
}
