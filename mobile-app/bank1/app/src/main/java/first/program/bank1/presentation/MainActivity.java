package first.program.bank1.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import first.program.bank1.R;
import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.models.User;
import first.program.bank1.data_Acces.repositories.AccountRepository;

public class MainActivity extends AppCompatActivity {

    Database db;
    AccountRepository dbq;
    EditText user,password,cpass,id;
    Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this);
        user=(EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.password);
        cpass = (EditText)findViewById(R.id.confirmpass);
        id=(EditText)findViewById(R.id.id);
        register = (Button)findViewById(R.id.register);
        login =(Button)findViewById(R.id.login1);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg1 =   user.getText().toString();
                int reg2 = Integer.parseInt(password.getText().toString());
                int reg3 = Integer.parseInt(cpass.getText().toString());
                int reg4 = Integer.parseInt(id.getText().toString());

                if(reg1.equals("")||reg2==0||reg3==0){
                    Toast.makeText(getApplicationContext(),"espacios estan vacios",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(reg2==reg3){
                        boolean checkuser = dbq.ChkUser(reg4);
                        if(!checkuser){
                            Random rnd = new Random();
                            int acc = rnd.nextInt( 10000000);
                            while(dbq.chkAc(acc)){
                                acc++;
                            }
                            User ui = new User(reg1,reg4,reg2,acc);
                            boolean insert = dbq.createUser(ui,0);
                            if(insert){
                                Toast.makeText(getApplicationContext(),"registro exitoso",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this, first.program.bank1.presentation.login.class);
                                startActivity(i);

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
