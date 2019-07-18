package com.arkdev.task01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText firstNameET, lastNameET, emailET, passET, confirmPassET, phoneET;
    RadioGroup radioGroup;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitComponents();
    }

    private void InitComponents() {
        firstNameET = findViewById(R.id.first_name_et);
        lastNameET = findViewById(R.id.last_name_et);
        emailET = findViewById(R.id.email_et);
        passET = findViewById(R.id.password_et);
        confirmPassET = findViewById(R.id.confirm_password_et);
        phoneET = findViewById(R.id.phone_et);
        radioGroup = findViewById(R.id.radio_grp);
        signUpButton = findViewById(R.id.signup_btn);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signup_btn) {
            if (IsFormFilled() && IsPasswordValid()) {
                Intent i = new Intent(MainActivity.this, DisplayActivity.class);
                FillIntent(i);
                startActivity(i);
            } else {
                Toast.makeText(this, "Fill out all the fields", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean IsFormFilled() {
        if (!firstNameET.getText().toString().equals("")
                && !lastNameET.getText().toString().equals("")
                && !emailET.getText().toString().equals("")
                && !passET.getText().toString().equals("")
                && !confirmPassET.getText().toString().equals("")
                && !phoneET.getText().toString().equals("")
                && radioGroup.getCheckedRadioButtonId() != -1)
            return true;
        return false;
    }

    private boolean IsPasswordValid() {
        if (passET.getText().toString().equals(confirmPassET.getText().toString()))
            return true;
        return false;
    }

    private void FillIntent(Intent i) {
        i.putExtra("fName", firstNameET.getText().toString());
        i.putExtra("lName", lastNameET.getText().toString());
        i.putExtra("email", emailET.getText().toString());
        i.putExtra("phone", phoneET.getText().toString());
        if (radioGroup.getCheckedRadioButtonId() == R.id.m_radio_btn)
            i.putExtra("gender", "male");
        else if (radioGroup.getCheckedRadioButtonId() == R.id.f_radio_btn)
            i.putExtra("gender", "female");
    }
}