package com.apirest.MedicamentoSolidario.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.MedicamentoSolidario.Models.Medicamento;
import com.apirest.MedicamentoSolidario.errors.ResourceNotFoundException;
import com.apirest.MedicamentoSolidario.repository.MedicamentoRepository;

@Service
public class MedicamentoControle {

	@Autowired
	MedicamentoRepository repsoitory;

	public Medicamento salvar(Medicamento medicamento) {
		Optional<Medicamento> ret = verifySave(medicamento.getId());
		if (ret.isPresent()) {
			throw new ResourceNotFoundException(MenssagemErro() + " existente para o  ID: " + medicamento.getId());

		} else
			return repsoitory.save(medicamento);
	}

	public Iterable<Medicamento> listarTodosNormal() {
		return (Iterable<Medicamento>) repsoitory.findAll();
	}
	
	public Optional<Medicamento> listar(long id) {
		verifyIfObjectExists(id);
		Optional<Medicamento> findById = repsoitory.findById(id);
		return findById;
	}
	
	public void deletarById(long id) {
		verifyIfObjectExists(id);
		repsoitory.deleteById(id);
	}
	
	public Medicamento atualizar(Medicamento medicamento) {
		verifyIfObjectExists(medicamento.getId());
		return repsoitory.save(medicamento);
	}
	
	
	
//---------------------------------------------------------------------//
	private void verifyIfObjectExists(long id) {
		String msg = MenssagemErro();
		Optional<Medicamento> retorno = repsoitory.findById(id);
		retorno.orElseThrow(() -> new ResourceNotFoundException(msg + " nao encontrado para o ID: " + id));
	}

	private Optional<Medicamento> verifySave(long id) {
		Optional<Medicamento> retorno = repsoitory.findById(id);
		return retorno;

	}

	protected String MenssagemErro() {
		String msg = "Medicamento";
		return msg;
	}

}
