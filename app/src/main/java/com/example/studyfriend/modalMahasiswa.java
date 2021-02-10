package com.example.studyfriend;

public class modalMahasiswa {
    private String _id, _nama, _nim, _jurusan;

    public modalMahasiswa(String id, String nama, String nim, String jurusan) {
        this._id = id;
        this._nama = nama;
        this._nim = nim;
        this._jurusan = jurusan;
    }

    public modalMahasiswa() {

    }

    public void set_id(String id) {
        this._id = id;
    }

    public String get_id() {
        return this._id;
    }

    public void set_nama(String nama) {
        this._nama = nama;
    }

    public String get_nama() {
        return this._nama;
    }

    public void set_nim(String nim) {
        this._nim = nim;
    }

    public String get_nim() {
        return this._nim;
    }

    public void set_jurusan(String jurusan) {
        this._jurusan = jurusan;
    }

    public String get_jurusan() {
        return this._jurusan;
    }
}