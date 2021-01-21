package com.example.tsf.TSFlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

public class Show extends AppCompatActivity {

    Button logout;
    TextView nm,em;
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Login Integration");
        myToolbar.setTitleTextColor(Color.BLACK);
        nm=findViewById(R.id.name);
        em=findViewById(R.id.em);

        Intent intent = getIntent();
        final int app= intent.getIntExtra("app",0);
        String email = intent.getStringExtra("email");
        String name = intent.getStringExtra("name");
        String url = intent.getStringExtra("url");
        im=findViewById(R.id.imageView3);
        nm.setText(name);
        em.setText(email);

        Picasso.get()
                .load(url)
                .resize(150, 150)
                .centerCrop()
                .into(im);



        logout=findViewById(R.id.lgout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(app==0){
                    LoginManager.getInstance().logOut();
                    finish();
                }
                else{
                    finish();
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        LoginManager.getInstance().logOut();
        super.onDestroy();
    }
}