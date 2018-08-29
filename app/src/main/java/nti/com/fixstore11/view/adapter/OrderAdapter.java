package nti.com.fixstore11.view.adapter;

/**
 * Created by Taha on 14/05/2018.
 */

import android.content.Context;
import android.database.Cursor;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nti.com.fixstore11.R;

import java.util.ArrayList;

import nti.com.fixstore11.model.entities.Order;

public class OrderAdapter extends CursorAdapter {
    ArrayList<Order> ordersList;
    Context mContext;
    LayoutInflater inflater;
    private int resId;

    private SparseBooleanArray mSelectedItemsIds;



    private TextView ClientNameTextView;
    private TextView OrderDescTextView;
    private TextView ClientRateTextView;
    private TextView OrderFromDayTextView;
    private ImageView OrderImageView;

    public OrderAdapter(Context context, ArrayList<Order> weatherList, int resource) {
        super(context,null);
        this.ordersList = weatherList;
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        mSelectedItemsIds = new SparseBooleanArray();
        this.resId = resource;


    }

    @Override
    public int getCount() {
        return ordersList.size();
    }

    @Override
    public Object getItem(int position) {
        return ordersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ordersList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.resId, null);

        ClientNameTextView = (TextView) convertView.findViewById(R.id.list_item_client_name_textview);
        OrderDescTextView = (TextView) convertView.findViewById(R.id.list_item_desc_textview);
        ClientRateTextView = (TextView) convertView.findViewById(R.id.list_item_client_rate_textview);
        OrderFromDayTextView = (TextView) convertView.findViewById(R.id.list_item_from_day_textview);
        OrderImageView = (ImageView) convertView.findViewById(R.id.list_item_icon);

        Order order = ordersList.get(position);
        ClientNameTextView.setText(order.getClientName());
        OrderDescTextView.setText(order.getDescription());
        ClientRateTextView.setText((int) order.getClientRate() + " rate");
        OrderFromDayTextView.setText((int) order.getFromdays() + " day");
        return convertView;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    private void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();

    }

}
