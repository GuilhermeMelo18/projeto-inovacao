package com.inovi.allerta.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.inovi.allerta.AlertaAdapter;
import com.inovi.allerta.R;
import com.inovi.allerta.RecyclerViewOnClickListenerHack;
import com.inovi.allerta.adapter.AlertasAdapter;
import com.inovi.allerta.modelos.Alerta;

import java.util.ArrayList;
import java.util.List;

public class ListaAlertaFragment extends Fragment {
    private View rootView;
    private List<Alerta> alerta;
    private AlertasAdapter adapter;
    private RecyclerView myRecyclerView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.lista, container, false);

        this.alerta = new ArrayList<>();

        this.alerta.add(new Alerta("Alerta nº1", "Alta intensidade de chuvas nas últimas 6 horas",
                "Casa Amarela",  "3"));
        this.alerta.add(new Alerta("Alerta nº2", "Média intensidade de chuvas nas últimas 12 horas",
                "Macaxeira",  "2"));
        this.alerta.add(new Alerta("Alerta nº3", "Quantidade de chuva nas últimas 24 horas",
                "Iputinga",  "1"));
        this.alerta.add(new Alerta("Alerta nº4", "Média intensidade de chuvas nas últimas 12 horas",
                "Torrões",  "2"));
        this.alerta.add(new Alerta("Alerta nº5", "Barreiras deslisando devido as chuvas",
                "Alto do Mandu",  "3"));
        this.alerta.add(new Alerta("Alerta nº6", "Quantidade de chuva nas últimas 24 horas",
                "Dois Irmãos",  "1"));
        this.alerta.add(new Alerta("Alerta nº7", "Quantidade de chuva nas últimas 24 horas",
                "Espinheiro",  "1"));
        this.alerta.add(new Alerta("Alerta nº8", "Quantidade de chuva nas últimas 24 horas",
                "Casa Caiada",  "1"));
        this.alerta.add(new Alerta("Alerta nº9", "Média intensidade de chuvas nas últimas 12 horas",
                "Alto da Bondade", "2"));
        this.alerta.add(new Alerta("Alerta nº10", "Barreiras deslisando devido as chuvas",
                "Vasco da Gama", "3"));

        myRecyclerView = rootView.findViewById(R.id.lista);

        //Configurar adapter
        this.adapter = new AlertasAdapter (this.alerta);

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter( adapter );

        return rootView;
    }
}
