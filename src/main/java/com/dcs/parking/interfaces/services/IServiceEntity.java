/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.parking.entidades.Auditoria;
import com.dcs.parking.excessao.NegocioException;

/**
 * Classe responsável por conter metodos comuns as classes filhas de negócio
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IServiceEntity<T extends Auditoria> extends IService<T> {

	/**
	 * Método responsável por retornar a instancia de repositorio da classe
	 * manipulada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return repository
	 */
	public abstract JpaRepository<T, Long> getRepository();

	/**
	 * Método responsável por salvar e validar as regras de negocio da entidade
	 * passada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T salvar(T entidade) throws NegocioException;

	/**
	 * Método responsável por salvar e validar as regras de negocio da entidade
	 * passada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> salvar(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param id
	 * @throws NegocioException
	 */
	public abstract void excluir(Long id) throws NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @throws NegocioException
	 */
	public abstract void excluir(T entidade) throws NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @throws NegocioException
	 */
	public abstract void excluir(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @throws NegocioException
	 */
	public abstract void excluir() throws NegocioException;

	/**
	 * Método responsável por listar todos os registros da entidade de manipulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return entidades
	 */
	public abstract List<T> listarTodos();

	/**
	 * Método responsável por consultar a entidade por id
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param id
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract Optional<T> consultarPorId(Long id) throws NegocioException;

	/**
	 * Método responsável por validar se os dados obrigatorios para salvar a
	 * entidade estão preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosPreenchidos(T entidade) throws NegocioException;

	/**
	 * Método responsável por validar se os dados obrigatorios para salvar a
	 * entidade estão preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosPreenchidos(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por montar os dados para salvar a entidade passada por
	 * parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T montarDados(T entidade) throws NegocioException;

	/**
	 * Método responsável por montar os dados para salvar a entidades passada por
	 * parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> montarDados(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por validar se a entidade que está prestes a ser salva já
	 * não está cadastrada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteCadastro(T entidade) throws NegocioException;

	/**
	 * Método responsável por validar se a entidade que está prestes a ser salva já
	 * não está cadastrada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteCadastro(List<T> entidades) throws NegocioException;
}
