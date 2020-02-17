/**
 * 
 */
package com.dcs.parking.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade de banco de manipulação de clientes
 * 
 * @author Djeison 12 de fev de 2020
 */
@Entity
@Table(name = "tb_cliente")
public class Cliente extends AuditoriaEdicao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8430634115941486277L;
	@Column(length = 150)
	private String nome;
	@Column(length = 14)
	private String cpf;
	@Column(length = 20)
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
