package com.apirest.MedicamentoSolidario.dto;

import java.sql.Date;

import com.apirest.MedicamentoSolidario.Models.Usuario;


public class UsuarioDTO {
	private long id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Date nascimento;
	private String senha;
	private String sexo;
	
	public Usuario trsnformaParaObjSalvar() {
		return new Usuario(nome, cpf, email, telefone, nascimento, senha, sexo);
	}
	
	public Usuario trsnformaParaObjEditar() {
		return new Usuario(id,nome, cpf, email, telefone, nascimento, senha, sexo);
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
