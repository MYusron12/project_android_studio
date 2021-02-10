package com.example.studyfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText etloginusername, etloginpassword;
    Button buttonlogin;

    String username = "admin";
    String password = "admin";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etloginusername = findViewById(R.id.etloginusername);
        etloginpassword = findViewById(R.id.etloginpassword);
        buttonlogin = findViewById(R.id.buttonlogin);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = etloginusername.getText().toString();
                String inputPassword = etloginpassword.getText().toString();

                //Cek Login
                //Jika keduanya salah
                if (!inputUsername.equals(username) && !inputPassword.equals(password)) {
                    Toast.makeText(getApplicationContext(), "Username dan Password Salah!!", Toast.LENGTH_SHORT).show();
                }

                //Jika salah satu salah
                else if (!inputUsername.equals(username) || !inputPassword.equals(password)) {
                    Toast.makeText(getApplicationContext(), "Username dan Password Salah!!", Toast.LENGTH_SHORT).show();
                }

                //Jika Keduanya Benar
                else {
                    etloginusername.setText("");
                    etloginpassword.setText("");
                    startActivity(new Intent(getApplicationContext(), Home.class));
                }
            }
        });
    }
}