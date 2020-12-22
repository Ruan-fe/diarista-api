package com.faculdade.diarista.usuario.dominio;


import com.faculdade.diarista.comum.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
@Getter
@Setter
public class Usuario{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @CPF
    @Column(unique = true)
    private String cpf;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String senha;

    private Perfil perfil;

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


    public void addPerfil(Perfil perfil){
        perfil.add(perfil.getCodigo());
    }

}
