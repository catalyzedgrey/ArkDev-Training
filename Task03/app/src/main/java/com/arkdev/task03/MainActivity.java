package com.arkdev.task03;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1ET, num2ET;
    Button executeButton;
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViews();
    }

    private void InitViews() {
        num1ET = findViewById(R.id.num1_et);
        num2ET = findViewById(R.id.num2_et);
        resultTV = findViewById(R.id.result_tv);
        executeButton = findViewById(R.id.execute_btn);
        executeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.execute_btn) {
            float num1 = Float.parseFloat(num1ET.getText().toString());
            float num2 = Float.parseFloat(num2ET.getText().toString());
            new SumTask().execute(num1, num2);
        }
    }

    private class SumTask extends AsyncTask<Float, Float, Float> {
        @Override
        protected Float doInBackground(Float... floats) {
            return floats[0] + floats[1];
        }

        @Override
        protected void onPostExecute(Float result) {
            resultTV.setText(String.valueOf(result));
        }
    }


}
