package nti.com.fixstore11.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import nti.com.fixstore11.R;

public class CreateOrderActivity extends AppCompatActivity {
    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        temp = findViewById(R.layout.activity_create_order);
    }
}
