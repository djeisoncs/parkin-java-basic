/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.util.List;

import com.dcs.parking.entidades.Patio;

/**
 * Classe responsável por validar regras de negocio referentes a entidade patio
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IPatioService extends IServiceEntityFull<Patio> {

	/**
	 * Método responsável por pesquisar patios por descricao
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param descricao
	 * @return patios
	 */
	public abstract List<Patio> pesquisarPorDescricao(String descricao);
}
