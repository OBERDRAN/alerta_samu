package br.com.isl.alertasamu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import br.com.isl.alertasamu.model.Alerta;
import br.com.isl.alertasamu.repository.AlertaRepository;
import br.com.isl.alertasamu.services.exceptions.DataIntegrityException;
import br.com.isl.alertasamu.services.exceptions.ObjectNotFoundException;



@Service
public class AlertaService {
	
	@Autowired
	private AlertaRepository repo;
	
	public List<Alerta> buscartodos(){
		List<Alerta> Alerta = repo.findAll();
		return Alerta;
	}
	
	public Alerta buscar(Long id) {
		Optional<Alerta>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Alerta não encontrado! Id: " + id + ", Tipo: " + Alerta.class.getName()));
		}
	
	public Alerta inserir(Alerta obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Alerta atualizar(Alerta obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	public void deletar(Long id) {
		buscar(id);
		//abortando o delete para uma classe com objetos associados.
		try {
		repo.deleteById(id);
		}
	    catch(DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não foi possível excluir um Alerta com Status");
	    }
		
	}
	
	
	
	
	
	
	
	
}