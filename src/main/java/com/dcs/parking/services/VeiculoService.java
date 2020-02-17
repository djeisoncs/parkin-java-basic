/**
 * 
 */
package com.dcs.parking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.dcs.parking.entidades.Cliente;
import com.dcs.parking.entidades.Veiculo;
import com.dcs.parking.enumerador.NegocioExceptionEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.services.IVeiculoService;
import com.dcs.parking.repository.VeiculoReporitory;
import com.dcs.parking.util.UtilObject;

/**
 * Classe responsável por validar regras de negocio referentes a entidade
 * veiculos
 * 
 * @author Djeison 12 de fev de 2020
 */
@Service
public class VeiculoService extends ServiceEntityFull<Veiculo> implements IVeiculoService {

	@Autowired
	private VeiculoReporitory reporitory;

	/**
	 * Método responsável por retornar a instancia de repositorio da entidade
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return reporitory
	 */
	@Override
	public JpaRepository<Veiculo, Long> getRepository() {
		return reporitory;
	}

	/**
	 * Método responsável por retornar o nome da entidade
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return nome
	 */
	@Override
	public String getNomeEntidade() {
		return "Veiculo";
	}

	/**
	 * Método responsável por pesquisar veiculo por placa
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return veiculos
	 */
	@Override
	public List<Veiculo> pesquisarVeiculosPorPlaca(String placa) {
		return reporitory.findByPlacaIgnoreCaseContainingOrderByModeloAsc(placa);
	}

	/**
	 * Método responsável por retornar veiculo correspondente a placa passada por
	 * paramentro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return veiculos
	 * @throws NegocioException
	 */
	@Override
	public Veiculo getVeiculoPorPlaca(String placa) throws NegocioException {
		Veiculo veiculo = new Veiculo();
		veiculo = reporitory.findByPlacaIgnoreCaseLike(placa);
		if (UtilObject.isNull(veiculo))
			if (placa.length() == 7)
				veiculo = reporitory.findByPlacaIgnoreCaseLike(
						placa.substring(0, 2) + "-" + placa.substring(2, placa.length() - 1));
		if (UtilObject.isNull(veiculo))
			throw new NegocioException(NegocioExceptionEnum.DADOS_INEXISTENTE.getCodigo(),
					NegocioExceptionEnum.DADOS_INEXISTENTE.getMensagem("Veiculo com placa " + placa));
		return veiculo;
	}

	/**
	 * Método responsável por pesquisar veiculos por modelo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param modelo
	 * @return veiculos
	 */
	@Override
	public List<Veiculo> pesquisarVeiculosPorModelo(String modelo) {
		return reporitory.findByModeloIgnoreCaseContainingOrderByModeloAsc(modelo);
	}

	/**
	 * Método responsável por pesquisar veiculos por cor
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cor
	 * @return veiculos
	 */
	@Override
	public List<Veiculo> pesquisarVeiculosPorCor(String cor) {
		return reporitory.findByCorIgnoreCaseContainingOrderByCorAsc(cor);
	}

	/**
	 * Método responsável por montar dados da entidade veiculo
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @param veiculo
	 * @return veiculo
	 * @throws NegocioException
	 */
	@Override
	public Veiculo montarDados(Cliente cliente, Veiculo veiculo) throws NegocioException {
		veiculo.setCliente(cliente);
		return veiculo;
	}

	/**
	 * Método responsável por montar dados das entidades veiculos
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @param veiculos
	 * @return veiculos
	 * @throws NegocioException
	 */
	@Override
	public List<Veiculo> montarDados(Cliente cliente, List<Veiculo> veiculos) throws NegocioException {
		List<Veiculo> veiculosNew = new ArrayList<>();
		for (Veiculo veiculo : veiculos)
			veiculosNew.add(montarDados(cliente, veiculo));
		return veiculosNew;
	}

	/**
	 * Método responsável por listar veiculos por cliente 
	 * @author Djeison
	 * 16 de fev de 2020
	 * @param idCliente
	 * @return veiculos
	 */
	@Override
	public List<Veiculo> listarVeiculosPorCliente(Long idCliente) {
		return reporitory.findByClienteIdOrderByPlacaAsc(idCliente);
	}
}
