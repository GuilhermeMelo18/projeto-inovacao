package com.inovi.allerta.modelos;

import java.util.List;

public class Populacao {
    private String nome;
    private Area area;
    private boolean receberNotificacoes;
    private List<Publicacao> publicacoes;

    private String login;
    private String senha;

    public Populacao() {
    }

    public Populacao(String nome, Area area, boolean receberNotificacoes, List<Publicacao> publicacoes, String login, String senha) {
        this.nome = nome;
        this.area = area;
        this.receberNotificacoes = receberNotificacoes;
        this.publicacoes = publicacoes;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean isReceberNotificacoes() {
        return receberNotificacoes;
    }

    public void setReceberNotificacoes(boolean receberNotificacoes) {
        this.receberNotificacoes = receberNotificacoes;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Populacao{" +
                "nome='" + nome + '\'' +
                ", area=" + area +
                ", receberNotificacoes=" + receberNotificacoes +
                ", publicacoes=" + publicacoes +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
