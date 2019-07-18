package com.arkdev.task05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView helloTV, emailTV;
    Button loginBtn;
    public static final String MY_PREFS_FILE = "login";
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViews();

    }

    @Override
    protected void onResume() {
        super.onStart();
        if (IsSharedPrefsExist()) {
            helloTV.setVisibility(View.VISIBLE);
            emailTV.setVisibility(View.VISIBLE);
            emailTV.setText(email);

        } else {
            loginBtn.setVisibility(View.VISIBLE);
        }

    }

    private void InitViews() {
        helloTV = findViewById(R.id.hello_tv);
        emailTV = findViewById(R.id.email_et);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);

        helloTV.setVisibility(View.GONE);
        emailTV.setVisibility(View.GONE);
        loginBtn.setVisibility(View.GONE);
    }

    private boolean IsSharedPrefsExist() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_FILE, MODE_PRIVATE);
        email = prefs.getString("emailLogin", null);
        return email != null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
