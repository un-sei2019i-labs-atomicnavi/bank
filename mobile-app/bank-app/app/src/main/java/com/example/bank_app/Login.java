package com.example.bank_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText e1,e2;
Button b1;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = e1.getText().toString();
                String password = e2.getText().toString();
                boolean chkusuariopass = db.usuariopassword(usuario,password);
                if(chkusuariopass==true){
                    Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this,pantalla1.class);
                startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrectos",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
