package dev.felipe.eletronicpoint.services;

import java.util.Optional;

import dev.felipe.eletronicpoint.entities.Empresa;

public interface EmpresaService {

	/**
	 * Retorna uma empresa dado um cnpj 
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	
	/**
	 * Cadastra uma nova empresa na base de dados
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);
	
}
