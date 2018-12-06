package com.kkaty.week2day1homework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etUsernameInput;
    EditText etPasswordInput;
    TextView tvLoginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        etUsernameInput = findViewById(R.id.etUsernameInput);
        etPasswordInput = findViewById(R.id.etPasswordInput);
        tvLoginText = findViewById(R.id.tvLoginText);


    }

    //save the user login info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("username", Context.MODE_PRIVATE);
    }

    public void onButtonClick(View view) {
    }
}
