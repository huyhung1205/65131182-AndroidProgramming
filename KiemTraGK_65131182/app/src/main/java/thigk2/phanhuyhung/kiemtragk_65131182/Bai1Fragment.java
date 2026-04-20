package thigk2.phanhuyhung.kiemtragk_65131182;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.TextView;

public class Bai1Fragment extends Fragment {

    private TextInputEditText etLength;
    private TextInputEditText etWidth;
    private MaterialButton btnCalculate;
    private TextView tvResult;

    public Bai1Fragment() {
        super(R.layout.fragment_bai1);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Ánh xạ các View từ XML
        etLength = view.findViewById(R.id.et_length);
        etWidth = view.findViewById(R.id.et_width);
        btnCalculate = view.findViewById(R.id.btn_calculate);
        tvResult = view.findViewById(R.id.tv_result);

        // Xử lý sự kiện click nút "Tính diện tích"
        btnCalculate.setOnClickListener(v -> calculateArea());
    }

    private void calculateArea() {
        // Lấy giá trị từ các ô nhập
        String lengthStr = etLength.getText().toString().trim();
        String widthStr = etWidth.getText().toString().trim();

        // Kiểm tra xem các ô có trống không
        if (lengthStr.isEmpty() || widthStr.isEmpty()) {
            showError("Vui lòng nhập đầy đủ chiều dài và chiều rộng");
            return;
        }

        try {
            // Chuyển đổi String thành Double
            double length = Double.parseDouble(lengthStr);
            double width = Double.parseDouble(widthStr);

            // Kiểm tra xem chiều dài và chiều rộng có > 0 không
            if (length <= 0 || width <= 0) {
                showError("Chiều dài và chiều rộng phải lớn hơn 0");
                return;
            }

            // Tính diện tích
            double area = length * width;

            // Làm tròn 2 chữ số sau dấu phẩy và hiển thị
            String resultText = String.format("%.2f", area);
            tvResult.setText(resultText);

        } catch (NumberFormatException e) {
            showError("Vui lòng nhập số hợp lệ");
        }
    }

    private void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}