/**
 * 
 */
package com.dcs.parking.interfaces.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dcs.parking.entidades.AuditoriaEdicao;
import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.services.ServiceEntityFull;

/**
 * Classe responsável por conter metodos comuns a todas as classes da camada de
 * controle
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IControllerEtityFull<T extends AuditoriaEdicao> extends IControllerEtity<T> {

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> editar(T entidade);

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> editar(List<T> entidades);

	/**
	 * Método responsável por retornar a classe de serviço responsável por validar a
	 * classe de controle atual
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return service
	 */
	public abstract ServiceEntityFull<T> getService();
}
