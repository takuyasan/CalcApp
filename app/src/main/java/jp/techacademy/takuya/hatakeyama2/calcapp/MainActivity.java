package jp.techacademy.takuya.hatakeyama2.calcapp;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mLeftEditText;
    private EditText mRightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftEditText = (EditText) findViewById(R.id.leftOperand);
        mRightEditText = (EditText) findViewById(R.id.rightOperand);
    }

    public void displayResult(View view) {
        double leftOperand = 0;
        double rightOperand = 0;

        if (mLeftEditText == null || mRightEditText == null) {
            Toast.makeText(this, R.string.noInput, Toast.LENGTH_LONG).show();
            return;
        }

        try {
            leftOperand = Double.parseDouble(mLeftEditText.getText().toString());
            rightOperand = Double.parseDouble(mRightEditText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, R.string.invalidInputValue, Toast.LENGTH_LONG).show();
            return;
        }
        double result = calculate(leftOperand, rightOperand, view);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.resultKey), result);
        startActivity(intent);
    }

    private double calculate(double leftOperand, double rightOperand, View view) {
        double result = 0;
        switch (view.getId()) {
            case R.id.plusButton:
                result = leftOperand + rightOperand;
                break;
            case R.id.minusButton:
                result = leftOperand - rightOperand;
                break;
            case R.id.multipleButton:
                result = leftOperand * rightOperand;
                break;
            case R.id.divideButton:
                result = leftOperand / rightOperand;
                break;
        }
        return result;
    }

}
