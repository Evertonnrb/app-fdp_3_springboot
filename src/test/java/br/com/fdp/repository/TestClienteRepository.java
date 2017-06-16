package br.com.fdp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fdp.entity.Cliente;

@RunWith(SpringRunner.class)//Classe de test do junit
@DataJpaTest //Ira testar JPA
@AutoConfigureTestDatabase(replace=Replace.NONE)//configuração do banco para testes
//@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,replace=Replace.ANY)//troca o banco para efetuar os testes

public class TestClienteRepository {

	/**
	 * injeção de dependencia
	 * busca a notação de nean na classe ClienteRepository
	 */
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EntityManager entityManager;
	
	@Test
	@Ignore
	public void salvar(){
		Cliente cliente = new Cliente("Jão","jao@gmail.com");
		Cliente cli = clienteRepository.save(cliente);
		Assert.assertNotNull(cli.getId());	
	}
	@Test
	@Ignore
	public void buscarPorEmail(){
		Cliente cliente = new Cliente("Silva", "silva@gmail.com");
		entityManager.persist(cliente);//salva
		
		Cliente cliEncontrado = clienteRepository.buscarPorEmail("silva@gmail.com");
		assertThat(cliEncontrado.getNome()).isEqualTo(cliente.getNome());
		assertThat(cliEncontrado.getEmail()).isEqualTo(cliente.getEmail());	
	}
	@Test
	public void testBuscarTodos(){
		Cliente cliJao = new Cliente("Ze", "ze@hotmail");
		entityManager.persist(cliJao);
		
		Cliente cliMaria = new Cliente("Maria", "maria@bol.com");
		
		entityManager.persist(cliMaria);
		
		List<Cliente> lista = clienteRepository.bucarTodos();
		assertThat(lista.get(0).equals(cliJao));
		assertThat(lista.get(1).equals(cliMaria));	
		assertThat(lista.get(0).getNome()).isEqualTo(cliJao.getNome());
		assertThat(lista.get(1).getNome()).isEqualTo(cliMaria.getNome());
	}
	
}
