/**
 * 
 */
package com.dcs.parking.controllers.entidades;

import java.io.Serializable;
import java.util.List;

import com.dcs.parking.entidades.Cliente;
import com.dcs.parking.entidades.Veiculo;

/**
 * Classe responsável por
 * 
 * @author Djeison 15 de fev de 2020
 */
public class ClienteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6752472888002979573L;
	private Cliente cliente;
	private List<Veiculo> veiculos;
	private List<Veiculo> veiculosDeletar;

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

	/**
	 * @return the veiculos
	 */
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	/**
	 * @param veiculos the veiculos to set
	 */
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	/**
	 * @return the veiculosDeletar
	 */
	public List<Veiculo> getVeiculosDeletar() {
		return veiculosDeletar;
	}

	/**
	 * @param veiculosDeletar the veiculosDeletar to set
	 */
	public void setVeiculosDeletar(List<Veiculo> veiculosDeletar) {
		this.veiculosDeletar = veiculosDeletar;
	}

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((veiculos == null) ? 0 : veiculos.hashCode());
		result = prime * result + ((veiculosDeletar == null) ? 0 : veiculosDeletar.hashCode());
		return result;
	}

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDto other = (ClienteDto) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (veiculos == null) {
			if (other.veiculos != null)
				return false;
		} else if (!veiculos.equals(other.veiculos))
			return false;
		if (veiculosDeletar == null) {
			if (other.veiculosDeletar != null)
				return false;
		} else if (!veiculosDeletar.equals(other.veiculosDeletar))
			return false;
		return true;
	}

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @return
	 */
	@Override
	public String toString() {
		return "ClienteDto [cliente=" + cliente + ", veiculos=" + veiculos + ", veiculosDeletar=" + veiculosDeletar
				+ "]";
	}

}
