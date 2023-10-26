package com.example.reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;
public class Estadistica extends AppCompatActivity {

    String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    String [] arraycategorias ={"Vidrio","Plastico","Papel"};
    List<TipoMaterial> tipoMaterials = new ArrayList<TipoMaterial>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String prueba=intent.getStringExtra("mensaje");
        Log.d("Reto1","prueba  = "+prueba);
        for (int i=0;i<arraycategorias.length;i++){
           TipoMaterial aux= new TipoMaterial(arraycategorias[i]);
           if(prueba.equals(arraycategorias[i]))
           {aux.setActivo(true);}
            Log.d("Reto1","activo  = "+aux.isActivo());
           tipoMaterials.add(aux);
        }
        setContentView(R.layout.activity_estadistica);
    }


}