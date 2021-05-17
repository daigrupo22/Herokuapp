package models;

import java.sql.Blob;

public class Crianca {

	private int idCrianca;
	private String nomeCrianca;
	private int idade;
	private String concelho;
	private Blob fingerprint;
	private String username;
	private String password;
	private String email;
	
	
	
	
	public Crianca() {
		
	}
	
	
	
	public Crianca(int idCrianca, String nomeCrianca, int idade, String concelho, Blob fingerprint, String password, String username, String email) {
		super();
		this.idCrianca = idCrianca;
		this.nomeCrianca = nomeCrianca;
		this.idade = idade;
		this.concelho = concelho;
		this.fingerprint = fingerprint;
		this.password = password;
		this.username = username;
		this.email = email;
		
		
	}

	public int getIdCrianca() {
		return idCrianca;
	}
	public void setIdCrianca(int idCrianca) {
		this.idCrianca = idCrianca;
	}
	public String getNomeCrianca() {
		return nomeCrianca;
	}
	public void setNomeCrianca(String nomeCrianca) {
		this.nomeCrianca = nomeCrianca;
	}
	
	public Blob getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(Blob fingerprint) {
		this.fingerprint = fingerprint;
	}
	public String getConcelho() {
		return concelho;
	}
	public void setConcelho(String concelho) {
		this.concelho = concelho;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
