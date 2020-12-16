package com.faculdade.diarista.usuario.api;

import com.faculdade.diarista.usuario.dominio.Usuario;
import com.faculdade.diarista.usuario.dominio.UsuarioRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class EdicaoUsuarioForm {

    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String celular;

    //endereço
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;


    public Usuario atualizar(Integer idUsuario, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(idUsuario);

        usuario.setNome(this.nome);
        usuario.setCpf(this.cpf);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setTelefone(this.telefone);
        usuario.setCelular(this.celular);
        usuario.setLogradouro(this.logradouro);
        usuario.setCidade(this.cidade);
        usuario.setEstado(this.estado);
        usuario.setCep(this.cep);
        usuario.setPais(this.pais);

        return usuario;
    }
}
