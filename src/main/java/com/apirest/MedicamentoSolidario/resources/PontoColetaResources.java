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

import com.apirest.MedicamentoSolidario.Models.PontoColeta;
import com.apirest.MedicamentoSolidario.controle.PontoColetaControle;
import com.apirest.MedicamentoSolidario.dto.PontoColetaDTO;
import com.apirest.MedicamentoSolidario.dto.PontoColetaRespostaDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/pontoColeta")
@Api(value = "API REST PontoCOleta")
@CrossOrigin(origins = "*")
public class PontoColetaResources {
	@Autowired
	PontoColetaControle controle;
	
	@ApiOperation(value="Retorna uma lista de Pontos de Coleta")
	@GetMapping("")
	public Iterable<PontoColeta> listarTodos() {
		return controle.listarTodosNormal();
	}
	
	@ApiOperation(value = "Retorna um Ponto de Coleta unico")
	@GetMapping("/{id}")
	public PontoColetaRespostaDTO listar(@PathVariable(value="id")long id) {
		Optional<PontoColeta> med = controle.listar(id);
		return PontoColetaRespostaDTO.transformaEmDTO(med.get());
	}
	//public Optional<Medicamento> listar(@PathVariable(value="id")long id) {	
	//	Optional<Medicamento> user = controle.listar(id);
	//	return user;
//	}
	
	@ApiOperation(value = "Salva um Ponto de Coleta")
	@PostMapping("")
	public PontoColetaRespostaDTO salvar(@RequestBody @Valid PontoColetaDTO pontoCOletaDTO) {
		PontoColeta med = controle.salvar(pontoCOletaDTO.transformarParaObjSalvar());
		return PontoColetaRespostaDTO.transformaEmDTO(med);
		
	}
	//public Medicamento salvar(@RequestBody @Valid Medicamento medicamento) {
	//	Medicamento resposta = controle.salvar(medicamento);
	//	return resposta;
	//}
	
	@ApiOperation(value = "Atualiza um Ponto de Coleta")
	@PutMapping("")
	public PontoColeta atualizar(@RequestBody @Valid PontoColeta pontoColetaDTO) {
		PontoColeta resposta = controle.atualizar(pontoColetaDTO);
		return resposta;
	}
	
	@ApiOperation(value = "Deleta um Ponto de Coleta por Id")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id")long id) {
		controle.deletarById(id);
	}

}
