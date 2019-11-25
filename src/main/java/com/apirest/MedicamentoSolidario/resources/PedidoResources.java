package com.apirest.MedicamentoSolidario.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.MedicamentoSolidario.Models.Pedido;
import com.apirest.MedicamentoSolidario.controle.PedidoControle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/pedido")
@Api(value = "API REST pedido")
@CrossOrigin(origins = "*")
public class PedidoResources {
	@Autowired
	PedidoControle controle;
	
	@ApiOperation(value="Retorna uma lista de Pedidos")
	@GetMapping("")
	public Iterable<Pedido> listarTodos() {
		return controle.listarTodosNormal();
	}
	
	@ApiOperation(value = "Retorna um Pedido unico")
	@GetMapping("/{id}")
	public Optional<Pedido> listar(@PathVariable(value="id")long id) {
		Optional<Pedido> med = controle.listar(id);
		return med;
	}
	//public Optional<Medicamento> listar(@PathVariable(value="id")long id) {	
	//	Optional<Medicamento> user = controle.listar(id);
	//	return user;
//	}
	
	@ApiOperation(value = "Salva um Pedido")
	@PostMapping("")
	public Pedido salvar(@RequestBody @Valid Pedido pedido) {
		Pedido med = controle.salvar(pedido);
		return med;
		
	}
	//public Medicamento salvar(@RequestBody @Valid Medicamento medicamento) {
	//	Medicamento resposta = controle.salvar(medicamento);
	//	return resposta;
	//}
	
	@ApiOperation(value = "Atualiza um Pedido")
	@PutMapping("")
	public Pedido atualizar(@RequestBody @Valid Pedido dto) {
		Pedido resposta = controle.atualizar(dto);
		return resposta;
	}
	
	@ApiOperation(value = "Deleta um Pedido por Id")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id")long id) {
		controle.deletarById(id);
	}

}
