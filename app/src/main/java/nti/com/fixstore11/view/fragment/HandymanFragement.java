package nti.com.fixstore11.view.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.entities.Order;
import nti.com.fixstore11.presenter.presenterImpl.HandyManMainPresenterImp;
import nti.com.fixstore11.utils.NotificationUtils;
import nti.com.fixstore11.view.Interfaces.HandymanFragementView;
import nti.com.fixstore11.view.activity.OrderDetailActivity;
import nti.com.fixstore11.view.adapter.OrderAdapter;

public class HandymanFragement extends Fragment implements HandymanFragementView {
    private ListView mListView;
    SwipeRefreshLayout pullToRefresh;
    HandyManMainPresenterImp presenter;
    ArrayList<Order> orders;
    OrderAdapter orderAdapter;
    HandyMan handyMan;

    public HandymanFragement() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_handyman, container, false);


        mListView = (ListView) rootView.findViewById(R.id.list_view_order);
        pullToRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.pullToRefresh);

        //initate order and presenter
        orders = new ArrayList<>();
        presenter = new HandyManMainPresenterImp();

        //get Current handy man from intent comming from previous activity
        handyMan = (HandyMan) getActivity().getIntent().getSerializableExtra("User");

        //refresh data for first time
        refreshData();

        //set adapter
        orderAdapter = new OrderAdapter(getActivity(), orders, R.layout.list_item_order);
        mListView.setAdapter(orderAdapter);

        //on click on of item to open Order Detail activity
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Order selectedOrder = orders.get(position);

                //move to Order Detail activity with data of selected item
                Intent intent = new Intent(getActivity().getBaseContext(), OrderDetailActivity.class);
                intent.putExtra("Order", selectedOrder);
                startActivity(intent);
            }
        });

        //on pull to refresh
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                pullToRefresh.setRefreshing(false);
            }
        });


        return rootView;
    }


    private void refreshData() {
        presenter.updateOrders(this, handyMan);

        //notify with any new order
        presenter.notifyWithNewOrder(this, handyMan);

    }

    @Override
    public void updateOrders(ArrayList<Order> orders) {
        this.orders = orders;
        ArrayList<Order> temp = new ArrayList<>();
        temp.add(new Order());

        //set adapter
        orderAdapter = new OrderAdapter(getActivity(), this.orders, R.layout.list_item_order);
        mListView.setAdapter(orderAdapter);

    }

    @Override
    public void notifyWithNewOrder(Order order) {

        //push notifications
        NotificationUtils.pushOrderNotification(getActivity(), order);
    }
}
