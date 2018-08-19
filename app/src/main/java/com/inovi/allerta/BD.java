package com.inovi.allerta;

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

    public static List<Area> popularAreas(){
        areas.add(new Area(1, "Córrego Jenipapo"));
        areas.add(new Area(2, "Vasco da Gama"));
        areas.add(new Area(3, "Brasília Teimosa"));
        areas.add(new Area(4, "Afogados"));

        return areas;
    }

    public static List<Publicacao> popularPublicacoes(){
        publicacoes.add(new Publicacao("Aqui tá perto de cair a barragem do Botafogo", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        publicacoes.add(new Publicacao("Que situação, tá quase desmoronando", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        publicacoes.add(new Publicacao("Urgência, muita urgência", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        publicacoes.add(new Publicacao("Aqui tá perto de cair a barragem do Botafogo", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        publicacoes.add(new Publicacao("Aqui tá perto de cair a barragem do Botafogo", pop,
                "dugyb73QGBDVTfsbds", pop.getArea()));
        return publicacoes;
    }
}
