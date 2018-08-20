package com.inovi.allerta;

import com.inovi.allerta.modelos.Alerta;
import com.inovi.allerta.modelos.Area;
import com.inovi.allerta.modelos.Populacao;
import com.inovi.allerta.modelos.Publicacao;

import java.util.ArrayList;
import java.util.List;

public class BD {
    public static Populacao pop = new Populacao("José Euclides", new Area(2, "Vasco da Gama"), true,
            new ArrayList<Publicacao>(),"pop", "123");

    public static List<Area> areas = new ArrayList<>();
    public static List<Publicacao> publicacoes = new ArrayList<>();
    public static List<Alerta> alertas = new ArrayList<>();

    public static void popularAreas(){
        areas.add(new Area(1, "Córrego Jenipapo"));
        areas.add(new Area(2, "Vasco da Gama"));
        areas.add(new Area(3, "Brasília Teimosa"));
        areas.add(new Area(4, "Afogados"));

        //return areas;
    }

    public static void popularPublicacoes(){
        publicacoes.add(new Publicacao("Que situação, tá quase desmoronando", pop,
                "dugyb73QGBDVTfsbds", areas.get(0)));
        publicacoes.add(new Publicacao("Que situação, tá quase desmoronando", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        publicacoes.add(new Publicacao("Urgência, muita urgência", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        publicacoes.add(new Publicacao("Aqui tá perto de cair a barragem do Botafogo", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        publicacoes.add(new Publicacao("Aqui tá perto de cair a barragem do Botafogo", pop,
                "dugyb73QGBDVTfsbds", areas.get(2)));
        publicacoes.add(new Publicacao("Aqui tá perto de cair a barragem do Botafogo", pop,
                "dugyb73QGBDVTfsbds", areas.get(3)));
        //return publicacoes;
    }

    public static void popularAlertas(){
        alertas.add(new Alerta ("Alerta nº 1", "Alta intensidade de chuvas nas últimas 6 horas",
                "Casa Amarela",  3));
        alertas.add(new Alerta("Alerta nº 2", "Média intensidade de chuvas nas últimas 12 horas",
                "Macaxeira",  2));
        alertas.add(new Alerta("Alerta nº 3", "Quantidade de chuva nas últimas 24 horas",
                "Iputinga",  1));
        alertas.add(new Alerta("Alerta nº 4", "Média intensidade de chuvas nas últimas 12 horas",
                "Torrões",  2));
        alertas.add(new Alerta("Alerta nº 5", "Barreiras deslisando devido as chuvas",
                "Alto do Mandu",  3));
        alertas.add(new Alerta("Alerta nº 6", "Quantidade de chuva nas últimas 24 horas",
                "Dois Irmãos",  1));
        alertas.add(new Alerta("Alerta nº 7", "Quantidade de chuva nas últimas 24 horas",
                "Espinheiro",  1));
        alertas.add(new Alerta("Alerta nº 8", "Quantidade de chuva nas últimas 24 horas",
                "Casa Caiada",  1));
        alertas.add(new Alerta("Alerta nº 9", "Média intensidade de chuvas nas últimas 12 horas",
                "Alto da Bondade", 2));
        alertas.add(new Alerta("Alerta nº 10", "Barreiras deslisando devido as chuvas",
                "Vasco da Gama", 3));
    }
}
