package com.example.calculatesum;

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

    }

    // Xử lý chức năng cộng
    public void sum(View view){
        // Lấy đối tượng qua id
        EditText soA = findViewById(R.id.ida);
        EditText soB = findViewById(R.id.idb);
        EditText kq = findViewById(R.id.idkq);
        // Lấy data cho các biến
        String strA = soA.getText().toString();
        String strB = soB.getText().toString();
        try {
            // Chuyển sang dạng số
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);
            // Tính toán
            int sum = a + b;
            // Hiện dữ lệu
            kq.setText(String.valueOf(sum));
        } catch (Exception e){
            kq.setText("Hãy nhập số");
        }
    }
}