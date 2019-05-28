package first.program.bank1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class s extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);


            ImageView myImageView = (ImageView) findViewById(R.id.imageView);
            myImageView.setImageResource(R.drawable.a1);

    }

}
