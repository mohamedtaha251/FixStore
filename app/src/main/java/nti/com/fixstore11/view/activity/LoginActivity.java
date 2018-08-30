package nti.com.fixstore11.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nti.com.fixstore11.R;

public class LoginActivity extends AppCompatActivity {
    EditText etPhone;
    EditText etPassword;
    Button btnLogin;
    Button btnSigUp;
    Boolean isClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPhone = findViewById(R.id.et_login_phone);
        etPassword = findViewById(R.id.et_login_phone);
        btnLogin = findViewById(R.id.btn_login);
        btnSigUp = findViewById(R.id.btn_signup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidUser()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("isClient", isClient);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "inValidUser", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSigUp.setOnClickListener(new View.OnClickListener() {
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
}
