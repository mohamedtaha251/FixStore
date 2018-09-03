package nti.com.fixstore11.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private int selectedPosition = 0;
    private ArrayList<Comment> comments;
    private ArrayList<Integer> selectCheck;
    Context context;
    TextView name, description;

    public CommentAdapter(Context context, ArrayList<Comment> dataList) {
        this.comments = dataList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Comment data = comments.get(position);
        holder.nameT.setText(data.getName());
        holder.descriptionT.setText(data.getDescription());

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameT, descriptionT;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameT = itemView.findViewById(R.id.com_name);
            descriptionT = itemView.findViewById(R.id.comm_description);


        }
    }
}
