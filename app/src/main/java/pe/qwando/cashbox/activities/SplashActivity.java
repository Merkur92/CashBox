package pe.qwando.cashbox.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.qwando.cashbox.R;

public class SplashActivity extends AppCompatActivity {

    private static final int TIME_DURATION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                routeLogin();
            }
        }, TIME_DURATION_SPLASH);
    }

    private void routeLogin() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
