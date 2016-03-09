package com.salihayesilyurt.bedenkitleendeksi_;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etWeight;
    private EditText etHeight;
    private Button btnCalculate;
    private RadioButton rd_male;
    private RadioButton rd_female;
    private TextView tvResult;
    private double height, weight;
    private double result;
    //https://vucut-kitle-endeksi.hesaplama.net/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        rd_male = (RadioButton) findViewById(R.id.rd_male);
        rd_female = (RadioButton) findViewById(R.id.rd_female);
        tvResult = (TextView) findViewById(R.id.tv_result);

    }

    public void Calculate(View view) {


        if (!(etWeight.getText().toString().isEmpty()) || !(etWeight.getText().toString().isEmpty())) {
            MathematicalCalculations();
            boolean isFemale = rd_female.isChecked();

            if (isFemale) {
                learnResultForFemale(result);
            } else {
                learnResultForMale(result);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Lütfen boş alan bırakmayınız", Toast.LENGTH_LONG).show();
        }
    }

    private void MathematicalCalculations() {
        height = Double.valueOf(etHeight.getText().toString());
        weight = Double.valueOf(etWeight.getText().toString());
        result = weight / Math.pow(height / 100, 2);
    }

    private void learnResultForMale(double result) {
        if (result < 20) {
            tvResult.setText(String.format("Beden kitle endeksiniz:%.2f", result) + "\nZayıf.");
        } else if (result > 20 && result < 26.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\nNormal Kilolu.");
        } else if (result > 27 && result < 31.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\nFazla Kilolu.");
        } else if (result > 32 && result < 36.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\nI.Derece obez");
        } else if (result > 37 && result < 41.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\nII.Derece obez ");
        } else if (result > 42) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\nIII.Derece morbid obez ");
        }
    }

    private void learnResultForFemale(double result) {
        if (result < 18.5) {
            tvResult.setText(String.format("Beden kitle endeksiniz:%.2f", result) + "\n Zayıf.");
        } else if (result > 18.5 && result < 24.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\n Normal Kilolu.");
        } else if (result > 25 && result < 29.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\n Fazla Kilolu.");
        } else if (result > 30 && result < 34.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\n I.Derece obez");
        } else if (result > 35 && result < 39.9) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\n  II.Derece obez ");
        } else if (result > 40) {
            tvResult.setText(String.format("Beden kitle endeksiniz: %.2f", result) + "\n III.Derece morbid obez ");
        }
    }
}
