package com.example.studyfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class listmahasiswa extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseHandler db;
    private List<modalMahasiswa> ListMahasiswa = new ArrayList<modalMahasiswa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmahasiswa);

        db = new DatabaseHandler(this);

        adapter_off = new CustomListAdapter(this, ListMahasiswa);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        mListView.setClickable(true);
        ListMahasiswa.clear();

        List<modalMahasiswa> contacts = db.ReadMahasiswa();
        for (modalMahasiswa cn : contacts) {
            modalMahasiswa judulModel = new modalMahasiswa();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_nim(cn.get_nim());
            judulModel.set_jurusan(cn.get_jurusan());
            ListMahasiswa.add(judulModel);

            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(listmahasiswa.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        modalMahasiswa obj_itemDetails = (modalMahasiswa) o;

        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Snim = obj_itemDetails.get_nim();
        String Sjurusan = obj_itemDetails.get_jurusan();

        Intent goUpdel = new Intent(listmahasiswa.this, profil.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Inim", Snim);
        goUpdel.putExtra("Ijurusan", Sjurusan);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListMahasiswa.clear();
        mListView.setAdapter(adapter_off);

        List<modalMahasiswa> contacts = db.ReadMahasiswa();
        for (modalMahasiswa cn : contacts) {
            modalMahasiswa judulModel = new modalMahasiswa();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_nim(cn.get_nim());
            judulModel.set_jurusan(cn.get_jurusan());
            ListMahasiswa.add(judulModel);

            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(listmahasiswa.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }

    }
}