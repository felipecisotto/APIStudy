package dev.felipe.eletronicpoint.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.felipe.eletronicpoint.entities.Funcionario;
import dev.felipe.eletronicpoint.repositories.FuncionarioRepository;
import dev.felipe.eletronicpoint.services.FuncionarioService;
@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class); 
	
	@Override
	public Funcionario persistir(Funcionario funcionario) {
		log.info("Persistindo Funcionario {}",funcionario);
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando funcionario por cpf {}",cpf);
		return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando funcionario por email {}",email);
		return Optional.ofNullable(funcionarioRepository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		log.info("Buscando funcionario por id {}",id);
		return funcionarioRepository.findById(id);
	}

}
