### 🟣 Lab 02 · Lắng nghe và Xử lý sự kiện (Event Handling)

**Mục tiêu:** Nắm vững 5 cách xử lý sự kiện trong Android Java.

**Thời gian dự kiến:** 1-2 tuần

#### 📚 Lý thuyết: Sự kiện là gì?

- **Event**: Hành động của người dùng (click, nhập text, cuộn...)
- **Listener**: Object nghe/lắng nghe sự kiện
- **Handler**: Phương thức xử lý khi sự kiện xảy ra

```
User clicks button  →  Listener detects  →  Handler executes
```

---

#### 5 cách xử lý sự kiện

##### **Cách 1: XML onClick Attribute**

```xml
<Button
    android:id="@+id/btnSubmit"
    android:onClick="handleSubmit" />
```

```java
public void handleSubmit(View v) {
    Toast.makeText(this, "Bấm nút", Toast.LENGTH_SHORT).show();
}
```

**Ưu:** Nhanh, đơn giản  
**Nhược:** Logic rải rác

---

##### **Cách 2: Anonymous Listener**

```java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Bấm nút", Toast.LENGTH_SHORT).show();
    }
});
```

**Ưu:** Logic tập trung, phổ biến  
**Nhược:** Code dài

---

##### **Cách 3: Lambda Expression**

```java
btnSubmit.setOnClickListener(v -> {
    Toast.makeText(MainActivity.this, "Bấm nút", Toast.LENGTH_SHORT).show();
});
```

**Ưu:** Ngắn gọn, hiện đại  
**Nhược:** Chỉ cho single method interface

---

##### **Cách 4: Activity Implements OnClickListener**

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            Toast.makeText(this, "Cộng", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnSub) {
            Toast.makeText(this, "Trừ", Toast.LENGTH_SHORT).show();
        }
    }
}
```

**Ưu:** Quản lý nhiều button dễ  
**Nhược:** Code dài, if-else/switch

---

##### **Cách 5: Explicit Listener Class**

```java
// MyClickListener.java
public class MyClickListener implements View.OnClickListener {
    private Context context;
    
    public MyClickListener(Context context) {
        this.context = context;
    }
    
    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Bấm nút", Toast.LENGTH_SHORT).show();
    }
}

// MainActivity.java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new MyClickListener(this));
```

**Ưu:** Architecture rõ ràng, dễ test  
**Nhược:** Tạo nhiều file

---

#### 📝 Demo: App 5 Cách Xử Lý Sự Kiện

**Giao diện:**
- 5 Button (mỗi cách 1 button)
- TextView hiển thị button nào được bấm

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
        android:text="5 Cách Xử Lý Sự Kiện"
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="30dp" />
    
    <Button
        android:id="@+id/btnWay1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 1: XML onClick"
        android:onClick="handleWay1"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:id="@+id/btnWay2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 2: Anonymous"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:id="@+id/btnWay3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 3: Lambda"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:id="@+id/btnWay4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 4: Activity Implements"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:id="@+id/btnWay5"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 5: Explicit Class"
        android:layout_marginBottom="30dp" />
    
    <TextView
        android:id="@+id/tvResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Kết quả: ?"
        android:textSize="18sp"
        android:padding="15dp"
        android:background="#E0E0E0"
        android:gravity="center" />
</LinearLayout>
```

**Code Java:**
```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvResult = findViewById(R.id.tvResult);
        
        // Cách 2: Anonymous
        findViewById(R.id.btnWay2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("Cách 2: Anonymous");
            }
        });
        
        // Cách 3: Lambda
        findViewById(R.id.btnWay3).setOnClickListener(v -> 
            tvResult.setText("Cách 3: Lambda")
        );
        
        // Cách 4: Activity Implements
        findViewById(R.id.btnWay4).setOnClickListener(this);
        findViewById(R.id.btnWay5).setOnClickListener(this);
    }
    
    // Cách 1: XML onClick
    public void handleWay1(View v) {
        tvResult.setText("Cách 1: XML onClick");
    }
    
    // Cách 4: Activity Implements
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnWay4) {
            tvResult.setText("Cách 4: Activity Implements");
        } else if (v.getId() == R.id.btnWay5) {
            tvResult.setText("Cách 5: Explicit Class");
        }
    }
}
```

---

#### 🎯 So sánh 5 cách

| Cách | Khi nào dùng | Độ phức tạp |
|---|---|---|
| XML onClick | Sự kiện đơn giản | ⭐ |
| Anonymous | Phổ biến, 1 button | ⭐⭐ |
| Lambda | Modern, ngắn gọn | ⭐⭐ |
| Activity Implements | Nhiều button cùng handler | ⭐⭐⭐ |
| Explicit Class | Architecture sạch, test | ⭐⭐⭐ |

---

#### 📢 Bonus: Toast - Hiển thị thông báo nhanh

**Toast** là widget dùng để hiển thị thông báo ngắn hạn cho người dùng (không block UI, tự biến mất).

##### **Cú pháp cơ bản:**
```java
Toast.makeText(context, "Tin nhắn", duration).show();
```

**Tham số:**
- `context`: Thường là `this` (từ Activity)
- `message`: Text hiển thị
- `duration`: `Toast.LENGTH_SHORT` (2 giây) hoặc `Toast.LENGTH_LONG` (3.5 giây)

##### **Ví dụ 1: Toast đơn giản**
```java
Toast.makeText(MainActivity.this, "Bấm nút thành công!", Toast.LENGTH_SHORT).show();
```

##### **Ví dụ 2: Toast trong click listener**
```java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(v -> {
    String input = edtName.getText().toString();
    Toast.makeText(MainActivity.this, "Xin chào " + input, Toast.LENGTH_SHORT).show();
});
```

##### **Ví dụ 3: Toast với thao tác form**
```java
public class MainActivity extends AppCompatActivity {
    private EditText edtEmail;
    private Button btnSubmit;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtEmail = findViewById(R.id.edtEmail);
        btnSubmit = findViewById(R.id.btnSubmit);
        
        btnSubmit.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            
            if (email.isEmpty()) {
                Toast.makeText(this, "Email không được để trống!", Toast.LENGTH_SHORT).show();
            } else if (!email.contains("@")) {
                Toast.makeText(this, "Email không hợp lệ!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Email: " + email, Toast.LENGTH_LONG).show();
            }
        });
    }
}
```

##### **Ví dụ 4: Toast trong Activity Implements**
```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNum1, edtNum2;
    private Button btnAdd, btnSub;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        try {
            double num1 = Double.parseDouble(edtNum1.getText().toString());
            double num2 = Double.parseDouble(edtNum2.getText().toString());
            double result = 0;
            String operation = "";
            
            if (v.getId() == R.id.btnAdd) {
                result = num1 + num2;
                operation = "Cộng";
            } else if (v.getId() == R.id.btnSub) {
                result = num1 - num2;
                operation = "Trừ";
            }
            
            Toast.makeText(this, operation + ": " + result, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Nhập số không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
```

##### **💡 So sánh Toast vs Snackbar vs AlertDialog**

| Thành phần | Thời gian | Hành động | Dùng khi |
|---|---|---|---|
| **Toast** | Tự biến (2-3s) | Không có | Thông báo đơn giản |
| **Snackbar** | Tự biến hoặc BN bấm | Có nút hành động | Phản hồi tác vụ |
| **AlertDialog** | Block UI (BN phải bấm) | Có nút OK/Cancel | Xác nhận quan trọng |

**→ Dùng Toast cho thông báo nhanh, không cần tương tác!**

##### **⚠️ Lưu ý khi dùng Toast:**
- ✅ Dùng trong `onClick()`, `onSuccess()`, `onError()`
- ✅ Hiển thị thông báo ngắn, dễ hiểu
- ❌ Không dùng cho thông báo quan trọng (dùng AlertDialog)
- ❌ Không overlap nhiều Toast (tạo queue dài)

---

##### **🔧 Giải pháp: Tránh Toast Queue**

**Vấn đề:** Khi bấm nút liên tục, Toast sẽ xếp hàng và hiển thị lần lượt → khó chịu!

**Giải pháp:** Lưu reference của Toast hiện tại, cancel nó trước khi show Toast mới.

```java
public class MainActivity extends AppCompatActivity {
    private Toast currentToast;  // ← Lưu Toast hiện tại
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btnSubmit).setOnClickListener(v -> {
            showToastSingle("Dữ liệu đã gửi!");
        });
    }
    
    // Phương thức show Toast (không queue)
    private void showToastSingle(String message) {
        if (currentToast != null) {
            currentToast.cancel();  // ← Hủy Toast cũ
        }
        currentToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        currentToast.show();
    }
}
```

**Cách hoạt động:**
```
Bấm nút lần 1 → Toast A hiển thị
Bấm nút lần 2 → Toast A bị cancel (mất) → Toast B hiển thị
Bấm nút lần 3 → Toast B bị cancel (mất) → Toast C hiển thị
```

**Ví dụ thực tế: Form có nhiều validation**

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private Toast currentToast;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        
        btnLogin.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        
        // Kiểm tra email
        if (email.isEmpty()) {
            showToastSingle("❌ Email không được để trống!");
            return;
        }
        
        // Kiểm tra format email
        if (!email.contains("@")) {
            showToastSingle("❌ Email không hợp lệ!");
            return;
        }
        
        // Kiểm tra mật khẩu
        if (password.isEmpty()) {
            showToastSingle("❌ Mật khẩu không được để trống!");
            return;
        }
        
        // Kiểm tra độ dài mật khẩu
        if (password.length() < 6) {
            showToastSingle("❌ Mật khẩu phải ≥ 6 ký tự!");
            return;
        }
        
        // Thành công
        showToastSingle("✅ Đăng nhập thành công!");
    }
    
    // Phương thức show Toast (không queue)
    private void showToastSingle(String message) {
        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        currentToast.show();
    }
}
```

**Kết quả:** Mỗi lần bấm, Toast cũ mất ngay → chỉ hiển thị Toast mới nhất! ✨

**💡 Tip:**
- Dùng phương thức `showToastSingle()` thay vì gọi `Toast.makeText()` nhiều chỗ
- Giảm code lặp lại, dễ bảo trì
- Có thể tạo Utility class để tái sử dụng

---
