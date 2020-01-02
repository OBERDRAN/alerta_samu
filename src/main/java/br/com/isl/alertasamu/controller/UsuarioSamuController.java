package br.com.isl.alertasamu.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.isl.alertasamu.model.UsuarioSamu;
import br.com.isl.alertasamu.services.UsuarioSamuService;

@RestController
@RequestMapping(value="/usuarios-samu")
public class UsuarioSamuController {
	
	@Autowired
	private UsuarioSamuService usuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioSamu>> listar() {
		List<UsuarioSamu> UsuarioSamu = usuario.buscartodos();
		return ResponseEntity.ok().body(UsuarioSamu);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioSamu>find(@PathVariable Long id) {
		UsuarioSamu obj = usuario.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody UsuarioSamu obj) {
		obj = usuario.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void>update(@RequestBody UsuarioSamu obj,@PathVariable Long id) {
		obj.setId(id);
		usuario.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>delete(@PathVariable Long id) {
		usuario.deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
