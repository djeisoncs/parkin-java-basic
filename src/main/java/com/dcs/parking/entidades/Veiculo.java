/**
 * 
 */
package com.dcs.parking.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade de banco de manipulação de veiculos
 * 
 * @author Djeison 12 de fev de 2020
 */
@Entity
@Table(name = "tb_veiculo")
public class Veiculo extends AuditoriaEdicao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7984368051582334709L;
	@Column(length = 8)
	private String placa;
	@Column(length = 150)
	private String modelo;
	@Column(length = 150)
	private String cor;
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = true)
	private Cliente cliente;

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
