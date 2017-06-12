package br.com.fdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fdp.entity.Cliente;
/**
 * Inferdace abstrata para persistencia de Cliente
 * Cliente objeto cliente
 * Long o tipo da chave da entidade
 * extends porque não sera usados todos os metodos de implemetação 
 * do JpaRepository , e irá ser necessário criar outros métodos
 * @author Everton email everton.nrb@gmail.com
 */

@Repository //a partir dessa notassaçao bean para o spring
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
	/**
	 * Busca por email
	 * @param email parametro de busca da query
	 * @return email from c.cliente
	 */
	@Query("SELECT c FROM Cliente c WHERE c.email=:email")
	public Cliente buscarPorEmail(@Param("email")String email);
	
	/**
	 * Busca todos cliente e coloca na lista
	 * ignorando o findAll da interface	
	 * @return
	 */
	@Query("SELECT c FROM Cliente c")
	public List<Cliente>bucarTodos();
}
