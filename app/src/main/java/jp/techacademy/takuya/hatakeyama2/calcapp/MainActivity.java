package jp.techacademy.takuya.hatakeyama2.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

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
        BigDecimal leftOperand;
        BigDecimal rightOperand;

        if (mLeftEditText.getText().toString().trim().length()==0 ||
                mRightEditText.getText().toString().trim().length()==0) {
            Toast.makeText(this, R.string.noInput, Toast.LENGTH_LONG).show();
            return;
        }

        try {
            leftOperand=new BigDecimal(mLeftEditText.getText().toString());
            rightOperand=new BigDecimal(mRightEditText.getText().toString());
//            leftOperand = BigDecimal.valueOf(Double.parseDouble(mLeftEditText.getText().toString()));
//            rightOperand = BigDecimal.valueOf(Double.parseDouble(mRightEditText.getText().toString()));
            Log.d("Operand",leftOperand.toString());
            Log.d("Operand",rightOperand.toString());

        } catch (Exception e) {
            Toast.makeText(this, R.string.invalidInputValue, Toast.LENGTH_LONG).show();
            return;
        }
        BigDecimal result = calculate(leftOperand, rightOperand, view);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.resultKey), result);
        startActivity(intent);
    }

    private BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand, View view) {
        BigDecimal result = BigDecimal.valueOf(0);
        switch (view.getId()) {
            case R.id.plusButton:
                result = leftOperand.add(rightOperand);
                break;
            case R.id.minusButton:
                result = leftOperand.subtract(rightOperand);
                break;
            case R.id.multipleButton:
                result = leftOperand.multiply(rightOperand);
                break;
            case R.id.divideButton:
                result = leftOperand.divide(rightOperand,2,BigDecimal.ROUND_HALF_UP);
                break;
        }
        return result;
    }

}
