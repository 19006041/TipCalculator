package com.example.tipcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    RadioButton radBad;
    RadioButton radAv;
    RadioButton radGood;
    Button btnWorkOut;
    EditText inputAmt;
    TextView tvAmt;
    public double tipPercent = 0.10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWorkOut = findViewById(R.id.btnWorkOut);
        radAv = findViewById(R.id.radAv) ;
        radBad = findViewById(R.id.radBad);
        radGood = findViewById(R.id.radGood);


        radGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipPercent = 0.18;
            }
        });

        radAv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipPercent = 0.15;
            }
        });

        radBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipPercent = 0.08;
            }
        });



        btnWorkOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                tvAmt = findViewById(R.id.tvAmt);
                inputAmt = findViewById(R.id.inputAmt);
try {

    double d;
    d = Double.parseDouble(inputAmt.getText().toString());

    double tip = (d * tipPercent);
    double total = tip + d;

    tvAmt.setText("Tip Amount = R" + Math.round(tip) + "\n" + "Full Amount = R" + Math.round(total));

}
catch(Exception ex){

   
    Toast toast = Toast.makeText(getApplicationContext(),
            "Please Enter a valid Amount",
            Toast.LENGTH_SHORT
            );

    toast.show();

}

            }
        });

    }
}