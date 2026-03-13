package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        // Lấy thông tin các đối tượng từ view
        getButtonAndText();
        // Logic các nút
        // Nút X
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoaText(v);
            }
        });
        // Nút +
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData(v);
                    double sum = a + b;
                    strKetQua.setText(String.format("%.2f", sum));
                } catch (Exception e) {
                    strKetQua.setText(e.getMessage());
                }
            }
        });
        // Nút -
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData(v);
                    double sum = a - b;
                    strKetQua.setText(String.format("%.2f", sum));
                } catch (Exception e) {
                    strKetQua.setText(e.getMessage());
                }
            }
        });
        // Nút *
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData(v);
                    double sum = a * b;
                    strKetQua.setText(String.format("%.2f", sum));
                } catch (Exception e) {
                    strKetQua.setText(e.getMessage());
                }
            }
        });
        // Nút /
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData(v);
                    if (b == 0)
                        throw new Exception("Lỗi chia 0!");
                    double sum = a * b;
                    strKetQua.setText(String.format("%.2f", sum));
                } catch (Exception e) {
                    strKetQua.setText(e.getMessage());
                }
            }
        });
    }

    Button cong, tru, nhan, chia, xoa;
    EditText strA, strB, strKetQua;

    // Hàm lấy đổi tượng cho từng nút, giá trị đầu vào, đầu ra
    public void getButtonAndText() {
        cong = findViewById(R.id.btnCong);
        tru = findViewById(R.id.btnTru);
        nhan = findViewById(R.id.btnNhan);
        chia = findViewById(R.id.btnChia);
        xoa = findViewById(R.id.btnXoa);
        strA = findViewById(R.id.inputA);
        strB = findViewById(R.id.inputB);
        strKetQua = findViewById(R.id.outputKetQua);
    }

    // hàm xóa sạch đầu vào và đầu ra
    public void xoaText(View view) {
        strA.setText("");
        strB.setText("");
        strKetQua.setText("");
    }

    double a, b, kq;

    // Hàm chuyển input string sang double
    public void getData(View view) throws Exception {
        try {
            a = Double.parseDouble(String.valueOf(strA.getText()).trim());
            b = Double.parseDouble(String.valueOf(strB.getText()).trim());
        } catch (Exception e) {
            throw new Exception("Nhập số");
        }
    }
}