/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.util.List;

import com.dcs.parking.controllers.entidades.ClienteDto;
import com.dcs.parking.entidades.Cliente;
import com.dcs.parking.entidades.Veiculo;
import com.dcs.parking.excessao.NegocioException;

/**
 * Classe responsável por validar regras de negocio referentes a entidade
 * cliente
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IClienteService extends IServiceEntityFull<Cliente> {

	/**
	 * Método responsável por pesquisar clientes por nome
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param nome
	 * @return clientes
	 */
	public abstract List<Cliente> pesquisarClientesPorNome(String nome);

	/**
	 * Método responsável por salvar o cliente passado por parametro
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @return cliente
	 * @throws NegocioException
	 */
	public abstract ClienteDto salvar(ClienteDto cliente) throws NegocioException;

	/**
	 * Método responsável por editar o cliente passado por parametro
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @return cliente
	 * @throws NegocioException
	 */
	public abstract ClienteDto editar(ClienteDto cliente) throws NegocioException;

	/**
	 * Método responsável por pesquisar clientes por cpf
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cpf
	 * @return
	 */
	public abstract List<Cliente> pesquisarClientesPorCpf(String cpf);

	/**
	 * Método responsável por retornar o cliente por cpf
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cpf
	 * @return cliente
	 */
	public abstract Cliente getClientesPorCpf(String cpf);

	/**
	 * Método responsável por montar os dados da clienteDto com base nos parametros
	 * passados
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @param veiculos
	 * @return cliente
	 * @throws NegocioException
	 */
	public abstract ClienteDto montarDados(Cliente entidade, List<Veiculo> veiculos) throws NegocioException;
}
