/**
 * 
 */
package com.dcs.parking.interfaces.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.dcs.parking.entidades.Cliente;

/**
 * Classe responsável por trabalhar os metodos de comunicação da entidade
 * cliente
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IClienteController extends IControllerEtityFull<Cliente> {

	/**
	 * Método responsável por pesquisar clientes por nome
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param nome
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarClientesPorNome(String nome);

	/**
	 * Método responsável por pesquisar clientes por cpf
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param cpf
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarClientesPorCpf(String cpf);

	/**
	 * Método responsável por retornar o cliente por cpf
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param cpf
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> getClientesPorCpf(String cpf);
}
