package com.inovi.allerta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inovi.allerta.R;

public class DetalheAlertaActivity extends AppCompatActivity {

    private TextView txtAlerta;
    private TextView grauDeRisco;
    private TextView bairro;
    private TextView txtInformacao;
    private Button btnEnviar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_alerta);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detalhe Alerta");
        Intent intent = getIntent();

        String tituloAlerta = (String) intent.getSerializableExtra("alerta");
        int tituloGrauDeRisco = (int) intent.getSerializableExtra("grau de risco");
        String tituloBairro = (String) intent.getSerializableExtra("bairro");
        String tituloInformacao = (String) intent.getSerializableExtra("informacao");

        txtAlerta = findViewById(R.id.txtAlerta);
        grauDeRisco = findViewById(R.id.GrauDeRisco);
        bairro = findViewById(R.id.Bairro);
        txtInformacao = findViewById(R.id.txtInformacao);
        btnEnviar = findViewById(R.id.btnEnviar);

        txtAlerta.setText(tituloAlerta);
        grauDeRisco.setText(""+tituloGrauDeRisco);
        bairro.setText(tituloBairro);
        txtInformacao.setText(tituloInformacao);

        btnEnviar.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v){
                        Toast.makeText(getApplicationContext(), "Dados do alerta enviados a população!", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
