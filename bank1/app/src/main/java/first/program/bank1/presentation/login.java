package first.program.bank1.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

import first.program.bank1.R;
import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.repositories.AccountRepository;

public class login extends AppCompatActivity {

    EditText Username,Password;
    Button login;
    Database db;
    AccountRepository dbq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Database(this);
        Password = (EditText)findViewById(R.id.password2);
        Username = (EditText)findViewById(R.id.userName);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int username = Integer.parseInt(Username.getText().toString());
                int password = Integer.parseInt(Password.getText().toString());
                Boolean chkpass = null;
                    chkpass = dbq.Chkpss(username,password);
                if(chkpass){
                    Toast.makeText(getApplicationContext(),"Login exitoso,",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(), s.class);
                    startActivity(i);
                    dbq.setUA(username);
                }else{
                    Toast.makeText(getApplicationContext(),"fallo del sistema corrija nombre de usuario o contrasena",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
