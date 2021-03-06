/**
 * 
 */
package com.dcs.parking.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.parking.controllers.entidades.ClienteDto;
import com.dcs.parking.entidades.Cliente;
import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.enumerador.InformativoEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.controllers.IClienteController;
import com.dcs.parking.services.ClienteService;
import com.dcs.parking.services.ServiceEntityFull;

/**
 * Classe responsável por realizar todas as operações de comunicação da entidade
 * cliente
 * 
 * @author Djeison 13 de fev de 2020
 */
@Controller
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController extends ControllerEntityFull<Cliente> implements IClienteController {

	@Autowired
	private ClienteService service;

	/**
	 * Método responsável por retornar a instancia service da entidade manipulada
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return service
	 */
	@Override
	public ServiceEntityFull<Cliente> getService() {
		return service;
	}

	/**
	 * Método responsável por salvar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@PostMapping
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClienteDto entidade) {
		try {
			return service.getRespostaControle(service.salvar(entidade));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por salvar as entidades passadas por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@PostMapping(value = "/list")
	@Override
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody List<Cliente> entidades) {
		return salvar(entidades);
	}

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<RespostaControle>
	 */
	@PutMapping
	public ResponseEntity<RespostaControle> editar(@RequestBody ClienteDto entidade) {
		try {
			service.editar(entidade);
			return service.getRespostaControle(true, InformativoEnum.EDITADO_SUCESSO.getCodigo(),
					InformativoEnum.EDITADO_SUCESSO.getMensagem(""));
		} catch (NegocioException e) {
			return service.getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return
	 */
	@PutMapping(value = "/list")
	@Override
	public ResponseEntity<RespostaControle> editar(@RequestBody List<Cliente> entidades) {
		return super.editar(entidades);
	}

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<RespostaControle>
	 */
	@DeleteMapping(value = "/{id}")
	@Override
	public ResponseEntity<RespostaControle> excluir(@PathVariable Long id) {
		return super.excluir(id);
	}

	/**
	 * Método responsável por excluir todas as entidades cadastradas
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<RespostaControle>
	 */
	@DeleteMapping
	@Override
	public ResponseEntity<RespostaControle> excluir() {
		return super.excluir();
	}

	/**
	 * Método responsável por listar todas as entidades
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping
	@Override
	public ResponseEntity<Map<String, Object>> listarTodos() {
		return super.listarTodos();
	}

	/**
	 * Método responsável por realizar a consulta da entidade por id
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/id/{id}")
	@Override
	public ResponseEntity<Map<String, Object>> consultarPorId(@PathVariable Long id) {
		return super.consultarPorId(id);
	}

	/**
	 * Método responsável por pesquisar clientes por nome
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param nome
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/nome/{nome}")
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarClientesPorNome(@PathVariable String nome) {
		try {
			return service.getRespostaControle(service.pesquisarClientesPorNome(nome));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por pesquisar clientes por cpf
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param cpf
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/cpf/{cpf}")
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarClientesPorCpf(@PathVariable String cpf) {
		try {
			return service.getRespostaControle(service.pesquisarClientesPorCpf(cpf));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por retornar o cliente por cpf
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param cpf
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/get-cpf/{cpf}")
	@Override
	public ResponseEntity<Map<String, Object>> getClientesPorCpf(@PathVariable String cpf) {
		try {
			return service.getRespostaControle(service.getClientesPorCpf(cpf));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
