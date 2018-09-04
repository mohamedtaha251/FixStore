package nti.com.fixstore11.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import nti.com.fixstore11.R;
import nti.com.fixstore11.view.fragment.SignUpClientFragement;
import nti.com.fixstore11.view.fragment.SignUpHandymanFragement;

public class AuthenticationActivity extends AppCompatActivity implements View.OnClickListener {
    ConstraintLayout selection, login;
    EditText phoneT;
    Button nextBTN;
    String phone;
    CheckBox clientCheck, HandmanCheck;
    Boolean ClientSelection;

    EditText mPhoneNumberField, mVerificationField;
    Button mStartButton, mVerifyButton;
    Bundle bundle = new Bundle();
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String mVerificationId;

    private static final String TAG = "PhoneAuthActivity";

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
        //    phoneT = findViewById(R.id.);
        clientCheck = findViewById(R.id.ClientCheck);
        HandmanCheck = findViewById(R.id.HandmanCheck);
        nextBTN = findViewById(R.id.nextBTN);
        selection.setVisibility(View.INVISIBLE);
        nextBTN.setVisibility(View.INVISIBLE);
        mPhoneNumberField = (EditText) findViewById(R.id.field_phone_number);
        mVerificationField = (EditText) findViewById(R.id.field_verification_code);

        mStartButton = (Button) findViewById(R.id.button_start_verification);
        mVerifyButton = (Button) findViewById(R.id.button_verify_phone);
//        mResendButton = (Button) findViewById(R.id.button_resend);

        mStartButton.setOnClickListener(this);
        mVerifyButton.setOnClickListener(this);
//        mResendButton.setOnClickListener(this);

        mVerifyButton.setVisibility(View.INVISIBLE);
//        mResendButton.setVisibility(View.INVISIBLE);
        nextBTN.setVisibility(View.INVISIBLE);

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
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
                    phone = "+2" + mPhoneNumberField.getText().toString().trim();
                    ClientSelection = false;
                    Intent intent = new Intent(AuthenticationActivity.this, SignUpActivity.class);
                    intent.putExtra("SignUpSelection", ClientSelection);
                   intent.putExtra("phone", phone);
                    startActivity(intent);
                    HandmanCheck.setChecked(false);





                }
            }
        });
        HandmanCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    phone = "+2" + mPhoneNumberField.getText().toString().trim();
                    ClientSelection = true;
                    Intent intent = new Intent(AuthenticationActivity.this, SignUpActivity.class);
                    intent.putExtra("SignUpSelection", ClientSelection);
                    intent.putExtra("phone", phone);

                    startActivity(intent);
                    clientCheck.setChecked(false);


                }
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                Log.d(TAG, "onVerificationCompleted:" + credential);
                signInWithPhoneAuthCredential(credential);

                Toast.makeText(getBaseContext(), "تــــم", Toast.LENGTH_SHORT).show();
                nextBTN.setVisibility(View.VISIBLE);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Log.w(TAG, "onVerificationFailed", e);
                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    mPhoneNumberField.setError("حدث مشكلة يرجى المحاولة مرة اخرى");
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    mPhoneNumberField.setError("حدث مشكلة يرجى المحاولة مرة اخرى");
                }
            }

            @Override
            public void onCodeSent(String verificationId,PhoneAuthProvider.ForceResendingToken token) {
                Log.d(TAG, "onCodeSent:" + verificationId);
                Toast.makeText(getBaseContext(), "سوف تصلك رساله الكود التعريفى الان", Toast.LENGTH_SHORT).show();
                mVerificationId = verificationId;
                mResendToken = token;
            }
        };
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = task.getResult().getUser();
                        } else {
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                mVerificationField.setError("الكود التعريفى غير صحيح");
                            }
                        }
                    }
                });
    }


    private void startPhoneNumberVerification(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }

    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void resendVerificationCode(String phoneNumber,
                                        PhoneAuthProvider.ForceResendingToken token) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks,         // OnVerificationStateChangedCallbacks
                token);             // ForceResendingToken from callbacks
    }

    private boolean validatePhoneNumber() {
        phone = "+2" + mPhoneNumberField.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            mPhoneNumberField.setError("رقم الهاتف غير صحيح");
            return false;
        }
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(AuthenticationActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start_verification:
                if (!validatePhoneNumber()) {
                    return;
                }
                mVerifyButton.setVisibility(View.VISIBLE);
//                mResendButton.setVisibility(View.VISIBLE);
                mStartButton.setVisibility(View.INVISIBLE);
//                nextBTN.setVisibility(View.VISIBLE);
                startPhoneNumberVerification("+2" + mPhoneNumberField.getText().toString());
                break;
            case R.id.button_verify_phone:
                String code = mVerificationField.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    mVerificationField.setError("يجب كتابة الكود التعريفى");
                    return;
                }

                verifyPhoneNumberWithCode(mVerificationId, code);
//                nextBTN.setVisibility(View.VISIBLE);
                break;
//            case R.id.button_resend:
//                resendVerificationCode(mPhoneNumberField.getText().toString(), mResendToken);
//                break;
        }

    }

}

