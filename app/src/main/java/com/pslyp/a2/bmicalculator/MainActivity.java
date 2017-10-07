package com.pslyp.a2.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    EditText mHeight, mWeight;
    Button calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeight = (EditText) findViewById(R.id.height_editText);
        mWeight = (EditText) findViewById(R.id.weight_editText);
        calculator = (Button) findViewById(R.id.cal_button);

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(mHeight.getText().toString());
                double weight = Double.parseDouble(mWeight.getText().toString());

                double bmi = weight / ((height / 100) * (height / 100));
                String BMIText = getBMIText(bmi);

                Intent it = new Intent(MainActivity.this, Main2Activity.class);
                it.putExtra("bmiDouble", bmi);
                it.putExtra("bmiString", BMIText);
                startActivity(it);
            }
        });


    }

    public String getBMIText(double bmi) {
        String bmiText = "";

        if (bmi < 18.5) {
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        } else if (bmi < 25) {
            bmiText = "น้ำหนักปกติ";
        } else if (bmi < 30) {
            bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
        } else {
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }

        return bmiText;
    }
}
