package br.com.fdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.com.fdp.entity.Estado;

@SpringBootApplication
public class AppFdpIiiApplication extends org.springframework.boot.web.support.SpringBootServletInitializer{
										//Extendendo a classe para ativação do modulo web

	/**
	 * Método retorna SpringAplicationBuilfer
	 * Objeto de configurção do Spring
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(AppFdpIiiApplication.class, args);
		
		
		Estado estado = new Estado("Mato grosso so sul","MS");
		Estado estado1 = new Estado("Cuiaba","MT");
	}
}
