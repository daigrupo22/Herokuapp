import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.InsertAtividade;
import models.Atividade;

public class doPostAtividade extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
        PrintWriter out = resultado.getWriter();
        resultado.setContentType("application/json");
        //resultado.setCharacterEncoding("UTF-8");
        out.flush();
    }

    protected void doPost(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
	
    	String nome_atividade = pedido.getParameter("nome_atividade");
    	String data  = pedido.getParameter("data");
    	Date data2 = Date.valueOf(data);
    	String data_fim = pedido.getParameter("data_fim");
    	Date data_fim2 = Date.valueOf(data_fim);
    	String descricao = pedido.getParameter("descricao");
    	String parceiros = pedido.getParameter("parceiros");
    	String concelho = pedido.getParameter("concelho");
    	String id_instituicao = pedido.getParameter("id_instituicao");
    	int id_instituicao2 = Integer.valueOf(id_instituicao);
    	

    	Atividade atv = new Atividade();
    	
    	atv.setNomeAtividade(nome_atividade);
    	atv.setData(data2);
    	atv.setData_fim(data_fim2);
    	atv.setDescricao(descricao);   
    	atv.setParceiro(parceiros);
    	atv.setConcelho(concelho); 
    	atv.setIdInstituicao(id_instituicao2);
    	
    	
    	InsertAtividade is = new InsertAtividade();
    	
    	int i = is.criarAtividade(atv);
    	if (i > 0) {
            doGet(pedido, resultado);
            System.out.println("Success");
        }   		
}	
}