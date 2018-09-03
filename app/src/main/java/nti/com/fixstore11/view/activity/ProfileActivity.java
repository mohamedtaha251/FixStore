package nti.com.fixstore11.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.io.IOException;
import java.util.ArrayList;

import nti.com.fixstore11.R;
import nti.com.fixstore11.model.entities.Comment;
import nti.com.fixstore11.model.entities.HandyMan;
import nti.com.fixstore11.model.local.SQLiteHelper;
import nti.com.fixstore11.view.adapter.CommentAdapter;

public class ProfileActivity extends  AppCompatActivity {
    RatingBar bar;
    Button test;
    EditText commentT;
    HandyMan handyMan;
    RecyclerView commentView;
    ImageView selectImg, profileIMg;
    CommentAdapter commentAdapter;
    ArrayList<Comment> comments = new ArrayList<>();
    Comment comment;
    public static final int PICK_IMAGE = 1;

    private SQLiteHelper sqLiteOpen;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                sqLiteOpen.insert(uri.getPath());
                ImageView imageView = findViewById(R.id.profile_image);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_profile);

        init();
        actions();


    }

    private void init() {
        bar = findViewById(R.id.rate_handman);
        test = findViewById(R.id.test);
        commentT = findViewById(R.id.comment_tv);
        commentView = findViewById(R.id.comment_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        commentView.setLayoutManager(manager);
//        commentAdapter=new CommentAdapter(this,comments);
//        commentView.setAdapter(commentAdapter);
        selectImg = findViewById(R.id.selectIMG);
        profileIMg = findViewById(R.id.profile_image);

        sqLiteOpen = new SQLiteHelper(getBaseContext());


    }

    private void actions() {
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentAdapter = new CommentAdapter(getBaseContext(), getComment());
                commentView.setAdapter(commentAdapter);

                for (Comment c : comments)
                    Log.e("comm  ", c.getDescription());
            }
        });

        selectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIMg();
            }
        });
    }

    private void selectIMg() {
        Intent intent = new Intent();
// Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    private ArrayList<Comment> getComment() {
        comment = new Comment();

        comment.setDescription(commentT.getText().toString());
        comment.setName("fred");
        comments.add(comment);

        return comments;
    }
}