package br.com.fdp.contoller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fdp.entity.Estado;
import br.com.fdp.repository.EstadoRepository;

@ManagedBean
@ViewScoped
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	private Estado estado;
	private List<Estado> estados;
	boolean modoEdicao = false;
	
	public EstadoRepository getEstadoRepository() {
		return estadoRepository;
	}

	public void setEstadoRepository(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void init(){
		setEstados(estadoRepository.findAll());
	}
	
	public void salvar(){
		if(!modoEdicao)
			estadoRepository.save(estado);
		estado = new Estado();
		modoEdicao = false;
	}
	
	public void excluir(Estado e){
		estadoRepository.save(e);
	}
	
	public void editar(Estado e){
		setEstado(e);
		modoEdicao = true;
	}
	
	public List<Estado> listar(){
		return estados;
	}
}
