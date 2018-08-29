package nti.com.fixstore11.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.view.fragment.ClientFragement;
import nti.com.fixstore11.view.fragment.HandymanFragement;

public class OrderDetailActivity extends AppCompatActivity {
Order order;
    private TextView tvTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        order = (Order) getIntent().getSerializableExtra("Order");
        tvTemp = (TextView) findViewById(R.id.tv_temp);

        tvTemp.setText(order.getClientName()+"\n");
        tvTemp.append(order.getDescription()+"\n");
        tvTemp.append(order.getClientRate()+"\n");
        tvTemp.append(order.getFromdays()+"\n");





    }
}
