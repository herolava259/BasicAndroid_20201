package com.example.caculator_ver2;
import java.util.Stack;
import java.io.IOException;

public class Caculator{

    public static final int NUMBER_INPUT = 0;
    public static final int BINARY_OPERATOR = 1;
    public static final int UNARY_OPERATOR = 2;
    public static final int EQUAL_OPERATOR = 3;
    public static final int NEGATE_OPERATOR = 4;
    public static final int DEFAULT = 5;

    protected String buffer_bottom;//  bo dem toan hang , chi co the hien cac phep tinh toan tu
    protected String buffer_input; // bo dem nhap , nhan cac so tu ban phim,
    protected String buffer_top; // bo dem hien thi phep toan
    protected String cache;
    protected String temporal;

//    public String firstOperand;
    protected String secondOperand;
    protected String opr;



    public Caculator(String _top, String _bottom, String _input, String _cache, String _temp, String _sec, String _oper){
        buffer_top = _top;
        buffer_bottom = _bottom;
        buffer_input = _input;

        cache = _cache;
        temporal = _temp;

        secondOperand = _sec;
        opr = _oper;

    }




    public void addInput(String letter, int input_state){


        switch(input_state){
            case NUMBER_INPUT:
                buffer_input.concat(letter);
                temporal = buffer_input;
                buffer_top = "";
                break;
            case BINARY_OPERATOR:
                cache = compute();
                opr = letter;
                buffer_top = cache + " " + opr;
                buffer_input = "";
                break;
            case UNARY_OPERATOR:
                buffer_input = "";
                temporal = computeUnary();
                buffer_top = coverUnaryOperator();
                break;
            case EQUAL_OPERATOR:
                buffer_input = "";
                if(secondOperand.isEmpty()) secondOperand = temporal;
                temporal = computeWithEqual();
                buffer_top = printEqual();
                break;
            case NEGATE_OPERATOR:
                buffer_input = printNegate(buffer_input);
                temporal = printNegate(temporal);
                buffer_top = coverNegateOperator();
            default:
                expand_Input(letter);

        }
        buffer_bottom = temporal;
    }

    private String coverNegateOperator() {
        return "";
    }

    private String compute(){
        if(cache.isEmpty());
        return "";
    }
    private String computeUnary(){
        return "";
    }
    private String coverUnaryOperator(){
        return "";
    }
    private String computeWithEqual(){
        return "";
    }

    private String printEqual(){
        return "";
    }
    private  String printNegate(String s){
        return "";
    }
    private void expand_Input(String letter){
        return ;
    }




    public String getBottomTextView() {
        return buffer_bottom;
    }


    public String getTopTextView() {
        return buffer_top;
    }


    private double computeBinaryOperator(String first, String second, String exp){
        double x = Double.parseDouble(first);
        double y = Double.parseDouble(second);
        double z ;
        switch(exp){
            case"+":
                return x+y;
            case"-":
                return x-y;
            case"*":
                return x*y;
            case"/":
                return x/y;
            default:
                return 0;
        }
    }
}
