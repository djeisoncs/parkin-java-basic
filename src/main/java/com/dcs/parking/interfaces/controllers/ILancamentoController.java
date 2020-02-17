/**
 * 
 */
package com.dcs.parking.interfaces.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.dcs.parking.entidades.Lancamentos;

/**
 * Classe responsável por trabalhar os metodos de comunicação da entidade
 * lancamentos
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface ILancamentoController extends IControllerEtityFull<Lancamentos> {

	/**
	 * Método responsável por listar lançamentos por patio
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idPatio
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarLancamentosPorPatio(Long idPatio);

	/**
	 * Método responsável por listar lançamentos por patio e status
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idPatio
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarLancamentosPorPatio(Long idPatio, String status);

	/**
	 * 
	 * Método responsável por
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idVeiculo
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarLancamentosPorVeiculo(Long idVeiculo);

	/**
	 * Método responsável por listar lançamentos por veiculo
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idVeiculo
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarLancamentosPorVeiculo(Long idVeiculo, String status);

	/**
	 * Método responsável por listar lançamentos por veiculo e status
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idCliente
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarLancamentosPorCliente(Long idCliente);

	/**
	 * Método responsável por listar lançamentos por cliente
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idCliente
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarLancamentosPorCliente(Long idCliente, String status);

	/**
	 * Método responsável por listar lançamentos por cliente e status
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarLancamentosPorStatus(String status);

	/**
	 * Método responsável por retornar os lançamentos que estão em aberto
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idPatio
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> getLancamentosPendentesEmAberto(Long idPatio);

	/**
	 * Método responsável por pesquisar lançamento por placa
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param placa
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> getLancamentosPendentePorPlaca(String placa);
}
