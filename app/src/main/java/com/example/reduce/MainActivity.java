package com.example.reduce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button reduceButton;
    private EditText zaehlerText;
    private EditText nennerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reduceButton = findViewById(R.id.reduceButton);
        zaehlerText = findViewById(R.id.zaehler);
        nennerText = findViewById(R.id.nenner);

        reduceButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int z = 0;
        int n = 0;
        if(!TextUtils.isEmpty(zaehlerText.getText())){
            z = Integer.parseInt(zaehlerText.getText().toString());
        }
        if(!TextUtils.isEmpty(nennerText.getText())){
            n = Integer.parseInt(nennerText.getText().toString());
        }
        if(z*n != 0){
            int rest;
            int ggt = Math.abs(z);
            int divisor = Math.abs(n);
            do{
                rest = ggt % divisor;
                ggt = divisor;
                divisor = rest;
            }while(rest > 0);
            z /= ggt;
            n /= ggt;

            zaehlerText.setText(Integer.toString(z));
            nennerText.setText(Integer.toString(n));
        }
    }
}