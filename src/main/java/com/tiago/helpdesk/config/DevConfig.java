package com.tiago.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiago.helpdesk.services.DBService;

/*Classe de configuração que estará rodando o Profile "test"*/
@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	/*Uma string de valor propriedade do banco, se estiver create, ele irá instanciar o banco*/
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	/*Para essa instanciação funcionar, estiver ativo, esse método vai subir de forma automática*/
	@Bean
	public boolean instanciaDb() {
		if (value.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}
	
}
