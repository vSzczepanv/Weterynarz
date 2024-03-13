package com.example.weterynarz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText imieinazwisko=findViewById(R.id.imieinazwisko);
        ListView listagatunki=findViewById(R.id.listagatunki);
        TextView latalicznik=findViewById(R.id.latalicznik);
        SeekBar lata=findViewById(R.id.lata);
        EditText powod=findViewById(R.id.powod);
        EditText godzina=findViewById(R.id.godzina);
        Button ok=findViewById(R.id.zatwierdzenie);
        final String[] gatunek = {""};

        listagatunki.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    lata.setMax(18);
                }
                else if(position==1){
                    lata.setMax(20);
                }
                else if(position==2){
                    lata.setMax(9);
                }
                gatunek[0] =String.valueOf(listagatunki.getItemAtPosition(position));
            }
        });

        lata.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                latalicznik.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Zapisana Wizyta");
                alertDialogBuilder.setMessage(imieinazwisko.getText()+", "+ gatunek[0]+", "+latalicznik.getText().toString()+", "+powod.getText().toString()+", "+godzina.getText().toString());
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}