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
        getActivity().setTitle(R.string.alertas);

        this.alerta = new ArrayList<>();
        this.alerta.add(new Alerta("Alerta nº1", "Quantidade de chuva nas últimas 24 horas",
                "Vasco da Gama", true, 2));

        return rootView;
    }
}
