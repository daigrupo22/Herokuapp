import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginInstituicao;

public class doPostLoginInstituicao extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(LoginInstituicao.checkUser(username, password)) {
         
        	out.println("Sucess");
            //RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            //rs.forward(request, response);
        }
        
        else {
        	out.println("Username or Password incorrect");
        }
        out.close();
	}

}
