/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.util.List;

import com.dcs.parking.entidades.AuditoriaEdicao;
import com.dcs.parking.excessao.NegocioException;

/**
 * Classe responsável por conter metodos comuns as classes filhas de negócio
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IServiceEntityFull<T extends AuditoriaEdicao> extends IServiceEntity<T> {

	/**
	 * Método responsável por editar e entidade passada por parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T editar(T entidade) throws NegocioException;

	/**
	 * Método responsável por editar e entidade passada por parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @param token
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> editar(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por se os dados obrigatorios para editar a entidade estão
	 * preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosEdicaoPreenchidos(T entidade) throws NegocioException;

	/**
	 * Método responsável por se os dados obrigatorios para editar a entidade estão
	 * preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosEdicaoPreenchidos(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por verificar se a edição da entidade irá gerar uma
	 * duplicidade no banco
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteDuplicidadeCadastro(T entidade) throws NegocioException;

	/**
	 * Método responsável por verificar se a edição da entidade irá gerar uma
	 * duplicidade no banco
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteDuplicidadeCadastro(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por validar se a entidade não está sendo editada para uma
	 * outra ja existente
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidadeBanco
	 * @param entidade
	 * @param nomeEntidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteDuplicidadeCadastro(T entidadeBanco, T entidade, String nomeEntidade)
			throws NegocioException;

	/**
	 * Método responsável por montar os dados da entidade passada por parametro que
	 * será editada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T montarDadosEdicao(T entidade) throws NegocioException;

	/**
	 * 
	 * Método responsável por montar os dados da entidade passada por parametro que
	 * será editada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> montarDadosEdicao(List<T> entidades) throws NegocioException;
}
