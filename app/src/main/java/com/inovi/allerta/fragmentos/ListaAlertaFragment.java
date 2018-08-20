package com.inovi.allerta.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.inovi.allerta.BD;
import com.inovi.allerta.R;
import com.inovi.allerta.RecyclerItemClickListener;
import com.inovi.allerta.activity.DetalheAlertaActivity;
import com.inovi.allerta.adapter.AlertaAdapter;
import com.inovi.allerta.modelos.Alerta;

public class ListaAlertaFragment extends Fragment {
    private View rootView;
    private AlertaAdapter adapter;
    private RecyclerView myRecyclerView;

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

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

        myRecyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getActivity(),
                    myRecyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Alerta alerta = BD.alertas.get(position);

                            DetalheAlertaActivity detalheAlertaActivity = new DetalheAlertaActivity();

                            Intent intent = new Intent(ListaAlertaFragment.this.getContext(), DetalheAlertaActivity.class);
                            intent.putExtra("alerta", alerta.getTitulo());
                            intent.putExtra("grau de risco", alerta.getGrauRisco());
                            intent.putExtra("bairro", alerta.getAreaAlerta());
                            intent.putExtra("informacao", alerta.getInformacao());

                            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

        return rootView;
    }
}
