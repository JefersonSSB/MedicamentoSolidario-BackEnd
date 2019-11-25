package com.apirest.MedicamentoSolidario.Models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name="TB_RECEBIMENTO")
public class Recebimento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date data;
	private String obs;
	
	@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(mappedBy = "doacao_out")
	private List<Medicamento> medicamento;
	@ManyToOne
	@JoinColumn(name="voluntario_id")
	@JsonIdentityReference(alwaysAsId = true)
	private Usuario voluntario;
	@ManyToOne
	@JoinColumn(name="ponto_coleta_id")
	@JsonIdentityReference(alwaysAsId = true)
	private PontoColeta ponto;	
	@OneToOne
	@JsonIdentityReference(alwaysAsId = true)
	private Pedido pedido;
	
	
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
	public List<Medicamento> getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(List<Medicamento> medicamento) {
		this.medicamento = medicamento;
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

}
