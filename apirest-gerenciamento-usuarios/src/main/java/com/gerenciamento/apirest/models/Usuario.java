package com.gerenciamento.apirest.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="id", unique=true, nullable=false)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //auto incrementa o valor do id
	private long id;
	
	@OneToOne
	@JoinColumn(name="pessoa_id", unique=true, nullable=false)
	private Pessoa pessoa;
	
	@Column(name="cargo", nullable=false)
	private String cargo;
	
	@Column(name="data_cadastro")
	private Date dataCadastro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
