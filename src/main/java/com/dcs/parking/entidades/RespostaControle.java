package com.dcs.parking.entidades;

import java.io.Serializable;

/**
 * Classe responsável por conter mensagens de retorno do web service
 * 
 * @author Djeison 12 de fev de 2020
 */
public class RespostaControle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9163539837237154073L;
	private String codigo;
	private String mensagem;

	/**
	 * Construtor responsável por
	 * 
	 * @author Djeison 12 de fev de 2020
	 */
	public RespostaControle(String codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
