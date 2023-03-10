package ma.enset.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            Intent iHome = new Intent(SplashActivity.this, Activity2.class);
            @Override
            public void run() {
                startActivity(iHome);
            }
        }, SPLASH_TIME_OUT);
    }
}
