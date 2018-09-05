package nti.com.fixstore11.view.adapter;

/**
 * Created by Taha on 14/05/2018.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;
import nti.com.fixstore11.utils.HandyManUtils;

public class WorkManShipAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public WorkManShipAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return HandyManUtils.mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
       ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //    imageView.setPadding(10, 10, 10, 10);
//            imageView.setM(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(HandyManUtils.mThumbIds[position]);
        return imageView;
    }




}


