package com.apirest.MedicamentoSolidario.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.MedicamentoSolidario.Models.Pedido;
import com.apirest.MedicamentoSolidario.errors.ResourceNotFoundException;
import com.apirest.MedicamentoSolidario.repository.PedidoRepository;

@Service
public class PedidoControle {
	@Autowired
	PedidoRepository repsoitory;

	public Pedido salvar(Pedido pedido) {
		Optional<Pedido> ret = verifySave(pedido.getId());
		if (ret.isPresent()) {
			throw new ResourceNotFoundException(MenssagemErro() + " existente para o  ID: " + pedido.getId());

		} else
			return repsoitory.save(pedido);
	}

	public Iterable<Pedido> listarTodosNormal() {
		return (Iterable<Pedido>) repsoitory.findAll();
	}
	
	public Optional<Pedido> listar(long id) {
		verifyIfObjectExists(id);
		Optional<Pedido> findById = repsoitory.findById(id);
		return findById;
	}
	
	public void deletarById(long id) {
		verifyIfObjectExists(id);
		repsoitory.deleteById(id);
	}
	
	public Pedido atualizar(Pedido pedido) {
		verifyIfObjectExists(pedido.getId());
		return repsoitory.save(pedido);
	}
	
	
	
//---------------------------------------------------------------------//
	private void verifyIfObjectExists(long id) {
		String msg = MenssagemErro();
		Optional<Pedido> retorno = repsoitory.findById(id);
		retorno.orElseThrow(() -> new ResourceNotFoundException(msg + " nao encontrado para o ID: " + id));
	}

	private Optional<Pedido> verifySave(long id) {
		Optional<Pedido> retorno = repsoitory.findById(id);
		return retorno;

	}

	protected String MenssagemErro() {
		String msg = "Medicamento";
		return msg;
	}


}
