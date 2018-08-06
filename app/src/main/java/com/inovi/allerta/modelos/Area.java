package com.inovi.allerta.modelos;

public class Area {
    private int codigo;
    private String nome;

    public Area() {
    }

    public Area(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Area{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
