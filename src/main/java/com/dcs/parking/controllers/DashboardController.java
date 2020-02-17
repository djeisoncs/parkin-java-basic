/**
 * 
 */
package com.dcs.parking.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.controllers.IDashboardController;
import com.dcs.parking.services.DashboardService;

/**
 * Classe responsável por
 * 
 * @author Djeison 16 de fev de 2020
 */
@Controller
@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController implements IDashboardController {

	@Autowired
	private DashboardService service;

	/**
	 * Método responsável por pesquisar dashboard por patio
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idPatio
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/{idPatio}")
	public ResponseEntity<Map<String, Object>> getDashboardByPatio(@PathVariable Long idPatio) {
		try {
			return service.getRespostaControle(service.getDashboardByPatio(idPatio));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
