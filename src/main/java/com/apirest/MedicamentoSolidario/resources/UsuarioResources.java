package com.apirest.MedicamentoSolidario.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.MedicamentoSolidario.Models.Usuario;
import com.apirest.MedicamentoSolidario.controle.UsuarioControle;
import com.apirest.MedicamentoSolidario.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/usuario")
@Api(value = "API REST Usuario")
@CrossOrigin(origins = "*")
public class UsuarioResources {

	@Autowired
	UsuarioControle usuarioControle;
	
	@ApiOperation(value="Retorna uma lista de Usuarios")
	@GetMapping("")
	public Iterable<Usuario> listarTodos() {
		return usuarioControle.listarTodosNormal();
	}
	// @ApiOperation(value="Retorna um Usuario")
	@ApiOperation(value = "Retorna um Usuario unico")
	@GetMapping("/{id}")
	public Optional<Usuario> listar(@PathVariable(value="id")long id) {		
		return usuarioControle.listar(id);
	}
	@ApiOperation(value = "Salva um Usuario")
	@PostMapping("")
	public Usuario salvar(@RequestBody @Valid Usuario usuario) {
		return usuarioControle.salvar(usuario);
	}
	
	@ApiOperation(value = "Atualiza um Usuario")
	@PutMapping("")
	public Usuario atualizar(@RequestBody @Valid Usuario usuario) {
		return usuarioControle.atualizar(usuario);
	}

	@ApiOperation(value = "Deleta um Usuario (objeto)")
	@DeleteMapping("")
	public void deletar(@RequestBody @Valid Usuario categoria) {
		usuarioControle.deletar(categoria);
	}

	@ApiOperation(value = "Deleta um Usuario por Id")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id")long id) {
		usuarioControle.deletarById(id);
	}
}
