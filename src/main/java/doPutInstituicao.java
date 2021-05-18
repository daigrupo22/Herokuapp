import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UpdateInstituicao;
import models.Instituicao;

public class doPutInstituicao extends HttpServlet {
	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
		PrintWriter out = resultado.getWriter();
		resultado.setContentType("application/json");
		resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");
        out.flush();
	}
	
	protected void doPut(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
		String nome_instituicao = pedido.getParameter("nome_instituicao");
		String id = pedido.getParameter("id_instituicao");
		int id_instituicao = Integer.valueOf(id);
		
		Instituicao inst = new Instituicao();
		inst.setNomeInstituicao(nome_instituicao);
		inst.setIdInstituicao(id_instituicao);
		
		UpdateInstituicao atualizar = new UpdateInstituicao();
		int i = atualizar.atualizarInstituicao(inst);
		
		if(i>0) {
			doGet(pedido, resultado);
			System.out.println("Sucesso");
		}
	}
}
