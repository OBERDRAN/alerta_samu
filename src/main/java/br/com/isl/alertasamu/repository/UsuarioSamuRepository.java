package br.com.isl.alertasamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isl.alertasamu.model.UsuarioSamu;


@Repository
public interface UsuarioSamuRepository extends JpaRepository<UsuarioSamu, Long> {

}