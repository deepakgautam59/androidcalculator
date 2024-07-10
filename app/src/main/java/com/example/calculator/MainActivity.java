package com.example.calculator;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText etNumber1;
private EditText etNumber2;
private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       etNumber1=findViewById(R.id.etNumber1);
       etNumber2=findViewById(R.id.etNumber2);
       tvResult=findViewById(R.id.tvResult);
       Button btnAdd=findViewById(R.id.btnAdd);
       Button btnSub=findViewById(R.id.btnSub);
       Button btnDiv=findViewById(R.id.btnDiv);
       Button btnMul=findViewById(R.id.btnMul);
       etNumber1.setTextSize(50);
       etNumber2.setTextSize(50);

       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               calculate('+');
           }
       });
       btnSub.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               calculate('-');
           }
       });
       btnDiv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               calculate('/');
           }
       });
       btnMul.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               calculate('*');
           }
       });

    }
    private void calculate(char operator){
        String num1 = etNumber1.getText().toString();
        String num2 = etNumber2.getText().toString();
        if(!num1.isEmpty()&&!num2.isEmpty()){
            double n1=Double.parseDouble(num1);
            double n2=Double.parseDouble(num2);
            double result =0;
            switch (operator){
                case '+' :
                result = n1+n2;
                break;
                case '-' :
                    result = n1-n2;
                    break;
                case '*' :
                    result = n1*n2;
                    break;
                case '/' :
                    if(n2!=0){
                        result = n1/n2;

                    }
                    else{
                        tvResult.setText("cannot Divide By Zero");
                        return;
                    }
                    break;
            }
            tvResult.setText("result :"+result);

        } else {
            tvResult.setText("Please Enter Both Numbers");
        }
    }
}