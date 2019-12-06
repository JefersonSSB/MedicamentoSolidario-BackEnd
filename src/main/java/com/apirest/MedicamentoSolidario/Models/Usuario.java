package com.apirest.MedicamentoSolidario.Models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Date nascimento;
	private String senha;
	private String sexo;
	private String tipo;
	
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(mappedBy = "doador")
	private List<Doacao> medicamentoDoado;
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(mappedBy = "voluntario")
	private List<Doacao> medicamentoIntermediado;
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(mappedBy = "voluntario")
	private List<Recebimento> medicamentoIntermediado_out;
	//@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedidos;
	
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nome, String cpf, String email, String telefone, Date nascimento,String senha, String sexo, String tipo) {
		this.nome=nome;
		this.cpf=cpf;
		this.email=email;
		this.telefone=telefone;
		this.nascimento=nascimento;		
		this.senha=senha;
		this.sexo=sexo;
		this.tipo=tipo;
	}
	


	public Usuario(long id, String nome, String cpf, String email, String telefone, Date nascimento,
			String senha, String sexo, String tipo) {
		this.id=id;
		this.nome=nome;
		this.cpf=cpf;
		this.email=email;
		this.telefone=telefone;
		this.nascimento=nascimento;		
		this.senha=senha;
		this.sexo= sexo;
		this.tipo=tipo;
	}

	public List<Doacao> getMedicamentoDoado() {
		return medicamentoDoado;
	}
	public void setMedicamentoDoado(List<Doacao> medicamentoDoado) {
		this.medicamentoDoado = medicamentoDoado;
	}
	public List<Doacao> getMedicamentoIntermediado() {
		return medicamentoIntermediado;
	}
	public void setMedicamentoIntermediado(List<Doacao> medicamentoIntermediado) {
		this.medicamentoIntermediado = medicamentoIntermediado;
	}
	public List<Recebimento> getMedicamentoIntermediado_out() {
		return medicamentoIntermediado_out;
	}
	public void setMedicamentoIntermediado_out(List<Recebimento> medicamentoIntermediado_out) {
		this.medicamentoIntermediado_out = medicamentoIntermediado_out;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
