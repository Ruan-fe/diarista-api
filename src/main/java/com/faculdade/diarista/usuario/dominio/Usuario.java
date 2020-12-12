package com.faculdade.diarista.usuario.dominio;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
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
}
