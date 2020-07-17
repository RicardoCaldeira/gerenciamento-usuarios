package com.gerenciamento.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.apirest.models.Pessoa;

//JpaRepositoryTemVariosMetodosParaFazerPersistenciasNoBanco
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	Pessoa findById(long id);
	Pessoa findByCpf(String cpf);
}