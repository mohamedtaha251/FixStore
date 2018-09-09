package nti.com.fixstore11.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.User;
import nti.com.fixstore11.model.remote.FireBase;
import nti.com.fixstore11.utils.LoginUtils;

public class SplashActivity extends AppCompatActivity {


    private Handler handler = new Handler();
    ProgressBar bar;

    private int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        bar = findViewById(R.id.pd);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (status < 100) {
                    status += 1;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            bar.setProgress(status);
                        }
                    });
                }

                //get user from shared prefrenece
                User user = LoginUtils.loadPreferences(SplashActivity.this);
                //User user = new User();

                if (user instanceof HandyMan || user instanceof Client) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra("User", user);
                    startActivity(intent);

                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                }

                finish();

            }
        }).start();


    }

}
