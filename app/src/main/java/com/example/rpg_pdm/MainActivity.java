package com.example.rpg_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinopcoes;
    Button btabrirtela;
    EditText tvnome;
    String escolha, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvnome = findViewById(R.id.nome);
        btabrirtela = findViewById(R.id.abrirtela);
        spinopcoes = (Spinner) findViewById(R.id.opcoes);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.opcoes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinopcoes.setAdapter(adapter);

        btabrirtela.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent telafinal = new Intent(getApplicationContext(), ExibeDestinoActivity.class);

                String item = spinopcoes.getSelectedItem().toString();

                if (item.equals("Ficar e lutar")){
                    escolha = "Você escolheu ficar e lutar";
                    descricao = tvnome.getText().toString() + " escolheu enfrentar o seu destino e encarar o terrível monstro. " + tvnome.getText().toString() + " se escondeu atrás de uma grande rocha e ficou na espreita, esperando o monstro chegar para o atacar de surpresa. Após alguns segundos, uma criatura enorme surgiu no corredor. Era uma das criaturas mais abomináveis que " + tvnome.getText().toString() + " já tinha visto. Seu corpo era humanóide, mas devia ter no mínimo uns 4 metros de altura. Sua cabeça era apenas um crânio com olhos totalmente negros. Mesmo com medo, " + tvnome.getText().toString() + " não desistiu. " + tvnome.getText().toString() + " brandiu sua espada e correu em direção à criatura.";
                } else if (item.equals("Caminho da direita")){
                    escolha  = "Você escolheu o caminho da direita";
                    descricao =  tvnome.getText().toString() + " correu como nunca antes havia corrido. " + tvnome.getText().toString() + " entrou no caminho que parecia ser mais perto do fim: o da direita. Quando estava na metade do caminho, olhou para trás e viu o monstro surgindo na abertura. Mas " +  tvnome.getText().toString() + " estava a salvo, o caminho era estreito demais para a grande criatura. Seguindo em frente, " +  tvnome.getText().toString() + " surgiu em uma clareira. Para a sua surpresa, havia outros sobreviventes ali. Todos esperando o momento certo para enfrentarem o monstro e fugirem, mas nunca tendo coragem para tal ato. " +  tvnome.getText().toString() + " precisa tomar a liderança e unir o grupo para juntos saírem dali.";
                } else if (item.equals("Caminho da esquerda")){
                    escolha = "Você escolheu o caminho da esquerda";
                    descricao =  tvnome.getText().toString() + " entrou no caminho mais próximo. Correu como nunca antes em sua vida, e, ao chegar ao fim, se deparou com um campo aberto, onde era possível avistar um pequeno vilarejo no horizonte. " +  tvnome.getText().toString() + " estava a salvo.";
                }


                if(TextUtils.isEmpty(tvnome.getText())){
                    tvnome.setError("Digite seu nome");
                } else {
                    telafinal.putExtra("escolha", escolha);
                    telafinal.putExtra("descricao", descricao);

                   startActivity(telafinal);
                }

            }
        });
    }
}