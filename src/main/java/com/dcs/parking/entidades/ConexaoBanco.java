/**
 * 
 */
package com.dcs.parking.entidades;

import java.io.Serializable;

/**
 * Classe responsável por conter os parametros de configuração de banco de dados
 * 
 * @author Djeison 12 de fev de 2020
 */
public class ConexaoBanco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8218168709697247L;
	private String idConexao;
	private String usuario;
	private String senha;
	private String driver;
	private String url;
	private String urlFinal;
	private String porta;
	private String servidor;
	private String dataBase;
	private String tipo;

	/**
	 * @return the idConexao
	 */
	public String getIdConexao() {
		return idConexao;
	}

	/**
	 * @param idConexao the idConexao to set
	 */
	public void setIdConexao(String idConexao) {
		this.idConexao = idConexao;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the urlFinal
	 */
	public String getUrlFinal() {
		return urlFinal;
	}

	/**
	 * @param urlFinal the urlFinal to set
	 */
	public void setUrlFinal(String urlFinal) {
		this.urlFinal = urlFinal;
	}

	/**
	 * @return the porta
	 */
	public String getPorta() {
		return porta;
	}

	/**
	 * @param porta the porta to set
	 */
	public void setPorta(String porta) {
		this.porta = porta;
	}

	/**
	 * @return the servidor
	 */
	public String getServidor() {
		return servidor;
	}

	/**
	 * @param servidor the servidor to set
	 */
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	/**
	 * @return the dataBase
	 */
	public String getDataBase() {
		return dataBase;
	}

	/**
	 * @param dataBase the dataBase to set
	 */
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 16 de fev de 2020
	 * @return
	 */
	@Override
	public String toString() {
		return "ConexaoBanco [idConexao=" + idConexao + ", usuario=" + usuario + ", senha=" + senha + ", driver="
				+ driver + ", url=" + url + ", urlFinal=" + urlFinal + ", porta=" + porta + ", servidor=" + servidor
				+ ", dataBase=" + dataBase + ", tipo=" + tipo + "]";
	}
	
	

}
