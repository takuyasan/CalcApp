package jp.techacademy.takuya.hatakeyama2.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.math.BigDecimal;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        BigDecimal result = (BigDecimal) intent.getSerializableExtra(getString(R.string.resultKey));
        TextView resultView = (TextView) findViewById(R.id.resultView);
        resultView.setText(result.toString());
    }
}
