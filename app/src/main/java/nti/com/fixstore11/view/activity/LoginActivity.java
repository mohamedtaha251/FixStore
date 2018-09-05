package nti.com.fixstore11.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Client;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.view.Interfaces.LoginActivityView;

public class LoginActivity extends AppCompatActivity implements LoginActivityView {
    EditText etPhone;
    EditText etPassword;
    Button btnLogin;
    TextView tvSigUp;
    Boolean isClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        init();
        actions();

    }

    private void init() {
        etPhone = findViewById(R.id.et_login_phone);
        etPassword = findViewById(R.id.et_login_phone);
        btnLogin = findViewById(R.id.btn_login);
        tvSigUp = findViewById(R.id.et_signup);
    }

    private void actions() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidUser()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("User", new Client());
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "inValidUser", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tvSigUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, AuthenticationActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidUser() {
        //check if user valid from fire base
        return true;
    }

    private boolean isClientUser() {
        //check if user valid from fire base
        return true;
    }

    @Override
    public void isValidUser(Boolean isValid) {
        if (isValid==true) {
            Toast.makeText(this, "login Successfully of Client", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            finish();
            intent.putExtra("isClient", isClient);
            startActivity(intent);
        } else if (isValid==false) {
            Toast.makeText(this, "login  Successfully of handyman", Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("isClient", false);
            startActivity(intent);
        }else
        {

            Toast.makeText(getApplicationContext(),"login failed",Toast.LENGTH_LONG).show();



        }
    }
}
