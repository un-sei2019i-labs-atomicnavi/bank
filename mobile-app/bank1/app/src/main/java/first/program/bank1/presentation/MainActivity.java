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

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText user,password,cpass;
    Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this);
        user=(EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.password);
        cpass = (EditText)findViewById(R.id.confirmpass);
        register = (Button)findViewById(R.id.register);
        login =(Button)findViewById(R.id.login1);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg1 =   user.getText().toString();
                String reg2 = password.getText().toString();
                String reg3 = cpass.getText().toString();
                if(reg1.equals("")||reg2.equals("")||reg3.equals("")){
                    Toast.makeText(getApplicationContext(),"espacios estan vacios",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(reg2.equals(reg3)){
                        boolean checkuser = db.chckuser(reg1);
                        if(checkuser){
                            boolean insert = db.insert(reg1,reg2);
                            if(insert){
                                Toast.makeText(getApplicationContext(),"registro exitoso",Toast.LENGTH_SHORT).show();

                            }
                        }else{
                            Toast.makeText(getApplicationContext(),"usuario ya existe",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "contrasenas no conciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, first.program.bank1.presentation.login.class);
                startActivity(i);
            }
        });
    }
}
