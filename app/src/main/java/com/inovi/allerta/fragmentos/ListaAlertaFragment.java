package com.inovi.allerta.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inovi.allerta.R;
import com.inovi.allerta.modelos.Alerta;

import java.util.ArrayList;
import java.util.List;

public class ListaAlertaFragment extends Fragment {
    private View rootView;
    private List<Alerta> alerta;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.fragment_alerta, container, false);

        this.alerta = new ArrayList<>();

        this.alerta.add(new Alerta("Alerta nº1", "Alta intensidade de chuvas nas últimas 6 horas",
                "Casa Amarela", true, 3));
        this.alerta.add(new Alerta("Alerta nº2", "Média intensidade de chuvas nas últimas 12 horas",
                "Macaxeira", true, 2));
        this.alerta.add(new Alerta("Alerta nº3", "Quantidade de chuva nas últimas 24 horas",
                "Iputinga", true, 1));
        this.alerta.add(new Alerta("Alerta nº4", "Média intensidade de chuvas nas últimas 12 horas",
                "Torrões", true, 2));
        this.alerta.add(new Alerta("Alerta nº5", "Barreiras deslisando devido as chuvas",
                "Alto do Mandu", true, 3));
        this.alerta.add(new Alerta("Alerta nº6", "Quantidade de chuva nas últimas 24 horas",
                "Dois Irmãos", true, 1));
        this.alerta.add(new Alerta("Alerta nº7", "Quantidade de chuva nas últimas 24 horas",
                "Espinheiro", true, 1));
        this.alerta.add(new Alerta("Alerta nº8", "Quantidade de chuva nas últimas 24 horas",
                "Casa Caiada", true, 1));
        this.alerta.add(new Alerta("Alerta nº9", "Média intensidade de chuvas nas últimas 12 horas",
                "Alto da Bondade", true, 2));
        this.alerta.add(new Alerta("Alerta nº10", "Barreiras deslisando devido as chuvas",
                "Vasco da Gama", true, 3));



        return rootView;
    }
}
