/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.util.List;

import com.dcs.parking.entidades.Lancamentos;
import com.dcs.parking.excessao.NegocioException;

/**
 * Classe responsável por validar regras de negocio referentes aos lançamentos
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface ILancamentoService extends IServiceEntityFull<Lancamentos> {

	/**
	 * Método responsável por listar lançamentos por patio
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> listarLancamentosPorPatio(Long idPatio);

	/**
	 * Método responsável por listar lançamentos por patio e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @param status
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> listarLancamentosPorPatio(Long idPatio, String status);

	/**
	 * Método responsável por listar lançamentos por veiculo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idVeiculo
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> listarLancamentosPorVeiculo(Long idVeiculo);

	/**
	 * Método responsável por listar lançamentos por veiculo e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idVeiculo
	 * @param status
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> listarLancamentosPorVeiculo(Long idVeiculo, String status);

	/**
	 * Método responsável por listar lançamentos por cliente
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idCliente
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> listarLancamentosPorCliente(Long idCliente);

	/**
	 * Método responsável por listar lançamentos por cliente e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idCliente
	 * @param status
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> listarLancamentosPorCliente(Long idCliente, String status);

	/**
	 * Método responsável por listar lançamentos por status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param status
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> listarLancamentosPorStatus(String status);

	/**
	 * Método responsável por retornar os lançamentos que estão em aberto
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @return lancamentos
	 */
	public abstract List<Lancamentos> getLancamentosPendentesEmAberto(Long idPatio);

	/**
	 * Método responsável por pesquisar lançamento por placa
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return lancamento
	 * @throws NegocioException
	 */
	public abstract Lancamentos getLancamentosPendentePorPlaca(String placa) throws NegocioException;

	/**
	 * Método responsável por contar o numero de vagas usadas por patio
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idPatio
	 * @return numVagasUsadas
	 * @throws NegocioException
	 */
	public abstract int countVagasUsadasPorPario(Long idPatio) throws NegocioException;
}
