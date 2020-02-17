/**
 * 
 */
package com.dcs.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.parking.entidades.Lancamentos;

/**
 * Classe responsável por fazer as operações de repositorio da classe cliente
 * 
 * @author Djeison 12 de fev de 2020
 */
@Repository
public interface LancamentoReporitory extends JpaRepository<Lancamentos, Long> {

	/**
	 * Método responsável por listar lançamentos por cliente
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idCliente
	 * @return lancamentos
	 */
	List<Lancamentos> findByVeiculoClienteIdOrderByDataCadastroAsc(Long idCliente);

	/**
	 * Método responsável por listar lançamentos por cliente e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idCliente
	 * @param status
	 * @return lancamentos
	 */
	List<Lancamentos> findByVeiculoClienteIdAndStatusLikeOrderByDataCadastroAsc(Long idCliente, String status);

	/**
	 * Método responsável por listar lançamentos por patio
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @return lancamentos
	 */
	List<Lancamentos> findByPatioIdOrderByDataCadastroAsc(Long idPatio);

	/**
	 * Método responsável por listar lançamentos por patio e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @param status
	 * @return lancamentos
	 */
	List<Lancamentos> findByPatioIdAndStatusLikeOrderByDataCadastroAsc(Long idPatio, String status);

	/**
	 * Método responsável por listar lançamentos por veiculo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idVeiculo
	 * @return lancamentos
	 */
	List<Lancamentos> findByVeiculoIdOrderByDataCadastroAsc(Long idVeiculo);

	/**
	 * Método responsável por listar lançamentos por veiculo e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idVeiculo
	 * @param status
	 * @return lancamentos
	 */
	List<Lancamentos> findByVeiculoIdAndStatusLikeOrderByDataCadastroAsc(Long idVeiculo, String status);

	/**
	 * Método responsável por listar os lançamentos por statitus
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param status
	 * @return lancamentos
	 */
	List<Lancamentos> findByStatusLikeOrderByDataCadastroAsc(String status);

	/**
	 * Método responsável por contar o numero de vagas usadas por patio de acordo
	 * com o status
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idPatio
	 * @param status
	 * @return numVagas
	 */
	int countByPatioIdAndStatus(Long idPatio, String status);

}
