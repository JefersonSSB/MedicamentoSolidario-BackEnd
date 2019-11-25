package com.apirest.MedicamentoSolidario.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.MedicamentoSolidario.Models.PontoColeta;
import com.apirest.MedicamentoSolidario.errors.ResourceNotFoundException;
import com.apirest.MedicamentoSolidario.repository.PontoColetaRepository;

@Service
public class PontoColetaControle {
	@Autowired
	PontoColetaRepository repsoitory;

	public PontoColeta salvar(PontoColeta pontoColeta) {
		Optional<PontoColeta> ret = verifySave(pontoColeta.getId());
		if (ret.isPresent()) {
			throw new ResourceNotFoundException(MenssagemErro() + " existente para o  ID: " + pontoColeta.getId());

		} else
			return repsoitory.save(pontoColeta);
	}

	public Iterable<PontoColeta> listarTodosNormal() {
		return (Iterable<PontoColeta>) repsoitory.findAll();
	}
	
	public Optional<PontoColeta> listar(long id) {
		verifyIfObjectExists(id);
		Optional<PontoColeta> findById = repsoitory.findById(id);
		return findById;
	}
	
	public void deletarById(long id) {
		verifyIfObjectExists(id);
		repsoitory.deleteById(id);
	}
	
	public PontoColeta atualizar(PontoColeta pontoColeta) {
		verifyIfObjectExists(pontoColeta.getId());
		return repsoitory.save(pontoColeta);
	}
	
	
	
//---------------------------------------------------------------------//
	private void verifyIfObjectExists(long id) {
		String msg = MenssagemErro();
		Optional<PontoColeta> retorno = repsoitory.findById(id);
		retorno.orElseThrow(() -> new ResourceNotFoundException(msg + " nao encontrado para o ID: " + id));
	}

	private Optional<PontoColeta> verifySave(long id) {
		Optional<PontoColeta> retorno = repsoitory.findById(id);
		return retorno;

	}

	protected String MenssagemErro() {
		String msg = "Medicamento";
		return msg;
	}

}
