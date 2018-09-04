package nti.com.fixstore11.view.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import nti.com.fixstore11.R;
import nti.com.fixstore11.view.activity.CreateOrderActivity;
import nti.com.fixstore11.view.adapter.WorkManShipAdapter;

public class ClientFragement extends Fragment {

    public ClientFragement() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_client, container, false);

        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new WorkManShipAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(getActivity().getBaseContext(), CreateOrderActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
