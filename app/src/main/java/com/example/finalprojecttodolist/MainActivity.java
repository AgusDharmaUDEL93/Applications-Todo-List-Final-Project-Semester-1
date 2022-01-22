package com.example.finalprojecttodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

class global{
    public static String dataTodo[] = new String[1];
}

public class MainActivity extends AppCompatActivity {
    Button tambah;
    Button hapus;
    ListView todolist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tambah = findViewById(R.id.tambahBtn);
        hapus = findViewById(R.id.hapusBtn);
        todolist = findViewById(R.id.ListTodo);

        if (global.dataTodo[0]!= null){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, global.dataTodo);
            todolist.setAdapter(adapter);
        }

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah1 = new Intent(MainActivity.this, tambahLayout.class);

                startActivity(pindah1);
                finish();
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pindah2 = new Intent(MainActivity.this, hapusLayout.class);
                startActivity(pindah2);
                finish();
            }
        });





    }
}