package com.inovi.allerta.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inovi.allerta.BD;
import com.inovi.allerta.R;
import com.inovi.allerta.adapter.AlertaAdapter;

public class ListaAlertaFragment extends Fragment {
    private View rootView;
    private AlertaAdapter adapter;
    private RecyclerView myRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.rootView = inflater.inflate(R.layout.lista, container, false);

        this.myRecyclerView = this.rootView.findViewById(R.id.recyclerViewLista);

        this.adapter = new AlertaAdapter(getActivity(), BD.alertas);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter( adapter );

        return rootView;
    }
}
