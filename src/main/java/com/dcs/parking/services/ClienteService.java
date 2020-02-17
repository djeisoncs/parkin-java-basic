/**
 * 
 */
package com.dcs.parking.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dcs.parking.controllers.entidades.ClienteDto;
import com.dcs.parking.entidades.Cliente;
import com.dcs.parking.entidades.Veiculo;
import com.dcs.parking.enumerador.InformativoEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.services.IClienteService;
import com.dcs.parking.repository.ClienteReporitory;
import com.dcs.parking.util.UtilObject;

/**
 * Classe responsável por validar regras de negocio referentes a entidade
 * cliente
 * 
 * @author Djeison 12 de fev de 2020
 */
@Service
public class ClienteService extends ServiceEntityFull<Cliente> implements IClienteService {

	@Autowired
	private ClienteReporitory reporitory;
	@Autowired
	private VeiculoService veiculoService;

	/**
	 * Método responsável por retornar a instancia de repositorio da entidade
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return reporitory
	 */
	@Override
	public JpaRepository<Cliente, Long> getRepository() {
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
		return "Cliente";
	}

	/**
	 * Método responsável por pesquisar clientes por nome
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param nome
	 * @return clientes
	 */
	@Override
	public List<Cliente> pesquisarClientesPorNome(String nome) {
		return reporitory.findByNomeIgnoreCaseContainingOrderByNomeAsc(nome);
	}

	/**
	 * Método responsável por pesquisar clientes por cpf
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cpf
	 * @return clientes
	 */
	@Override
	public List<Cliente> pesquisarClientesPorCpf(String cpf) {
		return reporitory.findByCpfIgnoreCaseContainingOrderByNomeAsc(cpf);
	}

	/**
	 * Método responsável por retornar o cliente referente ao cpf passado
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param cpf
	 * @return cliente
	 */
	@Override
	public Cliente getClientesPorCpf(String cpf) {
		return reporitory.findByCpfIgnoreCaseLike(cpf);
	}

	/**
	 * Método responsável por salvar o cliente passado por parametro
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @return cliente
	 * @throws NegocioException
	 */
	@Override
	public ClienteDto salvar(ClienteDto cliente) throws NegocioException {
		return montarDados(cliente.getCliente(), veiculoService
				.salvar(veiculoService.montarDados(super.salvar(cliente.getCliente()), cliente.getVeiculos())));
	}

	/**
	 * Método responsável por editar o cliente passado por parametro
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param cliente
	 * @return cliente
	 * @throws NegocioException
	 */
	@Override
	public ClienteDto editar(ClienteDto cliente) throws NegocioException {
		System.out.println("Data de cadastro cliente: "+cliente.getCliente().getDataCadastro());
		if (cliente.getVeiculosDeletar().size() > 0)
			veiculoService.excluir(cliente.getVeiculosDeletar());
		return montarDados(cliente.getCliente(), veiculoService
				.editar(veiculoService.montarDados(super.editar(cliente.getCliente()), cliente.getVeiculos())));
	}

	/**
	 * Método responsável por montar os dados da clienteDto com base nos parametros
	 * passados
	 * 
	 * @author Djeison 15 de fev de 2020
	 * @param entidade
	 * @param veiculos
	 * @return cliente
	 * @throws NegocioException
	 */
	@Override
	public ClienteDto montarDados(Cliente cliente, List<Veiculo> veiculos) throws NegocioException {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setCliente(cliente);
		clienteDto.setVeiculos(veiculos);
		return clienteDto;
	}

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return responseEntity
	 * @throws NegocioException
	 */
	public ResponseEntity<Map<String, Object>> getRespostaControle(ClienteDto entidade) throws NegocioException {
		Map<String, Object> mapa = new HashMap<>();
		if (UtilObject.isNotNull(entidade)) {
			if (UtilObject.isNotEmpty(getNomeEntidade()))
				mapa.put(getNomeEntidade(), entidade);
			else
				mapa.put(entidade.getClass().getName(), entidade);
		} else
			mapa.put(InformativoEnum.SEM_REGISTROS.getCodigo(), InformativoEnum.SEM_REGISTROS.getMensagem(""));
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}

}
