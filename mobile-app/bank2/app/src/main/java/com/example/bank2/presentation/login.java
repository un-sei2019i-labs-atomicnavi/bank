package first.program.bank1.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import first.program.bank1.R;
import first.program.bank1.data_Acces.database.Database;

public class login extends AppCompatActivity {

    EditText Username,Password;
    Button login;
    Database db;

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
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                Boolean chkpass = db.getUserDAO(username,password).;
                if(chkpass){
                    //Toast.makeText(getApplicationContext(),"Login exitoso,",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(), s.class);
                    startActivity(i);


                }else{
                    Toast.makeText(getApplicationContext(),"fallo del sistema el sistema se autodestruira en 15 segundos camilo es una hueva",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
