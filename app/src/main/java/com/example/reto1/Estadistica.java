package com.example.reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Estadistica extends AppCompatActivity {

    private EditText Nota1, Nota2, Nota3, Nota4;
    private TextView tvPromedio,tvMayor,tvMenor;
    private int nota1,nota2,nota3,nota4;
    //private boolean ent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        Nota1 = findViewById(R.id.txtNota1);
        Nota2 = findViewById(R.id.txtNota2);
        Nota3 = findViewById(R.id.txtNota3);
        Nota4 = findViewById(R.id.txtNota4);
        tvPromedio = findViewById(R.id.tvPromedio);
        tvMayor = findViewById(R.id.tvMayor);
        tvMenor = findViewById(R.id.tvMenor);
    }
    private boolean Valores(){
        nota1 = Integer.parseInt(Nota1.getText().toString());
        nota2 = Integer.parseInt(Nota2.getText().toString());
        nota3 = Integer.parseInt(Nota3.getText().toString());
        nota4 = Integer.parseInt(Nota4.getText().toString());
        int list[] = {nota1,nota2,nota3,nota4};
        boolean ent;
        int may = nota1;
        int men = 11;
        for (int i = 0; i < list.length; i++){
            if ( list[ i ] > may){
                may = list[ i ];
            }
            if ( list[ i ] < men){
                men = list[ i ];
            }
        }
        tvMayor.setText(String.valueOf(may));
        tvMenor.setText(String.valueOf(men));
        if(men>=0 && may<=10) ent = true;
        else {
            ent = false;
            Toast.makeText(this, "Entradas incorrectas", Toast.LENGTH_SHORT).show();
        }
        //tvPromedio.setText(String.valueOf(ent));
        return ent;
    }
    public void Prom(View view){
        //boolean rev = Boolean.parseBoolean(Integer.toString(Valores()));
        //if(rev==true){
        if(Valores()){
            double prom = (double) (nota1+nota2+nota3+nota4)/4;
            if(prom>=6){
                tvPromedio.setText("Aprovado con " + prom);
                Toast.makeText(this, "Felicitaciones", Toast.LENGTH_SHORT).show();
            }else{
                tvPromedio.setText ("Reprobado con " + prom);
                Toast.makeText(this, "Siga estudiando", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Mayor(View view) {
        if(Valores()){
            tvMayor.setVisibility(View.VISIBLE);
        }
    }
    public void Men(View view){
        if(Valores()){
            tvMenor.setVisibility(View.VISIBLE);
        }
    }

}