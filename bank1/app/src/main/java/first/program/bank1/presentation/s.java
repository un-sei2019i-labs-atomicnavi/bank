package first.program.bank1.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import first.program.bank1.R;

public class s extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);


            ImageView myImageView = (ImageView) findViewById(R.id.imageView);
            myImageView.setImageResource(R.drawable.a1);

    }

}
