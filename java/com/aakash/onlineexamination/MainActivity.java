package com.aakash.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText uName, pass;
    RelativeLayout parentL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void forgotPassListener(View view) {
        Toast.makeText(getApplicationContext(), "Feature to be added later", Toast.LENGTH_SHORT).show();
    }

    public void logInListener(View view) {
        uName = findViewById(R.id.uName);
        pass = findViewById(R.id.pass);
        parentL = findViewById(R.id.parentL);

        if (uName.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
            CharSequence charSequence = "Please enter username or password";
            final Snackbar snackbar = Snackbar.make(parentL, charSequence, Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Ok", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        } else {
            Intent intent = new Intent(getApplicationContext(), OnlineExaminationHome.class);
            intent.putExtra("name", uName.getText().toString());
            startActivity(intent);
        }
    }
}