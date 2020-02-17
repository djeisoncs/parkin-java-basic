/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.util.List;

import com.dcs.parking.entidades.Cliente;
import com.dcs.parking.entidades.Veiculo;
import com.dcs.parking.excessao.NegocioException;

/**
 * Classe responsável por validar regras de negocio referentes a entidade
 * veiculos
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IVeiculoService extends IServiceEntityFull<Veiculo> {

	/**
	 * Método responsável por pesquisar veiculo por placa
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return veiculos
	 */
	public abstract List<Veiculo> pesquisarVeiculosPorPlaca(String placa);

	/**
	 * Método responsável por retornar veiculo correspondente a placa passada por
	 * paramentro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return veiculos
	 * @throws NegocioException
	 */
	public abstract Veiculo getVeiculoPorPlaca(String placa) throws NegocioException;

	/**
	 * Método responsável por pesquisar veiculos por modelo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param modelo
	 * @return veiculos
	 */
	public abstract List<Veiculo> pesquisarVeiculosPorModelo(String modelo);

	/**
	 * Método responsável por pesquisar veiculos por cor
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cor
	 * @return veiculos
	 */
	public abstract List<Veiculo> pesquisarVeiculosPorCor(String cor);

	/**
	 * Método responsável por listar veiculos por cliente
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idCliente
	 * @return veiculos
	 */
	public abstract List<Veiculo> listarVeiculosPorCliente(Long idCliente);

	/**
	 * Método responsável por montar dados da entidade veiculo
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @param veiculo
	 * @return veiculo
	 * @throws NegocioException
	 */
	public abstract Veiculo montarDados(Cliente cliente, Veiculo veiculo) throws NegocioException;

	/**
	 * Método responsável por montar dados das entidades veiculos
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @param veiculos
	 * @return veiculos
	 * @throws NegocioException
	 */
	public abstract List<Veiculo> montarDados(Cliente cliente, List<Veiculo> veiculos) throws NegocioException;
}
