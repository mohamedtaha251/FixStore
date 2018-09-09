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
import nti.com.fixstore11.model.entities.User;
import nti.com.fixstore11.presenter.presenter.LoginActivityPresenter;
import nti.com.fixstore11.presenter.presenterImpl.loginActivityPresenterImp;
import nti.com.fixstore11.utils.LoginUtils;
import nti.com.fixstore11.view.Interfaces.LoginActivityView;

public class LoginActivity extends AppCompatActivity implements LoginActivityView {
    EditText etPhone;
    EditText etPassword;
    Button btnLogin;
    TextView tvSigUp;
    User user;
    LoginActivityPresenter presenter;


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
        etPassword = findViewById(R.id.et_login_password);
        btnLogin = findViewById(R.id.btn_login);
        tvSigUp = findViewById(R.id.et_signup);
        presenter = new loginActivityPresenterImp();
    }

    private void actions() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+2" + etPhone.getText().toString().trim();
                String password =  etPassword.getText().toString().trim();

                presenter.isUserFound(LoginActivity.this,phone, password);

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


    @Override
    public void passUser(User user) {

        //case phone password incorrect
        if (user ==null)
        {
            Toast.makeText(LoginActivity.this, "inValidUser", Toast.LENGTH_SHORT).show();
            return;
        }


        //case phone and password correct
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("User", user);
        startActivity(intent);
        finish();

        //save user data in shared preference
        LoginUtils.savePreferences(this,user);

    }

    @Override
    public void isValidUser(boolean b) {

    }
}
