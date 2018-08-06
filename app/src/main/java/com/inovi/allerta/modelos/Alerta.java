package com.inovi.allerta.modelos;

public class Alerta {
    private String titulo;
    private String informacao;
    private Area areaAlerta;
    private boolean statusEnvio;
    private int grauRisco;

    public Alerta() {
    }

    public Alerta(String titulo, String informacao, Area areaAlerta, boolean statusEnvio, int grauRisco) {
        this.titulo = titulo;
        this.informacao = informacao;
        this.areaAlerta = areaAlerta;
        this.statusEnvio = statusEnvio;
        this.grauRisco = grauRisco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public Area getAreaAlerta() {
        return areaAlerta;
    }

    public void setAreaAlerta(Area areaAlerta) {
        this.areaAlerta = areaAlerta;
    }

    public boolean isStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(boolean statusEnvio) {
        this.statusEnvio = statusEnvio;
    }

    public int getGrauRisco() {
        return grauRisco;
    }

    public void setGrauRisco(int grauRisco) {
        this.grauRisco = grauRisco;
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "titulo='" + titulo + '\'' +
                ", informacao='" + informacao + '\'' +
                ", areaAlerta=" + areaAlerta +
                ", statusEnvio=" + statusEnvio +
                ", grauRisco=" + grauRisco +
                '}';
    }
}