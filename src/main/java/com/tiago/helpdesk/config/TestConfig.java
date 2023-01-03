package com.tiago.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiago.helpdesk.services.DBService;

/*Classe de configuração que estará rodando o Profile "test"*/
@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	/*Para essa instanciação funcionar, estiver ativo, esse método vai subir de forma automática*/
	@Bean
	public void instanciaDb() {
		this.dbService.instanciaDB();
	}
	
}
