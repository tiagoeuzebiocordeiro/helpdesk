package com.tiago.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiago.helpdesk.services.DBService;

/*Toda vida que esse perfil "test" estiver ativo, ele vai subir essa BEAN (o método) de forma automática
 * ou seja, o método tá chamando o serviço que tem a lógica de popular a base de dados
 * é como se essa classe fosse responsável por chamar a carga de dados inicial (de forma provisória)
 * eu informei no app properties que o perfil era o test.*/

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

    @Bean
    public void instanciaDb() {
		dbService.instanciaDb();
	}
	
}
