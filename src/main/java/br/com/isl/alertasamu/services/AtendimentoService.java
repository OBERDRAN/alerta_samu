package br.com.isl.alertasamu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import br.com.isl.alertasamu.model.Atendimento;
import br.com.isl.alertasamu.repository.AtendimentoRepository;
import br.com.isl.alertasamu.services.exceptions.DataIntegrityException;
import br.com.isl.alertasamu.services.exceptions.ObjectNotFoundException;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository repo;
	
	public List<Atendimento>buscartodos(){
		List<Atendimento> atendimento = repo.findAll();
		return atendimento;
	}
	
	public Atendimento buscar(Long id) {
		Optional<Atendimento>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Atendimento não encontrado! Id: " + id + ", Tipo: " + Atendimento.class.getName()));
		}
	
	public Atendimento inserir(Atendimento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Atendimento atualizar(Atendimento obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	public void deletar(Long id) {
		buscar(id);
	
		try {
		repo.deleteById(id);
		}
	    catch(DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não foi possível excluir o Atendimento.");
	    }
		
	}

}
