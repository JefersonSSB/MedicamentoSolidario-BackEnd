package com.apirest.MedicamentoSolidario.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.MedicamentoSolidario.Models.Usuario;
import com.apirest.MedicamentoSolidario.errors.ResourceNotFoundException;
import com.apirest.MedicamentoSolidario.repository.UsuarioRepository;

@Service
public class UsuarioControle {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> ret = verifySave(usuario.getId());
		if (ret.isPresent()) {
			throw new ResourceNotFoundException(MenssagemErro() + " existente para o  ID: " + usuario.getId());

		} else
			return (Usuario) usuarioRepository.save(usuario);
	}
	public Iterable<Usuario> listarTodosNormal() {
		return (Iterable<Usuario>) usuarioRepository.findAll();
	}
	public Optional<Usuario> listar(long id) {
		verifyIfObjectExists(id);
		Optional<Usuario> findById = usuarioRepository.findById(id);
		return findById;
	}
	public void deletarById(long id) {
		verifyIfObjectExists(id);
		usuarioRepository.deleteById(id);
	}
	public void deletar(Usuario usuario) {
		 verifyIfObjectExists(usuario.getId());
		usuarioRepository.delete(usuario);
	}

	public Usuario atualizar(Usuario usuario) {
		verifyIfObjectExists(usuario.getId());
		return (Usuario) usuarioRepository.save(usuario);
	}

	private void verifyIfObjectExists(long id) {
		String msg = MenssagemErro();
		Optional<Usuario> retorno = usuarioRepository.findById(id);
		retorno.orElseThrow(() -> new ResourceNotFoundException(msg + " nao encontrado para o ID: " + id));
	}

	private Optional<Usuario> verifySave(long id) {
		Optional<Usuario> retorno = usuarioRepository.findById(id);
		return retorno;

	}

	protected String MenssagemErro() {
		String msg = "Objeto";
		return msg;
	}

}
