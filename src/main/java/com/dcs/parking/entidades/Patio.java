/**
 * 
 */
package com.dcs.parking.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade de banco de manipulação de patios
 * 
 * @author Djeison 12 de fev de 2020
 */
@Entity
@Table(name = "tb_patio")
public class Patio extends AuditoriaEdicao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1867208120977679530L;
	@Column(length = 250)
	private String descricao;
	@Column(name = "numero_vagas")
	private int numVagas;
	@Column(name = "valor_hora")
	private BigDecimal valorHora;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumVagas() {
		return numVagas;
	}

	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

}
