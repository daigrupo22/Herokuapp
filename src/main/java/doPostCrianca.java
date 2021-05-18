import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.InsertCrianca;
import models.Crianca;

public class doPostCrianca extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
        PrintWriter out = resultado.getWriter();
        resultado.setContentType("application/json");
        resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");
        out.flush();
    }

    protected void doPost(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {
	
    	
    	String nome_crianca = pedido.getParameter("nome_crianca");	
    	String idade = pedido.getParameter("idade");
    	int idade2 = Integer.valueOf(idade);
    	String concelho = pedido.getParameter("concelho");
    	String username = pedido.getParameter("username");
    	String password = pedido.getParameter("password");
    	String email = pedido.getParameter("email");
 
    	
    	Crianca user = new Crianca();
    	
    	user.setNomeCrianca(nome_crianca);
    	user.setIdade(idade2);
    	user.setConcelho(concelho);
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setEmail(email);
    	
    	InsertCrianca is = new InsertCrianca();
    	
    	int i = is.criarCrianca(user);
    	if (i > 0) {
            doGet(pedido, resultado);
            System.out.println("Success");
        }
    		
}
	
	
	
	
	
}
