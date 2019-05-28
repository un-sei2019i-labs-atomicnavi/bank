package first.program.bank1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user,password,cpass;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.password);
        cpass = (EditText)findViewById(R.id.confirmpass);
        register = (Button)findViewById(R.id.register);
    }
}
