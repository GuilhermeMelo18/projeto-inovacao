package com.inovi.allerta.fragmentos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inovi.allerta.R;
import com.inovi.allerta.Utils;

import java.io.IOException;


public class PublicacaoFragment extends Fragment {
    private TextView mTxtPergunta;
    private EditText mEdtPublicacao;
    private TextView mTxtContadorChar;
    private TextView mTxtAnexar;
    private Button mBtnEnviar;

    final int SELECT_IMAGE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_publicar, container, false);
        getActivity().setTitle(R.string.titulo_publicacao);

        mTxtPergunta = layout.findViewById(R.id.txtPerguntaPublicacao);
        mEdtPublicacao = layout.findViewById(R.id.edtxtAreaPublicacao);
        mTxtAnexar = layout.findViewById(R.id.txtAnexar);
        mBtnEnviar = layout.findViewById(R.id.btnEnviar);
        mTxtContadorChar = layout.findViewById(R.id.txtContadorCaractere);

        mTxtAnexar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);//
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);
            }
        });

        mEdtPublicacao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTxtContadorChar.setText(String.valueOf(s.length()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBtnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mess", mEdtPublicacao.getEditableText().toString());
                if(mEdtPublicacao.getEditableText().toString() == null){
                    Toast.makeText(getActivity(), R.string.sem_info, Toast.LENGTH_SHORT).show();
                } else if(mEdtPublicacao.getEditableText().toString().length() < Utils.TAMANHO_MINIMO_PUBLICACAO) {
                    String texto = getResources().getString(R.string.pouca_info) + "\n" + getResources().getString(R.string.no_minimo)
                            + String.valueOf(Utils.TAMANHO_MINIMO_PUBLICACAO) + " " +
                            getResources().getString(R.string.caracteres);
                    Toast.makeText(getActivity(), texto, Toast.LENGTH_LONG).show();
                }
            }
        });

        return layout;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                if (data != null)
                {
                    try
                    {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)
            {
                Toast.makeText(getActivity(), R.string.cancelado, Toast.LENGTH_SHORT).show();
            }
        }
    }


}
