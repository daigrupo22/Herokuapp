import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.InsertInstituicao;
import models.Instituicao;

public class doPostInstituicao extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
        PrintWriter out = resultado.getWriter();
        resultado.setContentType("application/json");
        //resultado.setCharacterEncoding("UTF-8");
        out.flush();
    }

    protected void doPost(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
	
    	String nome_instituicao = pedido.getParameter("nome_instituicao");
    	String concelho = pedido.getParameter("concelho");
    	String username = pedido.getParameter("username");
    	String password = pedido.getParameter("password");
    	String email = pedido.getParameter("email");
    	
 
    	Instituicao inst = new Instituicao();
    	
    	inst.setNomeInstituicao(nome_instituicao);
    	inst.setConcelho(concelho);  	
    	inst.setUsername(username);
    	inst.setPassword(password);
    	inst.setEmail(email);
    	
    	InsertInstituicao is = new InsertInstituicao();
    	
    	int i = is.criarInstituicao(inst);
    	if (i > 0) {
            doGet(pedido, resultado);
            System.out.println("Success");
        }   		
}
	
	
	
}
