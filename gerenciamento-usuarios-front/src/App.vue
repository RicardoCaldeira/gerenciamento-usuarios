<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Gerenciamento de Usuarios</a>
      </div>
    </nav>

    <div class="container">
      <!--{{usuario.pessoa.nome}} -->

      <form @submit.prevent="salvar">

          <label>Nome</label>
          <input type="text" placeholder="Nome" v-model="usuario.nome">
          <label>CPF</label>
          <input type="text" placeholder="CPF" v-model="usuario.cpf">
          <label>Data de Nascimento</label>
          <input type="date" placeholder="Data de Nascimento" v-model="usuario.dataNascimento">
          <label>Sexo</label>
          <input type="text" placeholder="M ou F (Maiúsculo)" v-model="usuario.sexo">
          <label>Cargo</label>
          <input type="text" placeholder="Cargo" v-model="usuario.cargo">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>NOME</th>
            <th>CPF</th>
            <th>DATA_NASC</th>
            <th>SEXO</th>
            <th>CARGO</th>
            <th>DATA_CADASTRO</th>
            <th>OPÇÕES</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="usuario of usuarios" :key="usuario.id">

            <td>{{ usuario.pessoa.nome }}</td>
            <td>{{ usuario.pessoa.cpf }}</td>
            <td>{{ usuario.pessoa.dataNascimento }}</td>
            <td>{{ usuario.pessoa.sexo }}</td>
            <td>{{ usuario.cargo }}</td>
            <td>{{ usuario.dataCadastro }}</td>
            <td>
              <button @click="editar(usuario)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remover(usuario)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

 import Usuario from './services/usuarios';
  export default{

    //responsável por retornar os atributos do componente
    data(){
      return {
        usuario: {
          cargo: '',
          dataCadastro: '',
          cpf: '',
          dataNascimento: '',
          nome: '',
          sexo: '',
        },
        usuarios: []
      }
    },

    mounted(){
      this.listar()
    },

    methods:{

      listar(){
        Usuario.listar().then(resposta => {
        this.usuarios = (resposta.data)
        })
      },

      salvar(){
        if (!this.usuario.id){
          alert(this.usuario.nome)
          Usuario.salvar(this.usuario).then(resposta => {
            this.usuario = {}
            console.log(resposta)
            alert('Salvo com sucesso!')
            this.listar()
          })
        }else{
          Usuario.atualizar(this.usuario).then(resposta => {
            this.usuario = {}
            console.log(resposta)
            alert('Atualizado com sucesso!')
            this.listar()
          })
        }
        
      },

      editar(usuario){
        this.usuario.nome = usuario.pessoa.nome
        this.usuario.cpf = usuario.pessoa.cpf
        this.usuario.dataNascimento = usuario.pessoa.dataNascimento
        this.usuario.sexo = usuario.pessoa.sexo
        this.usuario.id = usuario.id
        this.usuario.cargo = usuario.cargo
      },

      remover(usuario){
        if (confirm('Deseja excluir o usuário?')){
          Usuario.apagar(usuario).then(resposta =>{
          console.log(resposta);
          this.listar();
        })
        }
      }
    }
  }

</script>

<style>

</style>
