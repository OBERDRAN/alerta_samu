package br.com.isl.alertasamu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.stereotype.Service;

import br.com.isl.alertasamu.model.Atendimento;
import br.com.isl.alertasamu.model.UsuarioApp;

import br.com.isl.alertasamu.repository.UsuarioAppRepository;
import br.com.isl.alertasamu.services.exceptions.DataIntegrityException;
import br.com.isl.alertasamu.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioAppService {

	@Autowired
	private UsuarioAppRepository repo;

	public List<UsuarioApp> buscartodos() {
		List<UsuarioApp> UsuarioApp = repo.findAll();
		return UsuarioApp;
	}

	public UsuarioApp buscar(Long id) {
		Optional<UsuarioApp> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"UsuarioApp não encontrado! Id: " + id + ", Tipo: " + Atendimento.class.getName()));
	}

	public UsuarioApp inserir(UsuarioApp obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public UsuarioApp atualizar(UsuarioApp obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}

	public void deletar(Long id) {
		buscar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir o UsuarioApp.");
		}

	}

}
