package com.gerenciamento.apirest.resources;

import java.util.Date;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.apirest.dto.PessoaDto;
//import com.gerenciamento.apirest.dto.UsuarioDto;
import com.gerenciamento.apirest.models.Pessoa;
import com.gerenciamento.apirest.models.Usuario;
import com.gerenciamento.apirest.repository.PessoaRepository;
import com.gerenciamento.apirest.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Gerenciamento")
@CrossOrigin(origins="*")
public class GerenciamentoResource {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/usuarios")
	@ApiOperation(value="retorna uma lista de usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	@ApiOperation(value="retorna um usuario específico")
	public Usuario listaUsuarioUnico(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping(value="/usuario")
	@ApiOperation(value="salva um usuario")
	public Usuario salvaUsuario(@RequestBody PessoaDto pess) {
		System.out.println(pess.cpf);
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(pess.cpf);
		pessoa.setDataNascimento(pess.dataNascimento);
		pessoa.setNome(pess.nome);
		pessoa.setSexo(pess.sexo);
		if (pessoaRepository.save(pessoa) != null ) {
			Usuario user = new Usuario();
			user.setCargo(pess.usuario.cargo);
			user.setDataCadastro(new Date());
			user.setPessoa(pessoa);
			usuarioRepository.save(user);
			return user;
		}
		
		return null;
	}
	
	@DeleteMapping("/usuario")
	@ApiOperation(value="deleta usuario")
	public void deletaUsuario(@RequestBody PessoaDto pess) {
		usuarioRepository.delete(usuarioRepository.findById(pess.usuario.id));
		pessoaRepository.delete(pessoaRepository.findByCpf(pess.cpf));
	}
	
	@PutMapping(value="/usuario")
	@ApiOperation(value="atualiza um usuario")
	public Usuario atualizaUsuario(@RequestBody PessoaDto pess) {
		//System.out.println(pess.cpf);
		Pessoa pessoa = pessoaRepository.findByCpf(pess.cpf);
		pessoa.setDataNascimento(pess.dataNascimento);
		pessoa.setNome(pess.nome);
		pessoa.setSexo(pess.sexo);
		if (pessoaRepository.save(pessoa) != null ) {
			Usuario user = usuarioRepository.findById(pess.usuario.id);
			user.setCargo(pess.usuario.cargo);
			user.setPessoa(pessoa);
			usuarioRepository.save(user);
			return user;
		}
		return null;
	}
}
