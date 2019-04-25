package dev.felipe.eletronicpoint.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.felipe.eletronicpoint.entities.Lancamento;
import dev.felipe.eletronicpoint.repositories.LancamentoRepository;
import dev.felipe.eletronicpoint.services.LancamentoService;
@Service
public class LancamentoServiceImpl implements LancamentoService{
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando Lancamento para o funcionario id {}",funcionarioId);
		return lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando Lancamento pelo id {}",id);
		return lancamentoRepository.findById(id);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("inserindo o  Lancamento {}",lancamento);
		return lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("removendo Lancamento pelo id {}",id);
		lancamentoRepository.deleteById(id);
		
	}

}
