import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;

import controller.UpdateMaterial;
import models.Material;

public class doPutMaterial extends HttpServlet{

	String imagem;
	int s = 1;
	String ext;

	// UploadMSG msg = new UploadMSG();
	public void doPut(HttpServletRequest pedido, HttpServletResponse resultado) throws ServletException, IOException {

		/*String idMaterial = pedido.getParameter("id_material");
		int idMaterial2 = Integer.parseInt(idMaterial);
*/
		String idCrianca = pedido.getParameter("id_crianca");
		int idCrianca2 = Integer.parseInt(idCrianca);

		String idAtividade = pedido.getParameter("id_atividade");
		int idAtividade2 = Integer.parseInt(idAtividade);

		resultado.setContentType("application/xhtml+xml");
		PrintWriter out = resultado.getWriter();

		try {
			MultipartRequest r = new MultipartRequest(pedido,
					"C:\\Users\\maria\\Desktop\\cidadeamigadascrianças\\Imagens", 1000000000);
			imagem = r.getFilesystemName("upload");
			int lastIndex = imagem.lastIndexOf('.');
			ext = imagem.substring(lastIndex, imagem.length());

		} catch (Exception exc) {
			System.out.println("exc");
			s = 0;
		}

		boolean booleano = ext.equals(".png") || ext.equals(".PNG") || ext.equals(".jpg") || ext.equals(".JPG")
				|| ext.equals(".jpeg") || ext.equals(".JPEG");

		System.out.println(booleano + " ext");

		if (s == 1) {
			System.out.println("deu certo?");
			if (ext.equals(".png") || ext.equals(".PNG") || ext.equals(".jpg") || ext.equals(".JPG")
					|| ext.equals(".jpeg") || ext.equals(".JPEG")) {

				Material material = new Material();

				//material.setIdMaterial(idMaterial2);
				material.setIdCrianca(idCrianca2);
				material.setIdAtividade(idAtividade2);
				material.setConteudo(imagem);
				UpdateMaterial update = new UpdateMaterial();

				int i = update.atualizarMaterial(material);

				if (i > 0) {
					System.out.println("UPDATED WITH SUCESS");
					JSONObject json = new JSONObject();
					try {
						json.put("STATUS", true);
						json.put("MSG", true);

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print(json);
					out.flush();

				} else {
					try {
						JSONObject json = new JSONObject();
						json.put("STATUS", false);
						json.put("MSG", false);
						File file = new File("C:\\Users\\maria\\Desktop\\cidadeamigadascrianças\\Imagens" + imagem);
						out.print(json);
						out.flush();
						if (file.delete()) {
							System.out.println("File deleted successfully");
						} else {
							System.out.println("Failed to delete the file");
						}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

}
