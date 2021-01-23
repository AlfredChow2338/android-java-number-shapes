package com.example.alfredchow.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number {
        int number;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNum = 1;
            while (triangularNum < number) {
                x++;
                triangularNum += x;
            }

            if(triangularNum == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber (View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        Number myNum = new Number();
        myNum.number = Integer.parseInt(editText.getText().toString());
        String message = editText.getText().toString();
        if(myNum.isSquare() && myNum.isTriangular()) {
            message += " is both square number and triangular number!";
        } else if(myNum.isTriangular()) {
            message += " is a triangular number!";
        } else if(myNum.isSquare()) {
            message += " is a square number!";
        } else {
            message += " is neither a square number or triangular!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
