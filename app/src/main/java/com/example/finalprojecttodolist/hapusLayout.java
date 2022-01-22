package com.example.finalprojecttodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class hapusLayout extends AppCompatActivity {
    Button hapus;
    Button batal;
    EditText menghapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_layout);
        hapus = findViewById(R.id.hapusButtonHapus);
        batal = findViewById(R.id.batalButtonHapus);
        menghapus = findViewById(R.id.hapusTodo);

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hapusLayout.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nomorData = Integer.parseInt(String.valueOf(menghapus.getText()));
                if ((nomorData-1) >= global.dataTodo.length){
                    //menghapus todo list yang panjangnya lebih besar dari array nya
                    Toast.makeText(getApplicationContext(), "Maaf permintaan anda gagal", Toast.LENGTH_LONG).show();
                } else if (global.dataTodo[(nomorData-1)]==null) {
                    //menghapus todo list yang kosong
                    Toast.makeText(getApplicationContext(), "Maaf permintaan anda gagal", Toast.LENGTH_LONG).show();
                } else if (global.dataTodo.length==1){
                    //menghapus array supaya panjang array tidak 0
                    global.dataTodo[0]= null;
                } else {
                    for (int i = (nomorData-1); i < global.dataTodo.length ;i++){
                        if (i == (global.dataTodo.length-1)){
                            //logic ketika data yang paling ujung di hapus,
                            // supaya index pergeserannya ndak kelebihan dari jumlah array
                            global.dataTodo[i]=null;
                            String[] temp = global.dataTodo;
                            global.dataTodo = new String[global.dataTodo.length-1];
                            for (int j = 0; j < global.dataTodo.length; j++){
                                global.dataTodo[j]= temp[j];
                            }
                        }else{
                            //menggeser data todolis
                            global.dataTodo[i]=global.dataTodo[i+1];
                            String[] temp = global.dataTodo;
                            global.dataTodo = new String[global.dataTodo.length-1];
                            for (int j = 0; j < global.dataTodo.length; j++){
                                global.dataTodo[j]= temp[j];
                            }
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Data berhasil dihapus", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(hapusLayout.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}