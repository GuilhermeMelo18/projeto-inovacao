package com.inovi.allerta.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inovi.allerta.R;
import com.inovi.allerta.modelos.Alerta;

import java.util.List;

public class AlertasAdapter extends RecyclerView.Adapter<AlertasAdapter.MyViewHolder> {

    private List<Alerta> alertas;

    public AlertasAdapter(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView grauDeRisco;
        TextView informacao;
        TextView area;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTitulo);
            grauDeRisco = itemView.findViewById(R.id.grauDeRisco);
            informacao = itemView.findViewById(R.id.txtInformacao);
            area = itemView.findViewById(R.id.bairro);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_alerta, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Alerta alerta = alertas.get(position);
        holder.titulo.setText(alerta.getTitulo());
        holder.informacao.setText(alerta.getInformacao());
        holder.area.setText(alerta.getAreaAlerta());
        holder.grauDeRisco.setText(alerta.getGrauRisco());

    }

    @Override
    public int getItemCount() {
        return alertas.size();
    }
}
