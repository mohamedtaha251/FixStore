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

public class SplashActivity extends AppCompatActivity {


    private Handler handler =new Handler();
    ProgressBar bar;
    TextView counttv;

    private int status=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        bar=findViewById(R.id.pd);
        counttv=findViewById(R.id.tvcount);


        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (status<100)
                {
                    status+=1;
                    try
                    {
                        Thread.sleep(60);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            bar.setProgress(status);
                            counttv.setText(status+" ");
                        }
                    });
                }
                startActivity(new Intent(SplashActivity.this, AuthenticationActivity.class));
                finish();

            }
        }).start();

//        splashImage = (ImageView) findViewById(R.id.ev_splash_image);
//
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, SPLASH_TIME);



    }
}
