package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    Spinner feet, inch;
    EditText age;
    Button btnCalculate;
    RadioGroup radioGroup;
    private RadioButton radioButton;
    String gender = "Male";
    TextView out1;
    DecimalFormat decimalFormat = new DecimalFormat("#.#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feet = (Spinner) findViewById(R.id.feet);
        inch = (Spinner) findViewById(R.id.inch);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        age = (EditText) findViewById(R.id.age);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        out1 = (TextView) findViewById(R.id.out1);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                int heightFeet = Integer.parseInt(feet.getSelectedItem().toString());
                int heightInch = Integer.parseInt(inch.getSelectedItem().toString());
                int totalInch = (heightFeet * 12) + heightInch;
                heightFeet = heightFeet - 5;
                heightInch = heightInch + (heightFeet * 12);
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                gender = radioButton.getText().toString();
                out1.setText(Hamwi(heightInch));
            }
        });
    }
    public String Hamwi(int inch) {
        String str = "";
        double total = 0;
        if (gender.equals("Male")) {
            total = 48 + (2.7 * inch);

        } else {
            total = 45.5 + (2.2 * inch);

        }
        total = total * 2.20462;//convert kg to lbs
        str =decimalFormat.format(total )+ " lbs";
        return str;
    }
}