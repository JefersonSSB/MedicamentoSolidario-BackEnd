package com.apirest.MedicamentoSolidario.dto;

import java.sql.Date;

import com.apirest.MedicamentoSolidario.Models.Medicamento;

public class MedicamentoRespostaDTO {
	
	private long id;
	private String nome;
	private String principio;
	private String tipoReceita;
	private Date data;
	private Date dataVencimento;
	private String tarja;
	private String tipoArmazenamento;
	private int quantidade;
	
	
	private MedicamentoRespostaDTO(long id, String nome, String principio, String tipoReceita, Date data,
			Date dataVencimento, String tarja, String tipoArmazenamento, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.principio = principio;
		this.tipoReceita = tipoReceita;
		this.data = data;
		this.dataVencimento = dataVencimento;
		this.tarja = tarja;
		this.tipoArmazenamento = tipoArmazenamento;
		this.quantidade = quantidade;
	}
	
	public static MedicamentoRespostaDTO transformaEmDTO(Medicamento medicamento) {
		return new MedicamentoRespostaDTO(medicamento.getId(), 
				medicamento.getNome(),
				medicamento.getPrincipio(),
				medicamento.getTipoReceita(), 
				medicamento.getData(), 
				medicamento.getDataVencimento(), 
				medicamento.getTarja(),
				medicamento.getTipoArmazenamento(), 
				medicamento.getQuantidade());
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

	public String getPrincipio() {
		return principio;
	}

	public void setPrincipio(String principio) {
		this.principio = principio;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	public String getTipoArmazenamento() {
		return tipoArmazenamento;
	}

	public void setTipoArmazenamento(String tipoArmazenamento) {
		this.tipoArmazenamento = tipoArmazenamento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
