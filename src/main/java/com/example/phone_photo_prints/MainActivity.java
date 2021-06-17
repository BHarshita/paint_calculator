package com.example.phone_photo_prints;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int numOrders;
    double rad1 = 0.19;
    double rad2 = 0.49;
    double rad3 = 0.79;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint("WrongViewCast") final EditText print = (EditText)findViewById(R.id.numPrints);
        final RadioButton radioButton1 = (RadioButton) findViewById(R.id.rad1);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.rad2);
        final RadioButton radioButton3 = (RadioButton) findViewById(R.id.rad3);
        final TextView results = (TextView) findViewById(R.id.result);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOrders = Integer.parseInt(print.getText().toString());
                DecimalFormat money = new DecimalFormat("###,###.00");

                if (radioButton1.isChecked() && (print < 50)) //radio 1
                {
                    total = numOrders *rad1;
                    results.setText("The total cost of your order is: " + money.format(total));
                }
                if (radioButton2.isChecked() && (print < 50)) //radio 2
                {
                    total = numOrders *rad2;
                    results.setText("The total cost of your order is: " + money.format(total));
                }
                if (radioButton3.isChecked() && (print > 50)) //radio 3
                {
                    return;
                }
                total = numOrders *rad3;
                results.setText("The total cost of your order is: " + money.format(total));
            }
        });


    }

}// end main