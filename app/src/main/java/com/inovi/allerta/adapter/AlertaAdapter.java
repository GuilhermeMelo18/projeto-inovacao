package com.inovi.allerta.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inovi.allerta.R;
import com.inovi.allerta.modelos.Alerta;

import java.util.List;

public class AlertaAdapter extends RecyclerView.Adapter<AlertaAdapter.MyViewHolder> {

    private final List<Alerta> alertas;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public AlertaAdapter(Context context, List<Alerta> alertas) {
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.alertas = alertas;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView grauDeRisco;
        TextView informacao;
        TextView area;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTitulo);
            grauDeRisco = itemView.findViewById(R.id.grauDeRisco);
            informacao = itemView.findViewById(R.id.txtInformacao);
            area = itemView.findViewById(R.id.bairro);
            cardView = itemView.findViewById(R.id.cardView);

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
        holder.grauDeRisco.setText(""+alerta.getGrauRisco());

        if (alerta.getGrauRisco() == 3) {
            holder.cardView.setBackgroundColor(0xffcc0000);
        } else if(alerta.getGrauRisco() == 2) {
            holder.cardView.setBackgroundColor(0xffffbb33);
        } else {
            holder.cardView.setBackgroundColor(0xff669900);
        }

    }

    @Override
    public int getItemCount() {
        return alertas.size();
    }
}
