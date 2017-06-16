package br.com.fdp.contoller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fdp.entity.Cliente;
import br.com.fdp.repository.ClienteRepository;

@ManagedBean
@ViewScoped
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	private Cliente cliente = new Cliente();

	private List<Cliente> clientes;

	private boolean modoEdicao = false;
		
	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	/**
	 * Postconstruct =  carrega a lista de usuario assim que 
	 * terminar a insjeção de dependencia do Spring
	 */
	@PostConstruct	
	public void init(){
		setClientes(clienteRepository.bucarTodos());
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void salvar() {
		clienteRepository.save(getCliente());
		if(!modoEdicao )
			clientes.add(cliente);
		cliente = new Cliente();
		modoEdicao = false;
	}

	public void excluir(Cliente c){
		clienteRepository.delete(c);
		clientes.remove(c);
	}
	
	public List<Cliente> getClientes() {
		
		return clientes;
		
	}
	
	public void editar(Cliente c){
		setCliente(c);
		modoEdicao = true;
	}
	
	public void cancelar(){
		cliente = new Cliente();
		modoEdicao = false;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
