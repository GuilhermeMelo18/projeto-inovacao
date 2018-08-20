package com.inovi.allerta.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.inovi.allerta.BD;
import com.inovi.allerta.R;
import com.inovi.allerta.adapter.PublicacaoAdapter;
import com.inovi.allerta.modelos.Area;
import com.inovi.allerta.modelos.Publicacao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisualizarPublicacaoFragment extends Fragment {
    private List<Publicacao> publicacoes;
    private List<Publicacao> publicacoesFiltradas = new ArrayList<>();
    private List<Area> areas;
    private ArrayAdapter<String> adapterArea;

    List<String> nomeAreas = new ArrayList<>();

    private ListView mListPublicacoes;
    private Spinner mSpAreaFiltro;
    private PublicacaoAdapter adapterPubli;


    public VisualizarPublicacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_visualizar_publicacao, container, false);

        publicacoes = BD.publicacoes;
        areas = BD.areas;

        nomeAreas = new ArrayList<>();
        for(Area a: areas){
            nomeAreas.add(a.getNome().trim());
        }

        mSpAreaFiltro = layout.findViewById(R.id.spAreaFiltro);

        adapterArea = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, nomeAreas);
        adapterArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpAreaFiltro.setAdapter(adapterArea);

        mListPublicacoes = layout.findViewById(R.id.listaPubli);
        adapterPubli = new PublicacaoAdapter(publicacoes, getActivity());
        mListPublicacoes.setAdapter(adapterPubli);

        mSpAreaFiltro.setSelection(1);
        mSpAreaFiltro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //tem de passar o nome do lugar
                String regiao = nomeAreas.get(position);
                adapterPubli.getFilter().filter(regiao);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return layout;
    }

}
