package com.inovi.allerta.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.inovi.allerta.R;
import com.inovi.allerta.modelos.Publicacao;

import java.util.List;

public class PublicacaoAdapter extends BaseAdapter {
        private List<Publicacao> publicacoes;
        private final Activity act;

        public PublicacaoAdapter(List<Publicacao> publicacoes, Activity act) {
            this.publicacoes = publicacoes;
            this.act = act;
        }

        @Override
        public int getCount() {
            return publicacoes.size();
        }

        @Override
        public Object getItem(int position) {
            return publicacoes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = act.getLayoutInflater().inflate(R.layout.adapter_publicacao, parent, false);
        final Publicacao pub = publicacoes.get(position);

        TextView txtPubli = layout.findViewById(R.id.txtConteudoPubli);
        ImageView imgPubli = layout.findViewById(R.id.imgPubli);

        txtPubli.setText(pub.getTexto());
        if (pub.getImagem() != null){
            imgPubli.setImageBitmap(pub.getImagem());
        } else {
            imgPubli.setVisibility(View.GONE);
        }

        return layout;
     }

}
