package dev.felipe.eletronicpoint.repositories;

import java.util.List;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dev.felipe.eletronicpoint.entities.Lancamento;

@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", query = "select lanc from Lancamento lanc where lanc.funcionario.id = :funcinarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	List<Lancamento> findByFuncionarioId(@Param("funcinarioId") Long funcionarioId);
	
	Page<Lancamento> findByFuncionarioId(@Param("funcinarioId") Long funcionarioId,Pageable pageable);
}
