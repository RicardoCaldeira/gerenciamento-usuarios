package com.gerenciamento.apirest.dto;

import java.time.LocalDate;

public class PessoaDto{

	public UsuarioDto usuario;
	
	public String cpf;

	public String nome;
	
	public LocalDate dataNascimento;
	// private LocalDateTime dataCriacao = LocalDateTime.now(); DATA DE CADASTRO
	
	public char sexo;
}
