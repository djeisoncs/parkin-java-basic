/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.excessao.NegocioException;

/**
 * Classe responsável por conter metodos comuns as classes filhas de negócio
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IService<T extends Serializable> {

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param id
	 * @param mensagem
	 * @return responseEntity
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(Long id, String mensagem)
			throws NegocioException;

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param status
	 * @param codigo
	 * @param mensagem
	 * @return responseEntity
	 */
	public abstract ResponseEntity<RespostaControle> getRespostaControle(boolean status, String codigo,
			String mensagem);

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param status
	 * @param codigo
	 * @param mensagem
	 * @return
	 * @throws NegocioException
	 */
	public ResponseEntity<Map<String, Object>> getRespostaControleInfo(boolean status, String codigo, String mensagem)
			throws NegocioException;

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return responseEntity
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(T entidade) throws NegocioException;
	
	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return responseEntity
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(Optional<T> entidade) throws NegocioException;

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return responseEntity
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param codigo
	 * @param mensagem
	 * @return responseEntity
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(String codigo, String mensagem);

	/**
	 * Método responsável por retornar o nome da entidade de manipulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return nome
	 */
	public abstract String getNomeEntidade();
}
