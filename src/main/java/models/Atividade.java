package models;

import java.awt.Image;
import java.sql.Date;


public class Atividade {

	private int idAtividade;
	private String nomeAtividade;
	private Date data;
	private Date data_fim;
	private String descricao;
	private boolean estado;
	private String parceiro;
	private String concelho;
	private int idInstituicao;
	
	
	public Atividade() {
		
	}
	
	
	public Atividade(int idAtividade, String nomeAtividade, Date data, String descricao, boolean estado,
			  Date data_fim, String parceiro, String concelho, int idInstituicao) {
		super();
		this.idAtividade = idAtividade;
		this.nomeAtividade = nomeAtividade;
		this.data = data;
		this.descricao = descricao;
		this.estado = estado;
		this.data_fim = data_fim;
		this.parceiro = parceiro;
		this.concelho= concelho;
		this.idInstituicao = idInstituicao;
	}


	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNomeAtividade() {
		return nomeAtividade;
	}
	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	public String getParceiro() {
		return parceiro;
	}
	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}
	public String getConcelho() {
		return concelho;
	}
	public void setConcelho(String concelho) {
		this.concelho = concelho;
	}
	public int getIdInstituicao() {
		return idInstituicao;
	}
	public void setIdInstituicao(int idInstituicao) {
		this.idInstituicao = idInstituicao;
	}
	
}