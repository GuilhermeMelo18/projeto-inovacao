package com.inovi.allerta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.inovi.allerta.MainActivity;
import com.inovi.allerta.R;
import com.inovi.allerta.fragmentos.ListaAlertaFragment;


public class LoginActivity extends AppCompatActivity{
    private Button entrar;
    private EditText login;
    private EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        entrar = findViewById(R.id.btnEntrar);
        login = findViewById(R.id.username);
        senha = findViewById(R.id.password);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login.getText().toString().equals("apac") && senha.getText().toString().equals("123")){
                    Intent i = new Intent(LoginActivity.this, APACPublicarActivity.class);
                    startActivity(i);
                    finish();
                }else if(login.getText().toString().equals("defesa") && senha.getText().toString().equals("123")){
                    Intent i = new Intent(LoginActivity.this, DefesaCivilActivity.class);
                    startActivity(i);
                    finish();

                }else if (login.getText().toString().equals("externo") && senha.getText().toString().equals("123")){
                    //Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    Intent i = new Intent(LoginActivity.this, DefesaCivilActivity.class);
                    startActivity(i);
                    finish();

                }else {
                    Toast.makeText(LoginActivity.this, "Login Inválido", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}
