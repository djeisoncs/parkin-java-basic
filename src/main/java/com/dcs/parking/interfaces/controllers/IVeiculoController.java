/**
 * 
 */
package com.dcs.parking.interfaces.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.dcs.parking.entidades.Veiculo;

/**
 * Classe responsável por trabalhar os metodos de comunicação da entidade
 * veiculo
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IVeiculoController extends IControllerEtityFull<Veiculo> {

	/**
	 * Método responsável por pesquisar veiculo por placa
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param placa
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarVeiculosPorPlaca(String placa);

	/**
	 * Método responsável por retornar veiculo correspondente a placa passada por
	 * paramentro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param placa
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> getVeiculoPorPlaca(String placa);

	/**
	 * Método responsável por pesquisar veiculos por modelo
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param modelo
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarVeiculosPorModelo(String modelo);

	/**
	 * Método responsável por pesquisar veiculos por cor
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param cor
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarVeiculosPorCor(String cor);

	/**
	 * Método responsável por listar veiculos por cliente
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idCliente
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarVeiculosPorCliente(Long idCliente);
}
