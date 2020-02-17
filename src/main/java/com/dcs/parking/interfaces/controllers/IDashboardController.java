/**
 * 
 */
package com.dcs.parking.interfaces.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * Classe responsável por
 * 
 * @author Djeison 16 de fev de 2020
 */
public interface IDashboardController {

	/**
	 * Método responsável por pesquisar dashboard por patio
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idPatio
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> getDashboardByPatio(Long idPatio);
}
