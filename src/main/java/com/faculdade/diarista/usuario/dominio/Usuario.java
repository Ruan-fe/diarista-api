package com.faculdade.diarista.usuario.dominio;


import com.faculdade.diarista.comum.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    @NotNull
    @JsonIgnore
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



    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }

}
