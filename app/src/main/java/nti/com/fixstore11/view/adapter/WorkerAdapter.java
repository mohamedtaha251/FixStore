package nti.com.fixstore11.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import nti.com.fixstore11.R;

public class WorkerAdapter extends BaseAdapter {
    Context context;

    public WorkerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ImageView imageView = new ImageView(context);;
        TextView name = new TextView(context);
        View gridView;
        if (view == null) {
            gridView = inflater.inflate(R.layout.worker, null);
            gridView = new View(context);
            imageView = new ImageView(context);

            imageView = gridView.findViewById(R.id.workerIMg);
//            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(2, 2, 2, 2);
        } else {
            gridView = view;
        }
        imageView.setImageResource( R.drawable.carpenter_icon);
//        name.setText("gghjgk");
        return gridView;
    }

    public Integer[] mThumbIds = {
            R.drawable.carpenter_icon,
            R.drawable.painter_icon,
            R.drawable.plumber_icon,
            R.drawable.carpenter_icon,
            R.drawable.painter_icon,
            R.drawable.plumber_icon,
            R.drawable.plumber_icon,
            R.drawable.carpenter_icon,
            R.drawable.painter_icon,
            R.drawable.plumber_icon,
            R.drawable.carpenter_icon,
            R.drawable.painter_icon,
            R.drawable.plumber_icon

    };

    private String[] names = {"carpenter", "painter", "plumber", "sattlite", "carpenter", "painter", "plumber", "sattlite", "carpenter", "painter", "plumber", "sattlite"};
}
