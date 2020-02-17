/**
 * 
 */
package com.dcs.parking.enumerador;

/**
 * Classe responsável por mensagens e codigos de informação
 * 
 * @author DEV 28 de mai de 2019
 */
public enum InformativoEnum {

	SEM_REGISTROS(1), SALVO_SUCESSO(2), EDITADO_SUCESSO(3), EXCLUIDO_SUCESSO(4);

	public final int valor;

	/**
	 * Construtor responsável por
	 * 
	 * @author Djeison 12 de fev de 2020
	 */
	private InformativoEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	/**
	 * Método responsável por retornar o codigo da informação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return codigo
	 */
	public String getCodigo() {
		if (valor == SEM_REGISTROS.getValor())
			return "INF0001";
		else if (valor == SALVO_SUCESSO.getValor())
			return "INF0002";
		else if (valor == SALVO_SUCESSO.getValor())
			return "INF0003";
		else if (valor == EXCLUIDO_SUCESSO.getValor())
			return "INF0004";
		return "INF0000";
	}

	/**
	 * Método responsável por retornar o mensagem da informação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return mensagem
	 */
	public String getMensagem(String msg) {
		if (valor == SEM_REGISTROS.getValor())
			return "Nenhum registro encontrado";
		else if (valor == SALVO_SUCESSO.getValor())
			return msg + " salvo(a) com sucesso!";
		else if (valor == SALVO_SUCESSO.getValor())
			return msg + " editado(a) com sucesso!";
		else if (valor == EXCLUIDO_SUCESSO.getValor())
			return msg + " excluido(a) com sucesso!";
		return "INF0000";
	}
}
