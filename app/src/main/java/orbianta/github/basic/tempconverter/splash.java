package orbianta.github.basic.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        global.timer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent activity_intent = new Intent(splash.this, MainActivity.class);
                startActivity(activity_intent);
            }
        },2000);

    }
}