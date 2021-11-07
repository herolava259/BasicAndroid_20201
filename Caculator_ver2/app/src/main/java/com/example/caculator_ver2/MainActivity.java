package com.example.caculator_ver2;

import com.example.caculator_ver2.Caculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button zero, one ,two, three, four, five, six, seven, eight, nine, add, sub, mul, div, equal, clear, cancel, negate;

    private TextView calc_screen, res_screen;


    private Caculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = new Caculator("", "0", "", "", "0", "", "");
        //first_operand = "0";

        wigetRead();
    }

    private void wigetRead(){
        zero = findViewById(R.id.button_0);
        one = findViewById(R.id.button_1);
        two = findViewById(R.id.button_2);
        three = findViewById(R.id.button_3);
        four = findViewById(R.id.button_4);
        five = findViewById(R.id.button_5);
        six = findViewById(R.id.button_6);
        seven = findViewById(R.id.button_7);
        eight = findViewById(R.id.button_8);
        nine = findViewById(R.id.button_9);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.button_sub);
        mul = findViewById(R.id.button_mutiply);
        div = findViewById(R.id.button_divide);
        equal = findViewById(R.id.button_equal);

        negate = findViewById(R.id.button_convert);

        clear = findViewById(R.id.button_C);
        cancel = findViewById(R.id.button_cancel);

        calc_screen = findViewById(R.id.calc);
        res_screen = findViewById(R.id.result);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        negate.setOnClickListener(this);
        clear.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_0:
            {
                calc.addInput("0", Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.button_1:
            {
                calc.addInput("1", Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.button_2:
            {
                calc.addInput("2", Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.button_3:
            {
                calc.addInput("3",Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.button_4:
            {
                calc.addInput("4", Caculator.NUMBER_INPUT);;
                break;
            }
            case R.id.button_5:
            {
                calc.addInput("5",Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.button_6:
            {
                calc.addInput("6",Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.button_7:
            {
                calc.addInput("7", Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.button_8 :
            {
                calc.addInput("8", Caculator.NUMBER_INPUT);;
                break;
            }
            case R.id.button_9 :
            {
                calc.addInput("9", Caculator.NUMBER_INPUT);
                break;
            }
            case R.id.add:
                calc.addInput("+", Caculator.BINARY_OPERATOR);
                break;
            case R.id.button_equal:
                calc.addInput("=", Caculator.EQUAL_OPERATOR);
                break;
            case R.id.button_convert:
                calc.addInput("negate", Caculator.NEGATE_OPERATOR);
                break;
            case R.id.button_cancel:
                calc.addInput("cancel",Caculator.DEFAULT);
            default:
            {
                expand_operator(view);
                break;
            }

        }
    }

    private void addLetterInScreen(String letter){

    }


    private void expand_operator(View view){
        return;
    }
}