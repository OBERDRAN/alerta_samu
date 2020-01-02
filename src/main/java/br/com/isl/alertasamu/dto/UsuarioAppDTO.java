package br.com.isl.alertasamu.dto;

import java.io.Serializable;

import br.com.isl.alertasamu.model.UsuarioApp;

public class UsuarioAppDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String sexo;
	private String telefone;
	private String senha;
	
	public UsuarioAppDTO(){
		
	}
	
public UsuarioAppDTO(UsuarioApp obj) {
		
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		cpf = obj.getCpf();
		sexo = obj.getSexo();
		telefone = obj.getTelefone();
		senha = obj.getSenha();
		
	}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}




}
