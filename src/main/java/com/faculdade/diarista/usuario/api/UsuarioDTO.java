package com.faculdade.diarista.usuario.api;

import com.faculdade.diarista.usuario.dominio.Usuario;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

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

    public UsuarioDTO (Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        cpf = usuario.getCpf();
        email = usuario.getEmail();
        senha = usuario.getSenha();
        telefone = usuario.getTelefone();
        celular = usuario.getCelular();

        logradouro = usuario.getLogradouro();
        cidade = usuario.getCidade();
        estado = usuario.getEstado();
        cep = usuario.getCep();
        pais = usuario.getPais();

    }

    public static List<UsuarioDTO> converter(List<Usuario> listUsuarios) {
        return listUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

}
