package com.example.finalprojecttodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tambahLayout extends AppCompatActivity {
    Button tambah;
    Button batal;
    EditText menambah;
    TextView judul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_layout);
        tambah = findViewById(R.id.tambahButtonTambah);
        batal = findViewById(R.id.batalButtonTambah);
        menambah = findViewById(R.id.tambahTodo);
        judul = findViewById(R.id.textView);


        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tambahLayout.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String varTodo = menambah.getText().toString();
                //Mengecek Todolist dengan array default udah penuh
                boolean penuh = true;
                for (int i = 0; i < global.dataTodo.length; i++){
                    if (global.dataTodo[i]== null){
                        // ada yang masih kosong
                        penuh=false;
                        break;
                    }
                }
                //keadaan penuh
                if (penuh){
                    String[] temp = global.dataTodo;
                    global.dataTodo = new String[global.dataTodo.length +1];
                    for (int i = 0; i < temp.length; i++){
                        global.dataTodo[i]= temp[i];
                    }
                }
                //menambah ke yang kosong
                for (int i = 0; i < global.dataTodo.length; i++){
                    if (global.dataTodo[i] == null){
                        global.dataTodo[i]= varTodo;
                        break;
                    }
                }
                Intent intent = new Intent(tambahLayout.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}