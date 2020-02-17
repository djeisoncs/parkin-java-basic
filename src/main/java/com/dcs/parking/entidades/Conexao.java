/**
 * 
 */
package com.dcs.parking.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * Entidade de manipulação de dados de conexão de banco de dados
 * 
 * @author Djeison 12 de fev de 2020
 */
public class Conexao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9109193223170830534L;
	private String baseParaDados;
	private String baseParaImagem;
	private List<ConexaoBanco> conexoes;

	/**
	 * @return the baseParaDados
	 */
	public String getBaseParaDados() {
		return baseParaDados;
	}

	/**
	 * @param baseParaDados the baseParaDados to set
	 */
	public void setBaseParaDados(String baseParaDados) {
		this.baseParaDados = baseParaDados;
	}

	/**
	 * @return the baseParaImagem
	 */
	public String getBaseParaImagem() {
		return baseParaImagem;
	}

	/**
	 * @param baseParaImagem the baseParaImagem to set
	 */
	public void setBaseParaImagem(String baseParaImagem) {
		this.baseParaImagem = baseParaImagem;
	}

	/**
	 * @return the conexoes
	 */
	public List<ConexaoBanco> getConexoes() {
		return conexoes;
	}

	/**
	 * @param conexoes the conexoes to set
	 */
	public void setConexoes(List<ConexaoBanco> conexoes) {
		this.conexoes = conexoes;
	}

}
