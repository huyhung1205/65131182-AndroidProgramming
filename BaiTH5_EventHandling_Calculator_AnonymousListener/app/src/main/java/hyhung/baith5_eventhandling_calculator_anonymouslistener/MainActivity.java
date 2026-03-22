package hyhung.baith5_eventhandling_calculator_anonymouslistener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Các thành phần giao diện
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnReset;
    private EditText inputA, inputB, result;

    // Biến để lưu giá trị tính toán
    private double a, b, kq;

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

        // Thiết lập bộ lắng nghe ẩn danh cho các nút
        setupAnonymousListeners();
    }

    // Hàm lấy đối tượng cho từng nút, giá trị đầu vào, đầu ra
    private void getButtonAndText() {
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnReset = findViewById(R.id.btn_reset);
        inputA = findViewById(R.id.input_a);
        inputB = findViewById(R.id.input_b);
        result = findViewById(R.id.result);
    }

    // Thiết lập bộ lắng nghe ẩn danh cho các nút
    private void setupAnonymousListeners() {
        // Nút Cộng (+)
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData();
                    kq = a + b;
                    displayResult();
                } catch (Exception e) {
                    result.setText(e.getMessage());
                }
            }
        });

        // Nút Trừ (-)
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData();
                    kq = a - b;
                    displayResult();
                } catch (Exception e) {
                    result.setText(e.getMessage());
                }
            }
        });

        // Nút Nhân (*)
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData();
                    kq = a * b;
                    displayResult();
                } catch (Exception e) {
                    result.setText(e.getMessage());
                }
            }
        });

        // Nút Chia (/)
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData();
                    if (b == 0) {
                        throw new Exception("Lỗi: Không thể chia cho 0!");
                    }
                    kq = a / b;
                    displayResult();
                } catch (Exception e) {
                    result.setText(e.getMessage());
                }
            }
        });

        // Nút Reset
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
            }
        });
    }

    // Hàm lấy dữ liệu từ các trường nhập
    private void getData() throws Exception {
        try {
            a = Double.parseDouble(inputA.getText().toString().trim());
            b = Double.parseDouble(inputB.getText().toString().trim());
        } catch (Exception e) {
            throw new Exception("Lỗi: Vui lòng nhập số hợp lệ");
        }
    }

    // Hàm hiển thị kết quả
    private void displayResult() {
        if (kq == (long) kq) {
            result.setText(String.valueOf((long) kq));
        } else {
            result.setText(String.format("%.2f", kq));
        }
    }

    // Hàm xóa sạch đầu vào và đầu ra
    private void resetAll() {
        inputA.setText("");
        inputB.setText("");
        result.setText("");
        inputA.requestFocus();
    }
}