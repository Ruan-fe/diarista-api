package com.faculdade.diarista.usuario.api;

import com.faculdade.diarista.usuario.dominio.Usuario;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UsuarioForm {

    @NotNull
    private String nome;
    @NotNull
    @CPF
    private String cpf;
    @NotNull
    @Email
    private String email;
    private String telefone;
    @NotNull
    private String celular;

    //endereço
    @NotNull
    private String logradouro;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String cep;
    private String pais;


    public Usuario converter(){
        return new Usuario(null,nome,cpf,email,telefone,celular,logradouro,cidade,estado,cep,pais);
    }
}
