import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.InsertComentario;
import models.Comentario;


public class doPostComentario extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
        PrintWriter out = resultado.getWriter();
        resultado.setContentType("application/json");
        //resultado.setCharacterEncoding("UTF-8");
        out.flush();
    }
	 protected void doPost(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
			
	    	
	    	String comentario = pedido.getParameter("comentario");	
	    	String data  = pedido.getParameter("data");
	    	Date data2 = Date.valueOf(data);
	    	String avaliacao = pedido.getParameter("avaliacao");
	    	int avaliacao2 = Integer.valueOf(avaliacao);
	    	String id_atividade = pedido.getParameter("id_atividade");
	    	int id_atividade2 = Integer.valueOf(id_atividade);
	    	String id_crianca = pedido.getParameter("id_crianca");
	    	int id_crianca2 = Integer.valueOf(id_crianca);
	    	
	    	Comentario user = new Comentario();
	    	
	    	user.setComentario(comentario);
	    	user.setData(data2);
	    	user.setAvaliacao(avaliacao2);
	    	user.setId_atividade(id_atividade2);
	    	user.setId_crianca(id_crianca2);
	    	
	    	InsertComentario is = new InsertComentario();
	    	
	    	int i = is.InsertComentario(user);
	    	if (i > 0) {
	            doGet(pedido, resultado);
	            System.out.println("Success");
	        }
	 }
}
