### 🔵 Lab 01 · View – Layout · Widget

**Mục tiêu:** Học cách thiết kế giao diện Android bằng XML, hiểu các View và Layout cơ bản, tương tác với View trong Java code.

**Thời gian dự kiến:** 1-2 tuần

#### 📚 Lý thuyết cần nắm

##### **1. View và ViewGroup là gì?**

- **View**: Là các thành phần cơ bản của UI Android (TextView, Button, EditText, ImageView, v.v.)
- **ViewGroup** (Layout): Là container chứa nhiều View con, định nghĩa cách sắp xếp (ngang, dọc, tương đối, v.v.)

```
Activity
  ↓
  LinearLayout (ViewGroup)
    ├── TextView (View)
    ├── EditText (View)
    └── Button (View)
```

##### **2. Cách tạo layout:**
- **Dùng XML** (phổ biến): File `res/layout/activity_main.xml`
- **Dùng Java code** (ít dùng): Tạo View runtime

##### **3. `findViewById()` — Lấy tham chiếu View**
```java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(...);
```

##### **4. Layout Parameters**

| Tham số | Mô tả |
|---|---|
| **Margin** | Khoảng cách từ view ra ngoài |
| **Padding** | Khoảng cách từ nội dung ra viền view |
| **Width/Height** | `match_parent`, `wrap_content`, hoặc số dp |

---

#### 🎨 Các loại Layout phổ biến

| Layout | Mục đích | Ưu điểm |
|---|---|---|
| **ConstraintLayout** | Responsive tự động | Flexible, modern |
| **LinearLayout** | Xếp hàng/cột | Đơn giản |
| **RelativeLayout** | Quan hệ tương đối | Linh hoạt |
| **FrameLayout** | Chồng layer | Đơn giản |
| **TableLayout** | Bảng dữ liệu | Cấu trúc rõ ràng |
| **ScrollView** | Cuộn nội dung | Tự động cuộn |

---

#### 📝 Các Widget cơ bản

| Widget | Mục đích | Cách dùng |
|---|---|---|
| **TextView** | Hiển thị text | `android:text="..."`  |
| **EditText** | Nhập liệu | `android:inputType="text"` |
| **Button** | Nút bấm | `android:onClick="..."` |
| **CheckBox** | Chọn nhiều | `android:checked="false"` |
| **RadioButton** | Chọn 1 | Kết hợp với RadioGroup |
| **ImageView** | Hiển thị ảnh | `android:src="@drawable/..."` |
| **Spinner** | Dropdown list | `setAdapter()` |
| **ProgressBar** | Thanh tiến độ | `android:progress="50"` |

---

#### ⚠️ Quy tắc đặt tên ID:
- Button: `btn` + PascalCase → `btnSubmit`
- TextView: `tv` + PascalCase → `tvResult`
- EditText: `edt` + PascalCase → `edtEmail`
- ImageView: `iv` + PascalCase → `ivProfile`
- CheckBox: `cb` + PascalCase → `cbAgree`
- RadioButton: `rb` + PascalCase → `rbMale`

---

#### 📝 Bài 1: App Calculator

**Mục tiêu:** Thực hành LinearLayout, EditText, Button, TextView

**Giao diện:**
- 2 EditText: nhập 2 số
- 4 Button: +, -, ×, ÷
- 1 TextView: hiển thị kết quả

**Layout XML:**
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Calculator"
        android:textSize="28sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="30dp" />
    
    <EditText
        android:id="@+id/edtNum1"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Nhập số thứ nhất"
        android:inputType="numberDecimal"
        android:padding="10dp"
        android:layout_marginBottom="15dp" />
    
    <EditText
        android:id="@+id/edtNum2"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Nhập số thứ hai"
        android:inputType="numberDecimal"
        android:padding="10dp"
        android:layout_marginBottom="20dp" />
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="20dp">
        
        <Button
            android:id="@+id/btnAdd"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="+"
            android:layout_margin="5dp" />
        
        <Button
            android:id="@+id/btnSub"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="-"
            android:layout_margin="5dp" />
        
        <Button
            android:id="@+id/btnMul"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="×"
            android:layout_margin="5dp" />
        
        <Button
            android:id="@+id/btnDiv"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="÷"
            android:layout_margin="5dp" />
    </LinearLayout>
    
    <TextView
        android:id="@+id/tvResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Kết quả: "
        android:textSize="20sp"
        android:padding="15dp"
        android:gravity="center"
        android:background="#E0E0E0" />
</LinearLayout>
```

**Code Java:**
```java
public class MainActivity extends AppCompatActivity {
    private EditText edtNum1, edtNum2;
    private TextView tvResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        tvResult = findViewById(R.id.tvResult);
        
        findViewById(R.id.btnAdd).setOnClickListener(v -> calculate("+"));
        findViewById(R.id.btnSub).setOnClickListener(v -> calculate("-"));
        findViewById(R.id.btnMul).setOnClickListener(v -> calculate("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> calculate("/"));
    }
    
    private void calculate(String operation) {
        try {
            double num1 = Double.parseDouble(edtNum1.getText().toString());
            double num2 = Double.parseDouble(edtNum2.getText().toString());
            double result = 0;
            
            switch(operation) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 != 0) result = num1 / num2;
                    else { tvResult.setText("Lỗi: Không chia cho 0"); return; }
                    break;
            }
            tvResult.setText("Kết quả: " + result);
        } catch (NumberFormatException e) {
            tvResult.setText("Lỗi: Nhập số không hợp lệ");
        }
    }
}
```

---

#### 📝 Bài 2: App Tính BMI

**Mục tiêu:** Thực hành LinearLayout + tính toán

**Giao diện:**
- EditText: cân nặng (kg)
- EditText: chiều cao (cm)
- Button: Tính BMI
- TextView: kết quả + phân loại

**Layout XML:**
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="20dp">
        
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="BMI Calculator"
            android:textSize="28sp"
            android:textStyle="bold"
            android:gravity="center"
            android:layout_marginBottom="30dp" />
        
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Cân nặng (kg):"
            android:textSize="16sp"
            android:layout_marginBottom="5dp" />
        
        <EditText
            android:id="@+id/edtWeight"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:hint="Nhập cân nặng"
            android:inputType="numberDecimal"
            android:padding="10dp"
            android:layout_marginBottom="20dp" />
        
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Chiều cao (cm):"
            android:textSize="16sp"
            android:layout_marginBottom="5dp" />
        
        <EditText
            android:id="@+id/edtHeight"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:hint="Nhập chiều cao"
            android:inputType="numberDecimal"
            android:padding="10dp"
            android:layout_marginBottom="30dp" />
        
        <Button
            android:id="@+id/btnCalculate"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Tính BMI"
            android:textSize="18sp"
            android:layout_marginBottom="20dp" />
        
        <TextView
            android:id="@+id/tvBMI"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="BMI: --"
            android:textSize="24sp"
            android:textStyle="bold"
            android:padding="15dp"
            android:gravity="center"
            android:background="#E0E0E0"
            android:layout_marginBottom="15dp" />
        
        <TextView
            android:id="@+id/tvCategory"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Phân loại: --"
            android:textSize="18sp"
            android:padding="15dp"
            android:gravity="center"
            android:background="#FFE0B2" />
    </LinearLayout>
</ScrollView>
```

**Code Java:**
```java
public class MainActivity extends AppCompatActivity {
    private EditText edtWeight, edtHeight;
    private TextView tvBMI, tvCategory;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        tvBMI = findViewById(R.id.tvBMI);
        tvCategory = findViewById(R.id.tvCategory);
        
        findViewById(R.id.btnCalculate).setOnClickListener(v -> calculateBMI());
    }
    
    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double height = Double.parseDouble(edtHeight.getText().toString()) / 100;
            
            if (weight <= 0 || height <= 0) {
                tvBMI.setText("Lỗi: Giá trị phải lớn hơn 0");
                tvCategory.setText("");
                return;
            }
            
            double bmi = weight / (height * height);
            tvBMI.setText(String.format("BMI: %.1f", bmi));
            
            String category;
            if (bmi < 18.5) category = "Phân loại: Gầy";
            else if (bmi < 25) category = "Phân loại: Bình thường";
            else if (bmi < 30) category = "Phân loại: Thừa cân";
            else category = "Phân loại: Béo phì";
            
            tvCategory.setText(category);
        } catch (NumberFormatException e) {
            tvBMI.setText("Lỗi: Nhập số không hợp lệ");
            tvCategory.setText("");
        }
    }
}
```

---
