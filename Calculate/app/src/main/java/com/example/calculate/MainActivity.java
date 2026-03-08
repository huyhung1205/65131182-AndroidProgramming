package com.example.calculate;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Hàm phép tính
    public double calculate(double a, double b, char pt) throws Exception{
        switch (pt){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return 0.00001;
    }
    // Hàm lấy đối tượng, gán giá trị và tính toán
    public void validate(View view, char c){
        // Lấy đối tượng
        EditText getA = findViewById(R.id.inputA);
        EditText getB = findViewById(R.id.inputB);
        EditText getKQ = findViewById(R.id.outputKQ);
        // Lấy giá trị
        String a = getA.getText().toString();
        String b = getB.getText().toString();
        double kq;
        try {
            // Chuyển giá trị sang số
            double da = Double.parseDouble(a);
            double db = Double.parseDouble(b);
            kq = calculate(da, db, c);
            // Hiển thị kết quả
            getKQ.setText(String.valueOf(kq));
        } catch (Exception e){
            if(c != '/')
                getKQ.setText("Nhập số!");
            else
                getKQ.setText("Lỗi nhập b!");
        }
    }
    public void clear(View view){
        EditText getA = findViewById(R.id.inputA);
        EditText getB = findViewById(R.id.inputB);
        EditText getKQ = findViewById(R.id.outputKQ);
        getA.setText("");
        getB.setText("");
        getKQ.setText("");
    }
    public void cong(View view){
        validate(view, '+');
    }
    public void tru(View view){
        validate(view, '-');
    }
    public void nhan(View view){
        validate(view, '*');
    }
    public void chia(View view){
        validate(view, '/');

    }
}