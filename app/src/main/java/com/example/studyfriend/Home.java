package com.example.studyfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button buttontambahdata;
    Button buttonlihatdata;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttontambahdata = findViewById(R.id.buttontambahdata);
        buttontambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menujutambahdata = new Intent(Home.this, addmhs.class);
                startActivity(menujutambahdata);
            }
        });

        buttonlihatdata = findViewById(R.id.buttonlihatdata);
        buttonlihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lihatdata = new Intent(Home.this, listmahasiswa.class);
                startActivity(lihatdata);
            }
        });
    }
}