package com.gerenciamento.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.apirest.models.Usuario;

//JpaRepositoryTemVariosMetodosParaFazerPersistenciasNoBanco
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findById(long id);
}