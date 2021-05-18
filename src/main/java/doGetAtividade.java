import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import controller.SelectAtividade;
import models.Atividade;



public class doGetAtividade extends HttpServlet {

	protected void doGet(HttpServletRequest pedido, HttpServletResponse resultado) throws IOException, ServletException {
        
		PrintWriter out = resultado.getWriter();
        resultado.setContentType("application/json");
        resultado.setContentType("text/json; charset=utf-8");
        pedido.setCharacterEncoding("UTF-8");
	
        Atividade ativ = new Atividade();
        String id_atividade = pedido.getParameter("ativ");
        int id_atividade2 = Integer.valueOf(id_atividade);
        ativ.setIdAtividade(id_atividade2);
       

        SelectAtividade ler = new SelectAtividade();
        Atividade at = ler.retornaAtividade(ativ);
        JSONObject json = new JSONObject();
       
       
        try {
           json.put("descricao" , at.getDescricao());
           json.put("nome_atividade" , at.getNomeAtividade());
           json.put("data", at.getData());
           json.put("data_fim", at.getData_fim());
           json.put("parceiro", at.getParceiro());
           json.put("concelho", at.getConcelho());
          
        } catch (JSONException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
        out.print(json);
	}
}

