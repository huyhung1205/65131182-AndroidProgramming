package hyhung.baith6_eventhandling_sum_onclick;

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

    // Xử lý chức năng tính tổng - được gọi thông qua android:onClick="calculateSum"
    public void calculateSum(View view) {
        // Lấy đối tượng EditText qua id
        EditText inputA = findViewById(R.id.input_a);
        EditText inputB = findViewById(R.id.input_b);
        EditText resultView = findViewById(R.id.result);

        // Lấy dữ liệu từ các trường nhập
        String strA = inputA.getText().toString();
        String strB = inputB.getText().toString();

        try {
            // Chuyển đổi sang dạng số (double)
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);

            // Tính tổng
            double sum = a + b;

            // Hiển thị kết quả
            if (sum == (long) sum) {
                resultView.setText(String.valueOf((long) sum));
            } else {
                resultView.setText(String.format("%.2f", sum));
            }
        } catch (Exception e) {
            // Xử lý lỗi nếu input không phải là số
            resultView.setText("Vui lòng nhập số hợp lệ");
        }
    }
}