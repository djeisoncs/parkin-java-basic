/**
 * 
 */
package com.dcs.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.parking.entidades.Cliente;

/**
 * Classe responsável por fazer as operações de repositorio da classe cliente
 * 
 * @author Djeison 12 de fev de 2020
 */
@Repository
public interface ClienteReporitory extends JpaRepository<Cliente, Long> {

	/**
	 * Método responsável por pesquisar cliente por cpf
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cpf
	 * @return
	 */
	Cliente findByCpfIgnoreCaseLike(String cpf);

	/**
	 * Método responsável por pesquisar clientes por cpf
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cpf
	 * @return
	 */
	List<Cliente> findByCpfIgnoreCaseContainingOrderByNomeAsc(String cpf);

	/**
	 * Método responsável por pesquisar clientes por nome
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param nome
	 * @return clientes
	 */
	List<Cliente> findByNomeIgnoreCaseContainingOrderByNomeAsc(String nome);

}
