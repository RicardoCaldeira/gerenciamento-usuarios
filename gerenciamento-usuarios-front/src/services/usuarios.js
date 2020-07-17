import {http} from './config'

export default{
    listar:() => {
        return http.get('usuarios')
    },

    salvar:(usuario) => {
        console.log(usuario)
        return http.post('usuario', {"cpf": usuario.cpf,
        "nome": usuario.nome,
        "dataNascimento": usuario.dataNascimento,
        "sexo": usuario.sexo,
        "usuario":{
            "cargo": usuario.cargo
        }})
    },

    atualizar:(usuario) => {
        return http.put('usuario', {"cpf": usuario.cpf,
        "nome": usuario.nome,
        "dataNascimento": usuario.dataNascimento,
        "sexo": usuario.sexo,
        "usuario":{
            "id": usuario.id,
            "cargo": usuario.cargo
        }})
    },

    apagar:(usuario) => {
        return http.delete('usuario', {"cpf": usuario.pessoa.cpf,
        "nome": usuario.pessoa.nome,
        "dataNascimento": usuario.pessoa.dataNascimento,
        "sexo": usuario.pessoa.sexo,
        "usuario":{
            "id": usuario.id,
            "cargo": usuario.cargo
        }})
    }
}