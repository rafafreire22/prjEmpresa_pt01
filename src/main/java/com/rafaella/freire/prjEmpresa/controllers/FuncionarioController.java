package com.rafaella.freire.prjEmpresa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.rafaella.freire.prjEmpresa.entities.Funcionario;
import com.rafaella.freire.prjEmpresa.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;
	
	@GetMapping("/home")
    public String paginaInicial() {
        return "index"; // Nome do seu arquivo HTML (sem a extensão)
    }

	public void FuncionarioCrontroller(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long Funcodigo) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(Funcodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}

	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}

	@DeleteMapping("/{Depcodigo}")
	public void deleteFuncionario(@PathVariable Long Funcodigo) {
		funcionarioService.deleteFuncionario(Funcodigo);
	}

	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long Funcodigo, @RequestBody Funcionario funcionario) {
		return funcionarioService.updateFuncionario(Funcodigo, funcionario);
	}

}
