/**
 * 
 */
package com.dcs.parking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.dcs.parking.entidades.Patio;
import com.dcs.parking.interfaces.services.IPatioService;
import com.dcs.parking.repository.PatioReporitory;

/**
 * Classe responsável por validar regras de negocio referentes a entidade patio
 * 
 * @author Djeison 12 de fev de 2020
 */
@Service
public class PatioService extends ServiceEntityFull<Patio> implements IPatioService {

	@Autowired
	private PatioReporitory reporitory;

	/**
	 * Método responsável por retornar a instancia de repositorio da entidade
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return reporitory
	 */
	@Override
	public JpaRepository<Patio, Long> getRepository() {
		return reporitory;
	}

	/**
	 * Método responsável por retornar o nome da entidade
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return
	 */
	@Override
	public String getNomeEntidade() {
		return "Patio";
	}

	/**
	 * Método responsável por pesquisar patios por descricao
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param descricao
	 * @return patios
	 */
	@Override
	public List<Patio> pesquisarPorDescricao(String descricao) {
		return reporitory.findByDescricaoIgnoreCaseContainingOrderByDescricaoAsc(descricao);
	}

}
