package com.example.nishant.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nishnat.calculator.R;

public class MainActivity extends AppCompatActivity {

    Button C;
    Button Div;
    Button Mul;
    Button Del;
    Button seven;
    Button eight;
    Button nine;
    Button Min;
    Button four;
    Button five;
    Button six;
    Button Plus;
    Button one;
    Button two;
    Button three;
    Button Point;
    Button Sq_num;
    Button zero;
    Button cub_num;
    Button Equal;

    TextView number1,number2,operation;

    float num1,num2 ;
    char operator;
    int operator_count=0;
    boolean neg_number = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        C = (Button) findViewById(R.id.Clear);
        Div = (Button) findViewById(R.id.Div);
        Mul = (Button) findViewById(R.id.Mul);
        Del = (Button) findViewById(R.id.Del);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        Min = (Button) findViewById(R.id.Min);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        Plus = (Button) findViewById(R.id.Plus);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        Point = (Button) findViewById(R.id.point);
        Sq_num = (Button) findViewById(R.id.b_open);
        zero = (Button) findViewById(R.id.zero);
        cub_num= (Button) findViewById(R.id.b_close);
        Equal = (Button) findViewById(R.id.equal);

        number1 = (TextView) findViewById(R.id.number1);
        number2 = (TextView) findViewById(R.id.number2);
        operation =(TextView)findViewById(R.id.operator);

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              number1.setText("");
              number2.setText("");
              operation.setText("");
            }
        });

        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {   if(number1.getText().toString().isEmpty())operation.setText("");
                if(number2.getText().toString().isEmpty()
                        && !number1.getText().toString().isEmpty()
                        && !neg_number){
                    operation.setText("÷");
                    operator='/';
                }
               if(neg_number && number1.getText().toString().length() >1){
                    operator='/';
                    operation.setText("÷");
               }
               if(!number2.getText().toString().isEmpty()
                       && !neg_number
                       && !number1.getText().toString().isEmpty()){
                    num1=Float.valueOf(number1.getText().toString());
                    num2=Float.valueOf(number2.getText().toString());
                    calculate(num1,operator,num2);
                    operation.setText("÷");
                    operator='/';
                }
            }
        });

        Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number1.getText().toString().isEmpty())operation.setText("");
                if(number2.getText().toString().isEmpty() && !number1.getText().toString().isEmpty()
                        && !neg_number){
                    operation.setText("X");
                    operator='*';
                }
                if(neg_number && number1.getText().toString().length() >1){
                    operator='*';
                    operation.setText("X");
                }
                if(!number2.getText().toString().isEmpty()
                        &&!neg_number
                        && !number1.getText().toString().isEmpty()){
                    num1=Float.valueOf(number1.getText().toString());
                    num2=Float.valueOf(number2.getText().toString());
                    calculate(num1,operator,num2);
                    operation.setText("X");
                    operator='*';
                }
                }
        });

        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2 = number2.getText().toString();
                String o= operation.getText().toString();
                String s1 = number1.getText().toString();
              if(!s2.isEmpty()){
                  number2.setText(s2.substring(0,s2.length()-1));
                  s2=number2.getText().toString();
              }
              if(s2.isEmpty()&& !s1.isEmpty() && !o.isEmpty()){
                  number2.setText("");
                  number1.setText("");
                  operation.setText("");
              }
              if(s2.isEmpty() && o.isEmpty() && !s1.isEmpty()){
                  number1.setText(s1.substring(0,s1.length()-1));
                  s1=number1.getText().toString();
              }
                if(s1.isEmpty() && s2.isEmpty() && o.isEmpty()){
                    number2.setText("");
                    number1.setText("");
                    operation.setText("");
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                number1.setText(number1.getText() + "7");
            }else{
                    number2.setText(number2.getText()+  "7");
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "8");
                }else{
                    number2.setText(number2.getText()+  "8");
                }
            }
        });
        ;

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "9");
                }else{
                    number2.setText(number2.getText()+  "9");
                }
            }
        });

        Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nnum = number1.getText().toString();
                if (nnum.isEmpty()) {
                    number1.setText("-");
                    neg_number = true;
                }
                if (neg_number && nnum.length() > 1) {
                    operation.setText("-");
                    operator = '-';
                }
                if(number2.getText().toString().isEmpty()
                        && (!neg_number
                        && !number1.getText().toString().isEmpty())){
                    operation.setText("-");
                    operator ='-';
                }
                 if(!neg_number && !number2.getText().toString().isEmpty() && !nnum.isEmpty())
                {
                    num1 = Float.valueOf(number1.getText().toString());
                    num2 = Float.valueOf(number2.getText().toString());
                    calculate(num1, operator, num2);
                    operation.setText("-");
                    operator = '-';
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "4");
                }else{
                    number2.setText(number2.getText()+  "4");
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "5");
                }else{
                    number2.setText(number2.getText()+  "5");
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "6");
                }else{
                    number2.setText(number2.getText()+  "6");
                }
            }
        });

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number1.getText().toString().isEmpty())operation.setText("");
                if(number2.getText().toString().isEmpty()
                && !neg_number
                        && !number1.getText().toString().isEmpty()){
                    operation.setText("+");
                    operator='+';
                }
                if(neg_number && number1.getText().toString().length() >1){
                    operator='+';
                    operation.setText("+");
                }if(!number2.getText().toString().isEmpty()
                        && !number1.getText().toString().isEmpty()
                        && !neg_number){
                    num1=Float.valueOf(number1.getText().toString());
                    num2=Float.valueOf(number2.getText().toString());
                    calculate(num1,operator,num2);
                    operation.setText("+");
                    operator='+';
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "1");
                }else{
                    number2.setText(number2.getText()+  "1");
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "2");
                }else{
                    number2.setText(number2.getText()+  "2");
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "3");
                }else{
                    number2.setText(number2.getText()+  "3");
                }
            }
        });

        Point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    if(!number1.getText().toString().contains("."))
                    number1.setText(number1.getText() + ".");
                    else number1.setText(number1.getText());
                }else{
                    if(!number2.getText().toString().contains("."))
                    number2.setText(number2.getText()+  ".");
                    else number2.setText(number2.getText());
                }
            }
        });

        Sq_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String numb1 = number1.getText().toString();
            String numb2 = number2.getText().toString();
            String oper = operation.getText().toString();
            String res;
            Float square ;
            if(numb1.isEmpty())toast("Enter no. first");
            if(!numb1.isEmpty() && oper.isEmpty() && numb2.isEmpty()){
                square = Float.valueOf(numb1);
                square=square*square;
                num1=square;
                res=String.valueOf(num1);
                number1.setText(res);
            }
            if(!numb1.isEmpty() && (!numb2.isEmpty() || oper.isEmpty())){
                number1.setText(number1.getText());
                number2.setText(number2.getText());
                operation.setText(operation.getText());
            }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operation.getText().toString().isEmpty()){
                    number1.setText(number1.getText() + "0");
                }else{
                    number2.setText(number2.getText()+  "0");
                }
            }
        });

        cub_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numb1 = number1.getText().toString();
                String numb2 = number2.getText().toString();
                String oper = operation.getText().toString();
                String res;
                Float cube ;
                if(numb1.isEmpty())toast("Enter no. first");
                if(!numb1.isEmpty() && oper.isEmpty() && numb2.isEmpty()){
                    cube = Float.valueOf(numb1);
                    cube=cube*cube*cube;
                    num1=cube;
                    res=String.valueOf(num1);
                    number1.setText(res);
                }
                if(!numb1.isEmpty() && (!numb2.isEmpty() || oper.isEmpty())){
                    number1.setText(number1.getText());
                    number2.setText(number2.getText());
                    operation.setText(operation.getText());
                }
            }
        });

        Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               num1=Float.valueOf(number1.getText().toString());
               num2=Float.valueOf(number2.getText().toString());
               calculate(num1,operator,num2);
            }
        });
    }

    public void calculate(float num1,char operator,float num2){

       switch (operator){
           case '-':{
               num1=num1-num2;
               break;
           }
           case '+':{
               num1=num1+num2;
               break;}
           case '/': {
               num1 = num1/num2;
               break;
           }
           case '*':{
               num1=num1*num2;
               break;}
               default:
                   number1.setText("Wrong Format");
       }
       String result=String.valueOf(num1);
        number1.setText(result);
        operator_count=0;
        operation.setText("");
        number2.setText("");
    }
    public void toast(String msg){
        Toast t= Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        t.show();
    }
}

