package com.aakash.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class exam_activity extends AppCompatActivity {
    RadioGroup qno, qntw, qnth, qnf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_activity);
    }

    public void closeListener(View view) {
        finish();
    }

    public void submitListener(View view) {
        qno = findViewById(R.id.qOneAns);
        qntw = findViewById(R.id.qTwoAns);
        qnth = findViewById(R.id.qThreeAns);
        qnf = findViewById(R.id.qFourAns);

        int temp_1 = qno.getCheckedRadioButtonId();
        int temp_2 = qntw.getCheckedRadioButtonId();
        int temp_3 = qnth.getCheckedRadioButtonId();
        int temp_4 = qnf.getCheckedRadioButtonId();

        if (temp_1 == -1 || temp_2 == -1 || temp_3 == -1 || temp_4 == -1){
            final Dialog d = new Dialog(this);
            d.setContentView(R.layout.submit_confirmation_dialog);
            d.setCancelable(true);

            Button yes = d.findViewById(R.id.yes);
            Button no = d.findViewById(R.id.no);
            TextView text = d.findViewById(R.id.prompt);

            text.setText("Incomplete! Do you wish to continue?");
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d.dismiss();
                    finish();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d.dismiss();
                }
            });

            d.show();
        } else {
            final Dialog d = new Dialog(this);
            d.setContentView(R.layout.submit_confirmation_dialog);
            d.setCancelable(true);

            Button yes = d.findViewById(R.id.yes);
            Button no = d.findViewById(R.id.no);
            TextView text = d.findViewById(R.id.prompt);

            text.setText("Do you wish to submit? You can recheck as well.");
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d.dismiss();
                    finish();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d.dismiss();
                }
            });

            d.show();
        }
    }
}