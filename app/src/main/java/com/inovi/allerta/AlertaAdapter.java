package com.inovi.allerta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inovi.allerta.modelos.Alerta;

import java.util.ArrayList;
import java.util.List;

public class AlertaAdapter extends RecyclerView.Adapter<AlertaAdapter.MyViewHolder> {
    private final List<Alerta> mAlerta;
    private ArrayList<Alerta> arraylist;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public AlertaAdapter(Context context, List<Alerta> mAlerta) {
        this.mAlerta = mAlerta;
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arraylist = new ArrayList<Alerta>();
        this.arraylist.addAll(this.mAlerta);
    }

    public void reload(){
        this.arraylist = new ArrayList<Alerta>();
        this.arraylist.addAll(this.mAlerta);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) { // criar uma nova view so quando for necessário
        View v = mLayoutInflater.inflate(R.layout.adapter_alerta, viewGroup,false);
        //Criar nosso viewHolder
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//vincula os dados da lista a view
        Alerta alerta = mAlerta.get(position);
        holder.txtTitulo.setText(mAlerta.get(position).getTitulo());
        holder.grauDeRisco.setText(mAlerta.get(position).getGrauRisco());
        holder.txtInformacao.setText(mAlerta.get(position).getInformacao());
        holder.bairro.setText(mAlerta.get(position).getAreaAlerta());
        if(position==mAlerta.size()-1){
            //holder.line.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return mAlerta.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtTitulo;
        public TextView grauDeRisco;
        public TextView txtInformacao;
        public TextView bairro;

        public MyViewHolder(View itemView){
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            grauDeRisco = itemView.findViewById(R.id.grauDeRisco);
            txtInformacao = itemView.findViewById(R.id.txtInformacao);
            bairro = itemView.findViewById(R.id.bairro);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(view,getPosition());
            }
        }
    }
}
