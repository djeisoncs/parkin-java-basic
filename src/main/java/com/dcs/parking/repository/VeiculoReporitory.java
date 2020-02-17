/**
 * 
 */
package com.dcs.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.parking.entidades.Veiculo;

/**
 * Classe responsável por fazer as operações de repositorio da classe cliente
 * 
 * @author Djeison 12 de fev de 2020
 */
@Repository
public interface VeiculoReporitory extends JpaRepository<Veiculo, Long> {

	/**
	 * Método responsável por pesquisar veiculos por cor
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cor
	 * @return veiculos
	 */
	List<Veiculo> findByCorIgnoreCaseContainingOrderByCorAsc(String cor);

	/**
	 * Método responsável por listar veiculos por cliente
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idCliente
	 * @return veiculos
	 */
	List<Veiculo> findByClienteIdOrderByPlacaAsc(Long idCliente);

	/**
	 * Método responsável por pesquisar veiculos por modelo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param modelo
	 * @return veiculos
	 */
	List<Veiculo> findByModeloIgnoreCaseContainingOrderByModeloAsc(String modelo);

	/**
	 * Método responsável por pesquisar veiculos por placa
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return veiculos
	 */
	List<Veiculo> findByPlacaIgnoreCaseContainingOrderByModeloAsc(String placa);

	/**
	 * Método responsável por pesquisar veiculos por placa
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return veiculo
	 */
	Veiculo findByPlacaIgnoreCaseLike(String placa);

}
