package models;

import java.sql.Date;

public class Comentario {
	
	private String comentario;
    private int id_comentario;
    private Date data;
    private int avaliacao;
    private int id_atividade;
    private int id_crianca;
    
    
    public Comentario () {
    	
    }
    
    public Comentario(int id_comentario, String comentario, int avaliacao, int id_atividade, int id_crianca, Date data) {
    	this.id_comentario = id_comentario;
    	this.comentario = comentario;
    	this.avaliacao = avaliacao;
    	this.id_atividade = id_atividade;
    	this.id_crianca = id_crianca;
    	this.data = data;
    	
    }
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getId_comentario() {
		return id_comentario;
	}
	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public int getId_atividade() {
		return id_atividade;
	}
	public void setId_atividade(int id_atividade) {
		this.id_atividade = id_atividade;
	}
	public int getId_crianca() {
		return id_crianca;
	}
	public void setId_crianca(int id_crianca) {
		this.id_crianca = id_crianca;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
