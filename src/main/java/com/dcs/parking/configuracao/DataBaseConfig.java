/**
 * 
 */
package com.dcs.parking.configuracao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dcs.parking.entidades.Conexao;
import com.dcs.parking.entidades.ConexaoBanco;
import com.dcs.parking.services.ConexaoService;
import com.dcs.parking.util.Constantes;
import com.dcs.parking.util.JsonDadosUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Classe responsável por conter os métodos e parametros de configuração de
 * banco de dados
 * 
 * @author Djeison 12 de fev de 2020
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.dcs.parking.repository" })
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class DataBaseConfig {

	@Autowired
	private ConexaoService conexaoService;

	/**
	 * Método responsável por retornar o gerenciador de transações
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param factory
	 * @return PlatformTransactionManager
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		manager.setJpaDialect(new HibernateJpaDialect());
		return manager;
	}

	/**
	 * Método responsável por retornar o gerenciador de fabrica de entidades
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return EntityManagerFactory
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan("com.dcs.parking.entidades");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	/**
	 * Método responsável por retornar o data source
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		ConexaoBanco conexaoDados = new ConexaoBanco();
		Path path = Paths.get(".");
		try {
			conexaoDados = conexaoService.montarObjeto(path.toAbsolutePath().toString().toString().replaceAll(".", ""), Constantes.ARQUIVO_CONF_BANCO,
					"D");
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		dataSource.setUsername(conexaoDados.getUsuario());
		dataSource.setPassword(conexaoDados.getSenha());
		dataSource.setDriverClassName(conexaoDados.getDriver());
		dataSource.setUrl(conexaoDados.getUrl());
		return dataSource;
	}
}
