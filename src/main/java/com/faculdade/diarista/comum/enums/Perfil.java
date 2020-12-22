package com.faculdade.diarista.comum.enums;

public enum Perfil {

    ADMIN(1,"ROLE_ADMIN"),
    USUARIO(2,"ROLE_USUARIO");

    private Integer codigo;
    private String descricao;

    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }

    public void add(Integer codigo) {
    }
}
