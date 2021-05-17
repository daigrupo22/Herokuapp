package models;


public class Material {

	private int idMaterial;
	private String conteudo;
	private int idCrianca;
	private int idAtividade;
	
	
	public Material() {

	}
	
	
	
	public Material(int idMaterial, String conteudo, int idCrianca, int idAtividade) {
		super();
		this.idMaterial = idMaterial;
		this.conteudo = conteudo;
		this.idCrianca = idCrianca;
		this.idAtividade = idAtividade;
	}



	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public int getIdCrianca() {
		return idCrianca;
	}
	public void setIdCrianca(int idUser) {
		this.idCrianca = idUser;
	}
	public int getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}
	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
}
