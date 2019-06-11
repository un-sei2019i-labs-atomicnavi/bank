package first.program.bank1.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import first.program.bank1.R;
import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.models.User;
import first.program.bank1.data_Acces.repositories.AccountRepository;

public class s extends AppCompatActivity {

    AccountRepository dbq;
    Database db;
    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);
        db = new Database(this);
        cargar();
        enviar =(Button)findViewById(R.id.ss);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SendMoney.class);
                startActivity(i);
            }
        });

    }
    private void cargar(){

        String Arreglo[]=dbq.SA();

        ArrayAdapter<User> adapter = new ArrayAdapter(this, R.layout.send_money, Arreglo);
        ListView list=(ListView) findViewById(R.id.list_1);
        list.setAdapter(adapter);
    }

}
