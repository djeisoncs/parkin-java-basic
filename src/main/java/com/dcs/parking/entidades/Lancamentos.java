/**
 * 
 */
package com.dcs.parking.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade de banco de manipulação de lançamentos do estacionamento
 * 
 * @author Djeison 12 de fev de 2020
 */
@Entity
@Table(name = "tb_lancamento")
public class Lancamentos extends AuditoriaEdicao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6991975380725432712L;
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	@ManyToOne
	@JoinColumn(name = "patio_id", nullable = true)
	private Patio patio;
	@ManyToOne
	@JoinColumn(name = "veiculo_id", nullable = true)
	private Veiculo veiculo;
	@Column(length = 1)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
