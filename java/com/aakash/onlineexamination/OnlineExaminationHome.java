package com.aakash.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OnlineExaminationHome extends AppCompatActivity {
    ImageView coverImg;
    int imgCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_examination_home);
    }

    public void rightListener(View view) {
        coverImg = findViewById(R.id.coverImg);

        if (imgCount == 0){
            coverImg.setImageResource(R.drawable.cover_two);
            imgCount = 1;
        } else if (imgCount == 1) {
            coverImg.setImageResource(R.drawable.cover_three);
            imgCount = 2;
        } else {
            coverImg.setImageResource(R.drawable.cover_one);
            imgCount = 0;
        }
    }

    public void leftListener(View view) {
        coverImg = findViewById(R.id.coverImg);

        if (imgCount == 0){
            coverImg.setImageResource(R.drawable.cover_three);
            imgCount = 2;
        } else if (imgCount == 2) {
            coverImg.setImageResource(R.drawable.cover_two);
            imgCount = 1;
        } else {
            coverImg.setImageResource(R.drawable.cover_one);
            imgCount = 0;
        }
    }

    public void examListener(View view) {
        Intent intent = new Intent(getApplicationContext(), exam_activity.class);
        startActivity(intent);
    }

    public void infoListener(View view) {
        Bundle extras = getIntent().getExtras();
        String userName = extras.getString("name");

        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.info_alert_dialog);
        d.setCancelable(true);

        ImageButton close = d.findViewById(R.id.close);
        TextView name = d.findViewById(R.id.sName);

        name.setText(userName);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });

        d.show();
    }
}