/**
 * 
 */
package com.dcs.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.parking.entidades.Patio;

/**
 * Classe responsável por fazer as operações de repositorio da classe cliente
 * 
 * @author Djeison 12 de fev de 2020
 */
@Repository
public interface PatioReporitory extends JpaRepository<Patio, Long> {

	/**
	 * Método responsável por pesquisar patio por descrição
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param descricao
	 * @return patios
	 */
	List<Patio> findByDescricaoIgnoreCaseContainingOrderByDescricaoAsc(String descricao);
}
