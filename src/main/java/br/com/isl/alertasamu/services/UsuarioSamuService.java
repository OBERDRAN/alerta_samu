package br.com.isl.alertasamu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.isl.alertasamu.model.Atendimento;
import br.com.isl.alertasamu.model.UsuarioSamu;
import br.com.isl.alertasamu.repository.UsuarioSamuRepository;
import br.com.isl.alertasamu.services.exceptions.DataIntegrityException;
import br.com.isl.alertasamu.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioSamuService {
	
	@Autowired
	private UsuarioSamuRepository repo;
	
	
	public List<UsuarioSamu>buscartodos(){
		List<UsuarioSamu> UsuarioSamu = repo.findAll();
		return UsuarioSamu;
	}
	
	public UsuarioSamu buscar(Long id) {
		Optional<UsuarioSamu>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrado! Id: " + id + ", Tipo: " + Atendimento.class.getName()));
		}
	
	public UsuarioSamu inserir(UsuarioSamu obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public UsuarioSamu atualizar(UsuarioSamu obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	public void deletar(Long id) {
		buscar(id);
		try {
		repo.deleteById(id);
		}
	    catch(DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não foi possível excluir um usuario.");
	    }
		
	}

}
