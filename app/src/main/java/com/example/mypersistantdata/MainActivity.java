package com.example.mypersistantdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final android.widget.EditText etNumberOfYears =(android.widget.EditText) findViewById(R.id.etNumberOfYears);
        final android.widget.EditText etCarLoanAmount =(android.widget.EditText) findViewById(R.id.etCarLoanAmount);
        final android.widget.EditText etInterestRate =(android.widget.EditText) findViewById(R.id.etInterestRate);
        android.widget.Button btnCarPayment = (android.widget.Button) findViewById(R.id.btnCarPayment);

        SharedPreferences sharedPreferences=
                android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        btnCarPayment.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(android.view.View v) {
                int intNumberOfYears = Integer.parseInt(etNumberOfYears.getText().toString());
                int intCarLoanAmount = Integer.parseInt(etCarLoanAmount.getText().toString());
                float decInterestRate = Integer.parseInt(etInterestRate.getText().toString());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("keyNumberOfYears", intNumberOfYears);
                editor.putInt("keyCarLoanAmount", intCarLoanAmount);
                editor.putFloat("keyInterestRate", decInterestRate);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });

    }
}