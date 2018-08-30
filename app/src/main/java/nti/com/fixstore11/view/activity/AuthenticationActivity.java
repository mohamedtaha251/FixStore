package nti.com.fixstore11.view.activity;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.nio.file.Files;

import nti.com.fixstore11.R;

public class AuthenticationActivity extends AppCompatActivity {
    ConstraintLayout selection, login;
    EditText phoneT;
    Button nextBTN;
    CheckBox clientCheck, HandmanCheck;
    Boolean ClientSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_authentication);

        init();
        actions();
    }

    private void init() {
        selection = findViewById(R.id.selectLayout);
        login = findViewById(R.id.LoginLayout);
        phoneT = findViewById(R.id.etPhone);
        clientCheck = findViewById(R.id.ClientCheck);
        HandmanCheck = findViewById(R.id.HandmanCheck);
        nextBTN = findViewById(R.id.nextBTN);
        selection.setVisibility(View.INVISIBLE);
    }

    private void actions() {
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// get phone to firebase
                login.setVisibility(View.INVISIBLE);
                selection.setVisibility(View.VISIBLE);
            }
        });
        clientCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ClientSelection = false;
                    Intent intent = new Intent(AuthenticationActivity.this, SignUpActivity.class);
                    intent.putExtra("SignUpSelection", ClientSelection);
                    startActivity(intent);
                    HandmanCheck.setChecked(false);

                }
            }
        });
        HandmanCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ClientSelection = true;
                    Intent intent = new Intent(AuthenticationActivity.this, SignUpActivity.class);
                    intent.putExtra("SignUpSelection", ClientSelection);
                    startActivity(intent);
                    clientCheck.setChecked(false);
                }
            }
        });


    }


}
