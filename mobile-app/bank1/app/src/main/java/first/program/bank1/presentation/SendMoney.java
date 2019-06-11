package first.program.bank1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import first.program.bank1.R;
import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.repositories.AccountRepository;

public class SendMoney extends AppCompatActivity {
    EditText Cud,Amm;
    Database db;
    Button send;
    AccountRepository dbq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money);
        db = new Database(this);
        Cud = (EditText)findViewById(R.id.cud);
        Amm=(EditText)findViewById(R.id.Amm);
        send = (Button)findViewById(R.id.register);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int reg2 = Integer.parseInt(Cud.getText().toString());
                int reg3 = Integer.parseInt(Amm.getText().toString());
                if (dbq.createTransaction(reg2,dbq.getUA(),reg3)){
                    Toast.makeText(getApplicationContext(),"transaccion exitosa ",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(), s.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Fallo transaccion",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
