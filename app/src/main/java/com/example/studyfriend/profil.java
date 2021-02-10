package com.example.studyfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profil extends AppCompatActivity {
    private DatabaseHandler db;
    private String Sid, Snama, Snim, Sjurusan;
    private EditText Enama, Enim, Ejurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        db = new DatabaseHandler(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Snim = i.getStringExtra("Inim");
        Sjurusan = i.getStringExtra("Ijurusan");


        Enama = (EditText) findViewById(R.id.updel_nama);
        Enim = (EditText) findViewById(R.id.updel_nim);
        Ejurusan = (EditText) findViewById(R.id.updel_jurusan);

        Enama.setText(Snama);
        Enim.setText(Snim);
        Ejurusan.setText(Sjurusan);


        Button btnUpdate = (Button) findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Snim = String.valueOf(Enim.getText());
                Sjurusan = String.valueOf(Ejurusan.getText());
                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(profil.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Snim.equals("")) {
                    Enim.requestFocus();
                    Toast.makeText(profil.this, "Silahkan isi nim", Toast.LENGTH_SHORT).show();
                } else if (Sjurusan.equals("")) {
                    Ejurusan.requestFocus();
                    Toast.makeText(profil.this, "Silahkan isi jurusan", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new modalMahasiswa(Sid, Snama, Snim, Sjurusan));
                    Toast.makeText(profil.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new modalMahasiswa(Sid, Snama, Snim, Sjurusan));
                Toast.makeText(profil.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}