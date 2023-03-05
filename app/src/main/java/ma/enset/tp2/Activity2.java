package ma.enset.tp2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Activity2 extends AppCompatActivity {
    Button btnLogin;
    EditText editText1;
    EditText editText2;
    private String TAG = "Message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_2);
        Log.d(TAG, "onCreate vient d'être appelée !");
        Toast.makeText(this, "onCreate vient d'être appelée !", Toast.LENGTH_SHORT).show();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        btnLogin = (Button) findViewById(R.id.login);
        editText1 = (EditText) findViewById(R.id.name);
        editText2 = (EditText) findViewById(R.id.pass);
        Button changeLang = (Button) findViewById(R.id.changeLangage);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                String name = editText1.getText().toString();
                String password = editText2.getText().toString();
                intent.putExtra("name", name);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"French", "Arabic", "Espagnol", "Chinese"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Activity2.this);
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("fr");
                    Toast.makeText(Activity2.this, "Vous avez choisi la langue française", Toast.LENGTH_SHORT).show();
                    recreate();
                } else if (i == 1) {
                    setLocale("ar");
                    Toast.makeText(Activity2.this, "لقد اخترت اللغة العربية", Toast.LENGTH_SHORT).show();
                    recreate();
                } else if (i == 2) {
                    setLocale("es");
                    Toast.makeText(Activity2.this, "Has elegido el idioma español", Toast.LENGTH_SHORT).show();
                    recreate();
                } else if (i == 3) {
                    setLocale("zh");
                    Toast.makeText(Activity2.this, "你選擇了中文", Toast.LENGTH_SHORT).show();
                    recreate();
                }
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String language) {
        Locale local = new Locale(language);
        local.setDefault(local);
        Configuration configuration = new Configuration();
        configuration.setLocale(local);
        getBaseContext().getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_lang", language);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences preferences = getSharedPreferences("Settings", Activity2.MODE_PRIVATE);
        String language = preferences.getString("My_lang", "");
        setLocale(language);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart vient d'être appelée !");
        Toast.makeText(this, "onStart vient d'être appelée !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart vient d'être appelée !");
        Toast.makeText(this, "onRestart vient d'être appelée !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume vient d'être appelée !");
        Toast.makeText(this, "onResume vient d'être appelée !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause vient d'être appelée !");
        Toast.makeText(this, "onPause vient d'être appelée !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop vient d'être appelée !");
        Toast.makeText(this, "onStop vient d'être appelée !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy vient d'être appelée !");
        Toast.makeText(this, "onDestroy vient d'être appelée !", Toast.LENGTH_SHORT).show();
    }
}