package com.pslyp.a2.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = (TextView) findViewById(R.id.bmi_label);
        t2 = (TextView) findViewById(R.id.bmiText_label);

        Intent it = getIntent();
        double bmi = it.getDoubleExtra("bmiDouble", 0);
        String bmiText = it.getStringExtra("bmiString");

        t1.setText(String.format("%.2f", bmi));
        t2.setText(bmiText);
    }
}
