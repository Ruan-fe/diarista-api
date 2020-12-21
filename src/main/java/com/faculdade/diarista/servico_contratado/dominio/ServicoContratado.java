package com.faculdade.diarista.servico_contratado.dominio;

import com.faculdade.diarista.servico.dominio.Servico;
import com.faculdade.diarista.usuario.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "servico_contratado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServicoContratado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotNull
    private Usuario usuarioContratante;

    @ManyToOne
    @NotNull
    private Servico servico;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContratado;

    @PrePersist
    public void prePersist(){
        setDataContratado(LocalDate.now());
    }

}
