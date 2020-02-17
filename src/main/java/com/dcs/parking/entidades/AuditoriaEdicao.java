/**
 * 
 */
package com.dcs.parking.entidades;

import javax.persistence.Column;

/**
 * Entidade responsável por conter dados referente a entidades que podem ter
 * edição em algum momento
 * 
 * @author Djeison 12 de fev de 2020
 */
public class AuditoriaEdicao extends Auditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1076294939662946083L;
	@Column(name = "data_edicao", nullable = true)
	private Long dataEdicao;

	public Long getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Long dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

}
