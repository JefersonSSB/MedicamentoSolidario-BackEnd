package com.apirest.MedicamentoSolidario.Models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name="TB_DOACAO")
//quando o medicamento é doado para o posto de coleta
public class Doacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date data;
	private String obs;
	
	
	@ManyToOne
	@JsonIdentityReference(alwaysAsId = true)
	private Usuario doador;
	
	@ManyToOne
	@JsonIdentityReference(alwaysAsId = true)
	private Usuario voluntario;
	
	@ManyToOne
	@JsonIdentityReference(alwaysAsId = true)
	private PontoColeta ponto;
	
	@OneToMany(mappedBy = "doacao_in")
	@JsonIdentityReference(alwaysAsId = true)
	private List<Medicamento> medicamento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Usuario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Usuario voluntario) {
		this.voluntario = voluntario;
	}

	public PontoColeta getPonto() {
		return ponto;
	}

	public void setPonto(PontoColeta ponto) {
		this.ponto = ponto;
	}

	public List<Medicamento> getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(List<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}
	
	

}
