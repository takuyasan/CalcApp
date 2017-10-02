package jp.techacademy.takuya.hatakeyama2.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra(getString(R.string.resultKey), 0.0);
        TextView resultView = (TextView) findViewById(R.id.resultView);
        resultView.setText(String.valueOf(result));
    }
}
