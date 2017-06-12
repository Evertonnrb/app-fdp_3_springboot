package br.com.fdp.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fdp.entity.Cliente;

@RunWith(SpringRunner.class)//Classe de test do junit
@DataJpaTest //Ira testar JPA
//@AutoConfigureTestDatabase(replace=Replace.NONE)//configuração do banco para testes
/**
 * Database interno
 * @author Everton
 *
 */
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,replace=Replace.ANY)//troca o banco para efetuar os testes

public class TestClienteRepository {

	/**
	 * injeção de dependencia
	 * busca a notação de nean na classe ClienteRepository
	 */
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void salvar(){
		Cliente cliente = new Cliente("Jão","jao@gmail.com");
		Cliente cli = clienteRepository.save(cliente);
		Assert.assertNotNull(cli.getId());	
	}
}
