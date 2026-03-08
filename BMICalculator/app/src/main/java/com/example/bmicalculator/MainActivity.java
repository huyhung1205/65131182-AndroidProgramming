package com.example.bmicalculator;

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
    public void clean(View view){
        // Lấy đối tượng
        EditText w = findViewById(R.id.w);
        EditText h = findViewById(R.id.h);
        EditText kq = findViewById(R.id.kq);
        EditText kq2 = findViewById(R.id.kq2);
        // Xóa dữ liệu
        w.setText("");
        h.setText("");
        kq.setText("");
        kq2.setText("");
    }
    public void calculate(View view){
        // Lấy đối tượng
        EditText w = findViewById(R.id.w);
        EditText h = findViewById(R.id.h);
        EditText kq = findViewById(R.id.kq);
        EditText kq2 = findViewById(R.id.kq2);
        // Lấy dữ liệu
        String strW = w.getText().toString();
        String strH = h.getText().toString();
        double dw, dh, bmi;
        // Chuyển dữ liệu sang số thực
        try {
            dw = Double.parseDouble(strW);
        } catch (Exception e){
            kq.setText("Nhập weight là số!");
            return;
        }
        try {
            dh = Double.parseDouble(strH);
        } catch (Exception e){
            kq.setText("Nhập height là số!");
            return;
        }
        if (dh == 0) {
            kq.setText("Nhập height khác 0!");
            return;
        }
        // Tính toán BMI
        double heightInMeters = dh / 100.0;
        bmi = dw / (heightInMeters * heightInMeters);
        // Hiển thị giá trị BMI
        kq.setText("BMI = " + String.format("%.2f", bmi));

        // Phân loại theo WHO
        if (bmi < 18.5) {
            kq2.setText("Cân nặng thấp - Gầy");
        } else if (bmi < 25) {
            kq2.setText("Bình thường");
        } else if (bmi < 30) {
            kq2.setText("Thừa cân - Tiền béo phì");
        } else if (bmi < 35) {
            kq2.setText("Béo phì độ I");
        } else if (bmi < 40) {
            kq2.setText("Béo phì độ II");
        } else {
            kq2.setText("Béo phì độ III");
        }
    }
}
