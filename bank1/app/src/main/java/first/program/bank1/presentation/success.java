package first.program.bank1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import first.program.bank1.R;

public class success extends AppCompatActivity {
    Button success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        success = (Button)findViewById(R.id.p);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), s.class);
                startActivity(i);
            }
        });
    }
}
