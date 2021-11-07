package com.example.caculator_ver2;

import java.io.IOException;

interface ICaculator {
    public void addInput(String letter, String input_state);

    void addInput(String letter, int input_state) throws IOException;

    public String getBottomTextView();
    public String getTopTextView();
}
