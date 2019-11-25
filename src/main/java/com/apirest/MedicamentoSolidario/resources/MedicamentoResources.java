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

import com.apirest.MedicamentoSolidario.Models.Medicamento;
import com.apirest.MedicamentoSolidario.controle.MedicamentoControle;
import com.apirest.MedicamentoSolidario.dto.MedicamentoDTO;
import com.apirest.MedicamentoSolidario.dto.MedicamentoRespostaDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/medicamento")
@Api(value = "API REST medicamento")
@CrossOrigin(origins = "*")
public class MedicamentoResources {
	
	@Autowired
	MedicamentoControle controle;
	
	@ApiOperation(value="Retorna uma lista de Medicamentos")
	@GetMapping("")
	public Iterable<Medicamento> listarTodos() {
		return controle.listarTodosNormal();
	}
	
	@ApiOperation(value = "Retorna um Medicamento unico")
	@GetMapping("/{id}")
	public MedicamentoRespostaDTO listar(@PathVariable(value="id")long id) {
		Optional<Medicamento> med = controle.listar(id);
		return MedicamentoRespostaDTO.transformaEmDTO(med.get());
	}
	//public Optional<Medicamento> listar(@PathVariable(value="id")long id) {	
	//	Optional<Medicamento> user = controle.listar(id);
	//	return user;
//	}
	
	@ApiOperation(value = "Salva um Medicamento")
	@PostMapping("")
	public MedicamentoRespostaDTO salvar(@RequestBody @Valid MedicamentoDTO medicamentoDTO) {
		Medicamento med = controle.salvar(medicamentoDTO.transformarParaObjSalvar());
		return MedicamentoRespostaDTO.transformaEmDTO(med);
		
	}
	//public Medicamento salvar(@RequestBody @Valid Medicamento medicamento) {
	//	Medicamento resposta = controle.salvar(medicamento);
	//	return resposta;
	//}
	
	@ApiOperation(value = "Atualiza um Medicamento")
	@PutMapping("")
	public Medicamento atualizar(@RequestBody @Valid Medicamento dto) {
		Medicamento resposta = controle.atualizar(dto);
		return resposta;
	}
	
	@ApiOperation(value = "Deleta um Medicamento por Id")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id")long id) {
		controle.deletarById(id);
	}

}
