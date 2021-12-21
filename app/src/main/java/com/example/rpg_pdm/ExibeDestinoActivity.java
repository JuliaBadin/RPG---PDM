package com.example.rpg_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ExibeDestinoActivity extends AppCompatActivity {

    TextView tvescolha, tvdescricao;
    ImageView tvfoto;
    String escolha, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_destino);

        tvescolha = findViewById(R.id.escolha);
        tvdescricao = findViewById(R.id.descricao);
        tvfoto = findViewById(R.id.tvfoto);

        Intent intent = getIntent();
        escolha = intent.getStringExtra("escolha");
        descricao = intent.getStringExtra("descricao");

        tvescolha.setText(escolha);
        tvdescricao.setText(descricao);

        if (escolha.equals("Você escolheu ficar e lutar")) {
            tvfoto.setImageResource(R.drawable.ficar);
        }
        if (escolha.equals("Você escolheu o caminho da direita")) {
            tvfoto.setImageResource(R.drawable.direita);
        }
        if (escolha.equals("Você escolheu o caminho da esquerda")) {
            tvfoto.setImageResource(R.drawable.esquerda);
        }

    }
}