package com.inovi.allerta.modelos;

public class Publicacao {
    private String texto;
    private Populacao usuario;
    private String imagem;

    public Publicacao() {
    }

    public Publicacao(String texto, Populacao usuario, String imagem) {
        this.texto = texto;
        this.usuario = usuario;
        this.imagem = imagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Populacao getUsuario() {
        return usuario;
    }

    public void setUsuario(Populacao usuario) {
        this.usuario = usuario;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "texto='" + texto + '\'' +
                ", usuario=" + usuario +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}
