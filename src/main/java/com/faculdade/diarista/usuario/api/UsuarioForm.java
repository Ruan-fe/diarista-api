package com.faculdade.diarista.usuario.api;


import com.faculdade.diarista.usuario.dominio.Usuario;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Getter
public class UsuarioForm {


    @NotNull(message = "{campo.nome.obrigatorio}")
    @NotBlank(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.valido}")
    private String cpf;

    @NotNull(message = "{campo.email.obrigatorio}")
    @NotBlank(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.valido}")
    private String email;

    @NotNull(message = "{campo.senha.obrigatorio}")
    @NotBlank(message = "{campo.senha.obrigatorio}")
    private String senha;

    private String telefone;

    @NotNull(message = "{campo.celular.obrigatorio}")
    @NotBlank(message = "{campo.celular.obrigatorio}")
    private String celular;

    //endereço
    @NotNull(message = "{campo.logradouro.obrigatorio}")
    @NotBlank(message = "{campo.logradouro.obrigatorio}")
    private String logradouro;

    @NotNull(message = "{campo.cidade.obrigatorio}")
    @NotBlank(message = "{campo.cidade.obrigatorio}")
    private String cidade;

    @NotNull(message = "{campo.estado.obrigatorio}")
    @NotBlank(message = "{campo.estado.obrigatorio}")
    private String estado;

    @NotNull(message = "{campo.cep.obrigatorio}")
    @NotBlank(message = "{campo.cep.obrigatorio}")
    private String cep;

    @NotNull(message = "{campo.pais.obrigatorio}")
    @NotBlank(message = "{campo.pais.obrigatorio}")
    private String pais;



    public Usuario converter(BCryptPasswordEncoder bCryptPasswordEncoder){

        return new Usuario(null,nome,cpf,email,bCryptPasswordEncoder.encode(senha),telefone,celular,logradouro,cidade,estado,cep,pais);

    }
}
