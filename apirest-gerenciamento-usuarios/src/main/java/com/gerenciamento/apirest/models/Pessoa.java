package com.gerenciamento.apirest.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="PESSOA")
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="id", unique=true, nullable=false)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="cpf", unique=true, nullable=false)
	private String cpf;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="Data_Nascimento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	// private LocalDateTime dataCriacao = LocalDateTime.now(); DATA DE CADASTRO
	
	@Column(name="Sexo")
	private char sexo;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		if (sexo == 'M' || sexo == 'F'){
			this.sexo = sexo;
		}
	}
}
