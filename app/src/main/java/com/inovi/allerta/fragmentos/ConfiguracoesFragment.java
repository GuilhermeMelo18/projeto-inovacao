package com.inovi.allerta.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.inovi.allerta.BD;
import com.inovi.allerta.R;
import com.inovi.allerta.Utils;
import com.inovi.allerta.modelos.Area;
import com.inovi.allerta.modelos.Populacao;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracoesFragment extends Fragment {
    private TextView mTxtAreaMorando;
    private TextView mTxtAlterarSenha;
    private Spinner mSpAreaMorando;
    private Switch mStchNotificacoes;
    private EditText mEdtxtSenha;
    private EditText mEdtxtSenhaConfirmacao;
    private Button mbtnEnviar;

    Populacao pop;
    List<Area> areas;
    List<String> nomeAreas;

    ArrayAdapter<String> adapter;

    public ConfiguracoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        pop = BD.pop;
        areas = BD.areas;

        nomeAreas = new ArrayList<>();
        for(Area a: areas){
            nomeAreas.add(a.getNome().trim());
        }

        View layout = inflater.inflate(R.layout.fragment_configuracoes, container, false);

        mTxtAreaMorando = layout.findViewById(R.id.txtAreaMorando);
        mTxtAlterarSenha = layout.findViewById(R.id.txtAlterarSenha);
        mSpAreaMorando = layout.findViewById(R.id.spArea);
        mStchNotificacoes = layout.findViewById(R.id.stchNotificaoes);
        mEdtxtSenha = layout.findViewById(R.id.edtxtSenha);
        mEdtxtSenhaConfirmacao = layout.findViewById(R.id.edtxtSenhaConfirmacao);
        mbtnEnviar = layout.findViewById(R.id.btnAlterar);

        mbtnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean foiAlterado = false;
                boolean foiNotificado = false;

                if (mEdtxtSenhaConfirmacao.getText() != null && mEdtxtSenha.getText() != null){
                    String senha = mEdtxtSenha.getText().toString();
                    String senhaConfirmacao = mEdtxtSenhaConfirmacao.getText().toString();
                        if (senha.length() >= Utils.TAMANHO_MINIMO_SENHA)
                        {
                            if (senha.equals(senhaConfirmacao)){
                                if (mEdtxtSenha.getText().toString().equals(pop.getSenha())) {
                                    foiNotificado = true;
                                    Toast.makeText(getActivity(), R.string.senha_ja_e_sua,
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    pop.setSenha(senha);
                                    mEdtxtSenha.setText("");
                                    mEdtxtSenhaConfirmacao.setText("");
                                    foiAlterado = true;
                                }
                            } else if (!foiNotificado){
                                foiNotificado = true;
                                Toast.makeText(getActivity(), R.string.senha_diferente,
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else if (!senha.equals("") && !foiNotificado){
                            foiNotificado = true;
                            Toast.makeText(getActivity(), R.string.senha_pequena,
                                    Toast.LENGTH_SHORT).show();
                        }
                }

                if (mStchNotificacoes.isChecked() != pop.isReceberNotificacoes()){
                    pop.setReceberNotificacoes(mStchNotificacoes.isChecked());
                    foiAlterado = true;
                }

                if (!mSpAreaMorando.getSelectedItem().toString().contains(pop.getArea().getNome())){
                    pop.setArea((Area) areas.get(mSpAreaMorando.getSelectedItemPosition()));
                    foiAlterado = true;
                }

                if (foiAlterado){
                    Toast.makeText(getActivity(), R.string.alteracoes_aplicadas,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), R.string.nada_alterado,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, nomeAreas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpAreaMorando.setAdapter(adapter);

        mSpAreaMorando.setSelection(pop.getArea().getCodigo() - 1);

        mStchNotificacoes.setChecked(pop.isReceberNotificacoes());

        mStchNotificacoes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mSpAreaMorando.setEnabled(true);
                    Toast.makeText(getActivity(), R.string.notificacoes_ativadas,
                            Toast.LENGTH_SHORT).show();
                } else {
                    mSpAreaMorando.setEnabled(false);
                    Toast.makeText(getActivity(), R.string.notificacoes_desativadas,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return layout;
    }

}
