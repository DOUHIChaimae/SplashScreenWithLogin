package ma.enset.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button closeBtt;
        TextView textView1;
        TextView textView2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        closeBtt = (Button) findViewById(R.id.close);
        textView1 = (TextView) findViewById(R.id.textName);
        textView2 = (TextView) findViewById(R.id.textPass);
        String name = getIntent().getStringExtra("name");
        String password = getIntent().getStringExtra("password");
        textView1.setText(name);
        textView2.setText(password);
        closeBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retour(view);
            }
        });
    }

    public void retour(View view) {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }
}
