package models;

import java.sql.Date;

public class Sugestao {
	
	private int idSugestao;
	private Date data;
	private String sugestao;
	private int idCrianca;	
	
	
	
	public Sugestao() {
		
	}
		
	
	public Sugestao(int idSugestao, Date data, String sugestao, int idCrianca) {
		super();
		this.idSugestao = idSugestao;
		this.data = data;
		this.sugestao = sugestao;
		this.idCrianca = idCrianca;
	}



	public int getIdSugestao() {
		return idSugestao;
	}
	public void setIdSugestao(int idSugestao) {
		this.idSugestao = idSugestao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIdCrianca() {
		return idCrianca;
	}
	public void setIdCrianca(int idCrianca) {
		this.idCrianca = idCrianca;
	}
	public String getSugestao() {
		return sugestao;
	}
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

}
