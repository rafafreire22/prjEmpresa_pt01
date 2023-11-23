package com.rafaella.freire.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaella.freire.prjEmpresa.entities.Funcionario;
import com.rafaella.freire.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
}
	
	public  Funcionario getFuncionarioById(Long Funcodigo) {
		return funcionarioRepository.findById(Funcodigo).orElse(null);
	}
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	public void deleteFuncionario(Long Funcodigo) {
		funcionarioRepository.deleteById(Funcodigo);
	}
	public Funcionario updateFuncionario(Long Funcodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(Funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
			return funcionarioRepository.save(funcionarioExistente);
		}else {
			return null;
		}
	}

	}



