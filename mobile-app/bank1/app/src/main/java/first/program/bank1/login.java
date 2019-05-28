package first.program.bank1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText Username,Password;
    Button login;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new database(this);
        Password = (EditText)findViewById(R.id.password2);
        Username = (EditText)findViewById(R.id.userName);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                Boolean chkpass = db.chckpass(username,password);
                if(chkpass){
                    //Toast.makeText(getApplicationContext(),"Login exitoso,",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(login.this, maestros.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"fallo del sistema el sistema se autodestruira en 15 segundos camilo es una hueva",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
