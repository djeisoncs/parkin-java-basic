/**
 * 
 */
package com.dcs.parking.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entidade responsável por conter dados comuns a todas as entidades de banco de
 * dados
 * 
 * @author Djeison 12 de fev de 2020
 */
@MappedSuperclass
public class Auditoria extends AbstractPersistable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9021430340046395655L;
	private Long id;
	@Column(name = "data_cadastro", nullable = true)
	private Long dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Long dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
