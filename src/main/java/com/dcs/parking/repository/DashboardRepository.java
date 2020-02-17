/**
 * 
 */
package com.dcs.parking.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dcs.parking.entidades.DashBoard;

/**
 * Classe responsável por 
 * @author Djeison
 * 16 de fev de 2020
 */
public class DashboardRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public DashBoard getRecebimentosAgrupadosPorFormapagamento() {
		String sql = "select f.id, f.descricao, sum(r.valor) as total from tb_recebimento_mov r " + 
				"inner join tb_forma_pagamento f on f.id = r.forma_pagamento_id " + 
				"group by f.id, f.descricao " + 
				"order by f.descricao asc";
		return (DashBoard) jdbcTemplate.query(sql, new BeanPropertyRowMapper<DashBoard>(DashBoard.class));
	}
}
