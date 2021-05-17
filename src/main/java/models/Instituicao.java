package models;

public class Instituicao {

	private int idInstituicao;
	private String nomeInstituicao;
	private String concelho;
	private String password;
	private String username;
	private String email;
	
	
	public Instituicao() {
		
	}
	
	
	public Instituicao(int idInstituicao, String nomeInstituicao, String concelho, String password, String username, String email) {
		super();
		this.idInstituicao = idInstituicao;
		this.nomeInstituicao = nomeInstituicao;
		this.concelho = concelho;
		this.password = password;
		this.username = username;
		this.email = email;
	
	}

	
	public String getConcelho() {
		return concelho;
	}
	public void setConcelho(String concelho) {
		this.concelho = concelho;
	}
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	public int getIdInstituicao() {
		return idInstituicao;
	}
	public void setIdInstituicao(int idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
