package com.apirest.MedicamentoSolidario.dto;

import java.sql.Date;
import com.apirest.MedicamentoSolidario.Models.Usuario;


public class UsuarioRespostaDTO {
	private long id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Date nascimento;
	private String sexo;	

	 private UsuarioRespostaDTO(long id, String nome, String cpf, String email, String telefone, Date nascimento, String sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.sexo = sexo;
	}
	

	public static UsuarioRespostaDTO transformaEmDTO(Usuario usuario) {
		return new UsuarioRespostaDTO(usuario.getId(),usuario.getNome(),usuario.getCpf(),usuario.getEmail(),usuario.getTelefone(),usuario.getNascimento(),usuario.getSexo());
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Date getNascimento() {
		return nascimento;
	}


	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}	
}
