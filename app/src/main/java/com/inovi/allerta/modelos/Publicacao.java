package com.inovi.allerta.modelos;

import android.graphics.Bitmap;

public class Publicacao {
    private String texto;
    private Populacao usuario;
    private Bitmap imagem;
    private String caminhoImagem;
    private Area area;

    public Publicacao() {
    }

    public Publicacao(String texto, Populacao usuario, String caminhoImagem, Area area) {
        this.texto = texto;
        this.usuario = usuario;
        this.caminhoImagem = caminhoImagem;
        this.imagem = null;
        this.area = area;
    }

    public Publicacao(String texto, Populacao usuario, Bitmap imagem, Area area) {
        this.texto = texto;
        this.usuario = usuario;
        this.imagem = imagem;
        this.caminhoImagem = null;
        this.area = area;
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

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "texto='" + texto + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
