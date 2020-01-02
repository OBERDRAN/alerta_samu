package br.com.isl.alertasamu.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.isl.alertasamu.services.BancoDeDadosService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private BancoDeDadosService bdservice;
	
	@Bean
	public boolean instanciaBancoDeDados() throws ParseException {
		
		bdservice.instanciaTestBancoDeDados();
		return true;
		
	}
}
