/**
 * 
 */
package com.dcs.parking.interfaces.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.dcs.parking.entidades.Auditoria;
import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.services.ServiceEntity;

/**
 * Classe responsável por conter metodos comuns a todas as classes da camada de
 * controle
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IControllerEtity<T extends Auditoria> {

	/**
	 * Método responsável por salvar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> salvar(T entidade);

	/**
	 * Método responsável por salvar as entidades passadas por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> salvar(List<T> entidades);

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir(Long id);

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir(T entidade);

	/**
	 * Método responsável por excluir as entidades passadas por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir(List<T> entidades);

	/**
	 * Método responsável por excluir todas as entidades cadastradas
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir();

	/**
	 * Método responsável por listar todas as entidades
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarTodos();

	/**
	 * Método responsável por realizar a consulta da entidade por id
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> consultarPorId(Long id);

	/**
	 * Método responsável por retornar a classe de serviço responsável por validar a
	 * classe de controle atual
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return service
	 */
	public abstract ServiceEntity<T> getService();
}
