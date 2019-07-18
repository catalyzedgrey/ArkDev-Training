package com.arkdev.task05;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailET, passET;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitViews();
    }

    private void InitViews() {
        emailET = findViewById(R.id.email_et);
        passET = findViewById(R.id.pass_et);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn) {
            if (!emailET.getText().toString().equals("")
                    && !passET.getText().toString().equals("")) {
                SharedPreferences.Editor editor = getSharedPreferences(MainActivity.MY_PREFS_FILE, MODE_PRIVATE).edit();
                editor.putString("emailLogin", emailET.getText().toString());
                editor.commit();
                onBackPressed();

            }
        }
    }


}
