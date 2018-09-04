package nti.com.fixstore11.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.view.fragment.ClientFragement;
import nti.com.fixstore11.view.fragment.HandymanFragement;

public class OrderDetailActivity extends AppCompatActivity {
    Order order;


    TextView descriptionTV, locationTV;
    Button acceptBTN, rejectBTN, callBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);


        order = (Order) getIntent().getSerializableExtra("Order");
        init();
        actions();

    }

    private void init() {
        descriptionTV = findViewById(R.id.tv_order_description);
        locationTV = findViewById(R.id.tv_order_location);

        acceptBTN = findViewById(R.id.btn_accept);
        rejectBTN = findViewById(R.id.btn_reject);
        callBTN = findViewById(R.id.btn_call);

    }

    private void actions() {
        callBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dial = new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse(order.getClient().getPhone()));
                if ((dial.resolveActivity(getPackageManager())) != null)
                    startActivity(dial);
                else
                    Toast.makeText(getBaseContext(), "حدث خطا يرجى المحاولة مرة اخرى  ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
