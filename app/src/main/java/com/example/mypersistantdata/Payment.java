package com.example.mypersistantdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.widget.TextView;
import android.os.Bundle;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView tvMonthlyPayment = (TextView) findViewById(R.id.tvMonthlyPayment);
        TextView tvYears = (TextView) findViewById(R.id.tvYears);

        SharedPreferences sharedPreferences;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int intNumberOfYears = sharedPreferences.getInt("keyNumberOfYears", 0);
        int intCarLoanAmount = sharedPreferences.getInt("keyCarLoanAmount", 0);
        float decInterestRate = sharedPreferences.getFloat("keyInterestRate", 0);

        float decMonthlyPayment;
//        TotalAmount = LoanAmount * (1+Rate*Year);
//        MonthlyPayment = TotalAmount / (Year*12);
        decMonthlyPayment = (intCarLoanAmount*(1+(decInterestRate*intNumberOfYears)))
                /(intNumberOfYears*12);

        DecimalFormat decimalFormat = new DecimalFormat("$###,###.##");
        tvMonthlyPayment.setText("Monthly Payment" + decimalFormat.format(decMonthlyPayment));

        tvYears.setText(intNumberOfYears + "-Year Loan ");
    }
}