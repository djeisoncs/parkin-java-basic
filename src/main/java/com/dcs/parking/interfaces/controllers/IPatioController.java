/**
 * 
 */
package com.dcs.parking.interfaces.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.dcs.parking.entidades.Patio;

/**
 * Classe responsável por trabalhar os metodos de comunicação da entidade patio
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IPatioController extends IControllerEtityFull<Patio> {

	/**
	 * Método responsável por pesquisar patios por descricao
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param descricao
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarPorDescricao(String descricao);
}
