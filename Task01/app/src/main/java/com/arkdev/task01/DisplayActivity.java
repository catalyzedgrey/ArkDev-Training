package com.arkdev.task01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView firstNameET, lastNameET, emailET, phoneET;
    RadioGroup radioGroup;
    RadioButton mRadioBtn, fRadioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        InitComponents();
        FillTextViews();
    }

    private void InitComponents() {
        firstNameET = findViewById(R.id.first_name_et);
        lastNameET = findViewById(R.id.last_name_et);
        emailET = findViewById(R.id.email_et);
        phoneET = findViewById(R.id.phone_et);
        radioGroup = findViewById(R.id.radio_grp);
        mRadioBtn = findViewById(R.id.m_radio_btn);
        fRadioBtn = findViewById(R.id.f_radio_btn);
    }

    private void FillTextViews() {
        Intent i = getIntent();
        firstNameET.setText(i.getStringExtra("fName"));
        lastNameET.setText(i.getStringExtra("lName"));
        emailET.setText(i.getStringExtra("email"));
        phoneET.setText(i.getStringExtra("phone"));

        if (i.getStringExtra("gender").equals("male"))
            mRadioBtn.setChecked(true);
        else if (i.getStringExtra("gender").equals("female"))
            fRadioBtn.setChecked(true);

    }
}
