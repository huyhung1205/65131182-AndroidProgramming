# Repo học Thiết bị di động - Java Native

> Tài liệu và code thực hành môn **Lập trình Thiết bị Di động** với Android Native (Java)  
> Giảng viên: Mai Cường Thọ · Cập nhật 2024

---

## 🎯 Mục tiêu

- Nắm vững nền tảng lập trình Android Native bằng **Java**
- Thực hành đầy đủ các Lab theo tài liệu trường
- Xây dựng được ứng dụng Android hoàn chỉnh từ UI → xử lý sự kiện → danh sách dữ liệu
- Làm nền tảng vững chắc để học tiếp các chủ đề nâng cao: MVVM, Room, Retrofit...

---

## 📁 Nội dung repo

```
mobile-java-native/
│
├── README.md                     # File này (hướng dẫn setup, lộ trình học)
│
├── Lab01-Layout-Widget/          # 🔵 Lab 01 · View, Layout, Widget
│   ├── README.md                 # Tài liệu chi tiết Lab 01
│   ├── app-phep-toan/            # App phép toán số học
│   └── app-bmi/                  # App tính BMI
│
├── Lab02-Su-kien/                # 🟣 Lab 02 · Xử lý sự kiện (Event Handling)
│   ├── README.md                 # Tài liệu chi tiết Lab 02
│   └── demo-5-cach/              # Demo 5 cách xử lý sự kiện
│
├── Lab03-RecyclerView/           # 🟡 Lab 03 · RecyclerView - Danh sách dữ liệu
│   ├── README.md                 # Tài liệu chi tiết Lab 03
│   └── app-landscape/            # App danh sách cảnh đẹp
│
├── docs/                         # 📚 Tài liệu hỗ trợ
│   ├── Lab01-View-Layout-Widget.md
│   └── Lab02-Event-Handling.md
│
└── notes/                        # Ghi chú lý thuyết
    └── (coming soon)
```

---

## 🎯 Hướng dẫn nhanh - Bắt đầu từ đâu?

### 🔵 **[Lab 01 · View – Layout · Widget](Lab01-Layout-Widget/README.md)** 
Học thiết kế giao diện XML, View cơ bản, tương tác Java
- Tài liệu: [Lab01-Layout-Widget/README.md](Lab01-Layout-Widget/README.md)
- **Bài 1:** App Calculator (phép toán +, -, ×, ÷)
- **Bài 2:** App BMI Calculator (tính chỉ số BMI)

### 🟣 **[Lab 02 · Event Handling](Lab02-Su-kien/README.md)**
Nắm 5 cách xử lý sự kiện click, listener, handler
- Tài liệu: [Lab02-Su-kien/README.md](Lab02-Su-kien/README.md)
- **Bài:** Demo 5 cách xử lý sự kiện so sánh
- Cách 1: XML onClick | Cách 2: Anonymous | Cách 3: Lambda
- Cách 4: Activity Implements | Cách 5: Explicit Class

### 🟡 **[Lab 03 · RecyclerView](Lab03-RecyclerView/README.md)**
Xây dựng danh sách hiệu năng cao, Adapter Pattern, CardView
- Tài liệu: [Lab03-RecyclerView/README.md](Lab03-RecyclerView/README.md)
- **Bài:** App Danh sách cảnh đẹp (ảnh + tên + click)
- LayoutManager: Linear, Grid, Staggered
- Model → Adapter → ViewHolder → RecyclerView

---

---

## 🗺️ Lộ trình học

> Lộ trình được xây dựng theo đúng thứ tự 3 Lab của tài liệu trường.  
> Yêu cầu đầu vào: đã có kiến thức **Java cơ bản** (OOP, Collection, Exception).

---

### ⚙️ Cài đặt môi trường (Trước tất cả)

#### Bước 1: Cài đặt Java Development Kit (JDK)
- Tải **JDK 17+** từ [Oracle](https://www.oracle.com/java/technologies/downloads/) hoặc [OpenJDK](https://jdk.java.net/)
- Cài đặt (Windows: vào Systems Variables → Thêm JAVA_HOME)
- Kiểm tra: Mở Command Prompt gõ `java -version`

#### Bước 2: Cài đặt Android Studio
- Tải từ [developer.android.com](https://developer.android.com/studio)
- Cài đặt phiên bản mới nhất (Hedgehog trở lên)
- Cho phép cài Android SDK (sẽ cài tự động khi khởi động lần đầu)

#### Bước 3: Tạo Android Emulator
- Mở Android Studio → **Device Manager** → Tạo Virtual Device mới
- Chọn **Phone** (ví dụ: Pixel 5)
- Chọn **System Image** API 33+ (Android 13 trở lên)
- Nhấn **Finish** và khởi động emulator

#### Bước 4: Tạo Project đầu tiên
- **File** → **New** → **New Android Project**
- Chọn **Empty Activity** template
- Đặt tên project: `HelloAndroid`
- Language: **Java** (không phải Kotlin)
- Minimum SDK: **API 24** (Android 7.0)
- Nhấn **Finish**

---

### 🔵 Lab 01 · View – Layout · Widget

**Mục tiêu:** Học cách thiết kế giao diện Android bằng XML, hiểu các View và Layout cơ bản, tương tác với View trong Java code.

**Thời gian dự kiến:** 1-2 tuần

#### 📚 Lý thuyết cần nắm

##### **1. View và ViewGroup là gì?**

- **View**: Là các thành phần cơ bản của UI Android (TextView, Button, EditText, ImageView, v.v.). Mỗi View có width, height, padding, margin, color, text style...
- **ViewGroup** (Layout): Là container chứa nhiều View con. Nó định nghĩa cách sắp xếp các View con (ngang, dọc, tương đối, v.v.)

```
Activity
  ↓
  LinearLayout (ViewGroup - chứa các View con)
    ├── TextView (View)
    ├── EditText (View)
    └── Button (View)
```

##### **2. Cách tạo layout:**
- **Dùng XML** (phổ biến, dễ design):  File `res/layout/activity_main.xml`
  - Soạn thông tin ở dạng XML
  - Nạp layout từ XML bằng `setContentView(R.layout.activity_main)`
  - LayoutInflater đọc XML → tạo các thành phần phù hợp
- **Dùng Java code**: Tạo View và add vào UI lúc runtime (ít dùng)
  ```java
  Button myButton = new Button(this);
  myButton.setText("Press me");
  RelativeLayout myLayout = new RelativeLayout(this);
  myLayout.addView(myButton, layoutParams);
  setContentView(myLayout);
  ```

##### **3. `findViewById()` — Lấy tham chiếu View trong Java**
```java
// Trong activity_main.xml có: 
 <Button android:id="@+id/btnSubmit" ... />

// Trong MainActivity.java:
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(...);
```

##### **4. Layout Parameters — Tham số của Layout và View**

Khi một view được đặt vào ViewGroup, nó cần các tham số định vị:

| Tham số | Mô tả | Ví dụ |
|---|---|---|
| **Position (Vị trí)** | Cặp tọa độ Left/Top | Left=10dp, Top=20dp |
| **Size (Kích thước)** | Chiều rộng × Chiều cao | width=200dp, height=100dp |
| **Margin (Lề)** | Khoảng cách từ view ra **ngoài** | `android:layout_margin="16dp"` |
| **Padding (Đệm)** | Khoảng cách từ nội dung ra **viền view** | `android:padding="10dp"` |

**Phân biệt Margin vs Padding:**
```
┌────────────────────────────────────────┐
│ Margin (khoảng cách bên ngoài)         │  ← View khác
│                                        │
│ ┌──────────────────────────────────┐   │
│ │  View hiện tại                   │   │
│ │  ┌──────────────────────────────┐│   │
│ │  │ Padding (khoảng cách trong)  ││   │
│ │  │ ┌──────────────────────────┐ │|   │
│ │  │ │ Nội dung (Text, ảnh...)  │ │|   │
│ │  │ └──────────────────────────┘ │|   │
│ │  └──────────────────────────────┘│   │
│ └──────────────────────────────────┘   │
└────────────────────────────────────────┘
```

**Ví dụ code:**
```xml
<Button
    android:layout_width="100dp"
    android:layout_height="50dp"
    android:text="Bấm tôi"
    android:padding="10dp"              <!-- Lề trong (10dp) -->
    android:layout_margin="20dp" />     <!-- Lề ngoài (20dp) -->
```

---

#### 🎨 Các loại Layout phổ biến (Sắp xếp theo ưu tiên sử dụng)

| Thứ tự | Layout | Cách hoạt động | Dùng khi nào | Độ phức tạp |
|---|---|---|---|---|
| **1️⃣** | **ConstraintLayout** | Dùng **constraint/ràng buộc** để định vị, responsive tự động | Bố cục nâng cao, phải responsive nhiều màn hình, mặc định AS | ⭐⭐⭐ |
| **2️⃣** | **LinearLayout** | Xếp View theo **hàng (horizontal)** hoặc **cột (vertical)**. Quy định bởi thuộc tính `android:orientation="horizontal"` hoặc `android:orientation="vertical"` | Bố cục đơn giản, các phần tử xếp thẳng theo một hướng | ⭐ |
| **3️⃣** | **RelativeLayout** | Vị trí View dựa vào **quan hệ** với view cha hoặc view khác | Bố cục phức tạp, view có vị trí tương đối nhau | ⭐⭐ |
| **4️⃣** | **FrameLayout** | View chồng lên nhau, view sau đè lên view trước | Chồng layer (ví dụ: background + overlay, badge) | ⭐⭐ |
| **5️⃣** | **TableLayout** | Sắp xếp theo **bảng (dòng/cột)** với `<TableRow>` | Bảng dữ liệu, form nhiều trường cấu trúc | ⭐⭐⭐ |
| **6️⃣** | **ScrollView** | Cho phép **cuộn dọc** nội dung dài | Nội dung dài hơn màn hình, kết hợp layout khác | ⭐⭐ |

---

##### **1️⃣ ConstraintLayout** (Phổ biến nhất, khuyến nghị dùng)

```xml
<!-- res/layout/activity_main.xml -->
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="20dp">
    
    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Welcome to Android"
        android:textSize="24sp"
        android:gravity="center"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toTopOf="@id/btnSubmit" />
    
    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Click me"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

**Ưu điểm:** Responsive, responsive tự động, dễ tinh chỉnh vị trí  
**Nhược điểm:** Cú pháp phức tạp hơn LinearLayout

---

##### **2️⃣ LinearLayout** (Cơ bản, dễ học)

```xml
<!-- res/layout/activity_linear.xml -->
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="LinearLayout Vertical"
        android:textSize="24sp"
        android:gravity="center"
        android:layout_marginBottom="20dp" />
    
    <EditText
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Nhập tên"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Submit" />
</LinearLayout>
```

**Ưu điểm:** Đơn giản, thân thiện cho người mới  
**Nhược điểm:** Khó để responsive nhiều kích thước màn hình

---

##### **3️⃣ RelativeLayout** (Tương đối, phức tạp hơn)

```xml
<!-- res/layout/activity_relative.xml -->
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="20dp">
    
    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="RelativeLayout"
        android:textSize="24sp"
        android:gravity="center"
        android:layout_alignParentTop="true"
        android:layout_marginBottom="20dp" />
    
    <EditText
        android:id="@+id/edtInput"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Nhập dữ liệu"
        android:layout_below="@id/tvTitle"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Submit"
        android:layout_below="@id/edtInput"
        android:layout_alignParentBottom="true" />
</RelativeLayout>
```

**Ưu điểm:** Vị trí view linh hoạt, dễ xếp phức tạp  
**Nhược điểm:** Code khó đọc, khó maintain

---

##### **4️⃣ FrameLayout** (Chồng layer)

```xml
<!-- res/layout/activity_frame.xml -->
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <!-- View đầu tiên (dưới) -->
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/background"
        android:scaleType="centerCrop" />
    
    <!-- View thứ hai (trên) -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:gravity="center"
        android:background="#80000000">
        
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="FrameLayout - Chồng Layer"
            android:textSize="24sp"
            android:textColor="#FFFFFF"
            android:gravity="center" />
    </LinearLayout>
    
    <!-- Badge (góc trên phải) -->
    <TextView
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:text="5"
        android:textColor="#FFFFFF"
        android:background="#FF0000"
        android:gravity="center"
        android:layout_gravity="top|end"
        android:layout_margin="10dp" />
</FrameLayout>
```

**Ưu điểm:** Đơn giản để chồng layer  
**Nhược điểm:** Chỉ dùng được cho layout chồng

---

##### **5️⃣ TableLayout** (Bảng dữ liệu)

```xml
<!-- res/layout/activity_table.xml -->
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <TableLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:stretchColumns="*"
        android:padding="16dp">
        
        <!-- Header row -->
        <TableRow
            android:layout_marginBottom="8dp"
            android:background="#E0E0E0">
            
            <TextView
                android:text="Tên"
                android:textStyle="bold"
                android:padding="8dp" />
            <TextView
                android:text="Tuổi"
                android:textStyle="bold"
                android:padding="8dp" />
            <TextView
                android:text="Email"
                android:textStyle="bold"
                android:padding="8dp" />
        </TableRow>
        
        <!-- Data row 1 -->
        <TableRow android:layout_marginBottom="8dp">
            <TextView android:text="John" android:padding="8dp" />
            <TextView android:text="25" android:padding="8dp" />
            <TextView android:text="john@gmail.com" android:padding="8dp" />
        </TableRow>
        
        <!-- Data row 2 -->
        <TableRow android:layout_marginBottom="8dp">
            <TextView android:text="Jane" android:padding="8dp" />
            <TextView android:text="23" android:padding="8dp" />
            <TextView android:text="jane@gmail.com" android:padding="8dp" />
        </TableRow>
    </TableLayout>
</ScrollView>
```

**Ưu điểm:** Perfect cho bảng dữ liệu, cấu trúc rõ ràng  
**Nhược điểm:** Cứng nhắc, khó styling

---

##### **6️⃣ ScrollView** (Cuộn nội dung)

```xml
<!-- res/layout/activity_scroll.xml -->
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
            android:text="Terms & Conditions"
            android:textSize="20sp"
            android:textStyle="bold"
            android:layout_marginBottom="15dp" />
        
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/long_terms"
            android:textSize="14sp"
            android:layout_marginBottom="20dp" />
        
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Accept" />
    </LinearLayout>
</ScrollView>
```

**Ưu điểm:** Cuộn dọc tự động, đơn giản  
**Nhược điểm:** Chỉ cuộn dọc (dùng HorizontalScrollView cho ngang)

---

##### **💡 Khi nào dùng Layout nào?**

```
Cần responsive nhiều điện thoại?        → ConstraintLayout ✅
Dạng form đơn giản, xếp từ trên xuống?  → LinearLayout ✅
Chồng hình ảnh + text overlay?           → FrameLayout ✅
Cần bảng dữ liệu cấu trúc?              → TableLayout ✅
Nội dung dài, cần cuộn?                  → ScrollView (+ LinearLayout) ✅
Bố cục phức tạp, nhiều quan hệ?         → RelativeLayout (legacy)
```

---

#### 🎯 Tương tác với các Điều khiển (Widget) trong Java

**Bước 1: Tìm điều khiển cần xử lý**
- Nếu đã có biến lưu trữ → bỏ qua
- Nếu chưa có → dùng `findViewById()` để tìm thông qua ID đã đặt trong XML
```xml
// res/layout/activity_main.xml
// Đặt ID cho các view cần tương tác
<Button
    android:id="@+id/btnSubmit"
    ... />
<TextView
    android:id="@+id/tvResult"
    ... />
<EditText
    android:id="@+id/edtInput"
    ... />
```

```java
// MainActivity.java
// Tìm view từ layout XML
Button btnSubmit = findViewById(R.id.btnSubmit);
TextView tvResult = findViewById(R.id.tvResult);
EditText edtInput = findViewById(R.id.edtInput);
```

**Bước 2: Gọi các phương thức phù hợp**
- Thiết lập text, màu sắc, font
- Hoặc xác định cách xử lý sự kiện

```java
// Thiết lập thuộc tính
btnSubmit.setText("Bấm tôi");
btnSubmit.setBackgroundColor(Color.BLUE);
btnSubmit.setTextColor(Color.WHITE);

// Xử lý sự kiện
btnSubmit.setOnClickListener(v -> {
    String input = edtInput.getText().toString();
    tvResult.setText("Kết quả: " + input);
});
```

**Quy tắc đặt tên ID trong XML:**
```xml
<Button
    android:id="@+id/btnSubmit"  <!-- @+id/tên = tạo ID mới -->
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Submit" />

<TextView
    android:id="@+id/tvResult"  <!-- ID được dùng để tìm kiếm -->
    ... />

<EditText
    android:id="@+id/edtInput"
    ... />
```

**⚠️ Quy tắc đặt tên ID (Convention):**
- Button: `btn` + PascalCase (ví dụ: `btnSubmit`)
- TextView: `tv` + PascalCase (ví dụ: `tvResult`)
- EditText: `edt` + PascalCase (ví dụ: `edtEmail`)
- ImageView: `iv` + PascalCase (ví dụ: `ivProfile`)
- CheckBox: `cb` + PascalCase (ví dụ: `cbAgree`)
- RadioButton: `rb` + PascalCase (ví dụ: `rbMale`)

---



| Widget | Mục đích | Cách dùng | Ví dụ thuộc tính |
|---|---|---|---|
| **TextView** | Hiển thị văn bản (read-only) | `android:text="..."` `android:layout_width="match_parent"` `android:layout_height="wrap_content"` `android:textColor="#RRGGBB"` `android:textSize="18sp"` `android:gravity="center"` | `android:text="Hello"` // Nội dung hiển thị<br/>`android:textSize="18sp"` // Cỡ chữ (10sp, 12sp, 14sp, 16sp, 18sp, 24sp)<br/>`android:textColor="#FF0000"` // Màu chữ<br/>`android:gravity="center"` // Căn chỉnh (left, center, right, top, bottom, center_vertical, center_horizontal)<br/>`android:layout_width="match_parent"` // Chiều rộng (match_parent, wrap_content, số dp)<br/>`android:layout_height="wrap_content"` // Chiều cao (match_parent, wrap_content, số dp) |
| **EditText** | Nhập liệu (text input) | `android:inputType="text\|number"` `android:hint="..."` `android:maxLength="50"` `android:singleLine="false"` | `android:hint="Nhập tên..."` // Văn bản gợi ý<br/>`android:inputType="text"` // Kiểu input (text, number, email, password, phone, decimal, date, time)<br/>`android:maxLength="50"` // Số ký tự tối đa<br/>`android:singleLine="false"` // Cho phép xuống dòng (true: 1 dòng, false: nhiều dòng)<br/>`android:enabled="true"` // Bật/tắt (true: có thể chỉnh, false: chỉ đọc) |
| **Button** | Nút bấm | `android:text="..."` `android:onClick="methodName"` `android:background="@drawable/..."` | `android:text="Bấm tôi"` // Nhãn nút<br/>`android:onClick="onButtonClick"` // Hàm xử lý sự kiện click<br/>`android:textColor="#FFFFFF"` // Màu chữ<br/>`android:backgroundTint="#FF6200EE"` // Màu nền (Android 5.0+)<br/>`android:layout_width="match_parent"` // Chiều rộng |
| **ImageButton** | Nút với hình ảnh | `android:src="@drawable/icon"` `android:scaleType="centerInside"` `android:contentDescription="..."` | `android:src="@drawable/ic_ok"` // Hình ảnh<br/>`android:scaleType="centerInside"` // Cách hiển thị (centerInside, centerCrop, fitCenter, fitXY, fitStart, fitEnd, center)<br/>`android:contentDescription="OK"` // Mô tả cho người dùng khiếm thị |
| **ImageView** | Hiển thị hình ảnh | `android:src="@drawable/image"` `android:scaleType="centerCrop"` `android:adjustViewBounds="true"` | `android:src="@drawable/ic_launcher_background"` // Đường dẫn hình ảnh<br/>`android:scaleType="centerCrop"` // Cách hiển thị (centerCrop, fitCenter, fitXY, center, fitStart, fitEnd, centerInside)<br/>`android:layout_width="200dp"` // Chiều rộng<br/>`android:contentDescription="Profile"` // Mô tả ảnh |
| **CheckBox** | Checkbox (chọn nhiều) | `android:checked="false"` `android:text="..."` `android:onClick="onCheckboxClicked"` | `android:checked="false"` // Trạng thái mặc định (true: chọn, false: chưa chọn)<br/>`android:text="Đồng ý"` // Nhãn checkbox<br/>`android:textSize="14sp"` // Cỡ chữ<br/>`android:onClick="onCheckboxClicked"` // Hàm xử lý sự kiện |
| **RadioGroup + RadioButton** | Radio button (chọn 1 trong nhiều) | `<RadioGroup>` chứa `<RadioButton>` `android:orientation="vertical"` `android:checked="true"` | `android:id="@+id/rgGender"` // ID của RadioGroup<br/>`android:orientation="vertical"` // Sắp xếp (vertical, horizontal)<br/>`android:id="@+id/rbMale"` // ID của RadioButton<br/>`android:text="Nam"` // Nhãn<br/>`android:checked="true"` // Được chọn mặc định |
| **ProgressBar** | Thanh tiến độ | `android:max="100"` `android:progress="50"` `style="@android:style/Widget.ProgressBar.Horizontal"` | `android:max="100"` // Giá trị tối đa<br/>`android:progress="50"` // Giá trị hiện tại (0-100)<br/>`style="@android:style/Widget.ProgressBar.Horizontal"` // Kiểu (Horizontal, default là tròn)<br/>`android:layout_height="8dp"` // Chiều cao thanh |
| **Spinner** | Dropdown list | `android:entries="@array/..."` `setAdapter()` `getSelectedItem()` | `android:id="@+id/spCountry"` // ID Spinner<br/>`android:entries="@array/countries"` // Array dữ liệu (trong arrays.xml)<br/>`getSelectedItem()` // Lấy giá trị chọn<br/>`getSelectedItemPosition()` // Lấy vị trí chọn trong code |
| **AutoCompleteTextView** | Input với gợi ý | `android:threshold="1"` `setAdapter()` `getSelectedItem()` | `android:threshold="1"` // Số ký tự để hiển thị gợi ý<br/>`android:hint="Nhập..."` // Văn bản gợi ý<br/>`setAdapter()` // Gán ArrayAdapter cho gợi ý<br/>`getSelectedItem()` // Lấy giá trị trong code |

---

#### 📝 Ví dụ: Sử dụng các Widget cơ bản

**Layout XML** (`res/layout/activity_widgets_demo.xml`):
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
        
        <!-- 1. TextView: Hiển thị văn bản -->
        <TextView
            android:id="@+id/tvTitle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Demo Các Widget"
            android:textSize="24sp"
            android:textStyle="bold"
            android:gravity="center"
            android:layout_marginBottom="20dp" />
        
        <!-- 2. EditText: Nhập liệu -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Tên của bạn:"
            android:textSize="14sp"
            android:layout_marginBottom="5dp" />
        
        <EditText
            android:id="@+id/edtName"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:hint="Nhập tên..."
            android:inputType="text"
            android:padding="10dp"
            android:layout_marginBottom="20dp" />
        
        <!-- 3. Button: Nút bấm -->
        <Button
            android:id="@+id/btnSubmit"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Submit"
            android:layout_marginBottom="20dp" />
        
        <!-- 4. CheckBox: Hộp kiểm -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Chọn các lựa chọn:"
            android:textSize="14sp"
            android:layout_marginBottom="10dp" />
        
        <CheckBox
            android:id="@+id/cbJava"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Java"
            android:layout_marginBottom="5dp" />
        
        <CheckBox
            android:id="@+id/cbKotlin"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Kotlin"
            android:layout_marginBottom="20dp" />
        
        <!-- 5. RadioButton: Nút radio -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Chọn một lựa chọn:"
            android:textSize="14sp"
            android:layout_marginBottom="10dp" />
        
        <RadioGroup
            android:id="@+id/rgGender"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="20dp">
            
            <RadioButton
                android:id="@+id/rbMale"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Nam" />
            
            <RadioButton
                android:id="@+id/rbFemale"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Nữ" />
        </RadioGroup>
        
        <!-- 6. Spinner: Dropdown -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Chọn quốc gia:"
            android:textSize="14sp"
            android:layout_marginBottom="5dp" />
        
        <Spinner
            android:id="@+id/spCountry"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:layout_marginBottom="20dp" />
        
        <!-- 7. ImageView: Hiển thị ảnh -->
        <ImageView
            android:id="@+id/ivImage"
            android:layout_width="match_parent"
            android:layout_height="150dp"
            android:src="@drawable/ic_launcher_background"
            android:scaleType="centerCrop"
            android:layout_marginBottom="20dp" />
        
        <!-- 8. ProgressBar: Thanh tiến độ -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Thanh tiến độ:"
            android:textSize="14sp"
            android:layout_marginBottom="10dp" />
        
        <ProgressBar
            android:id="@+id/pbLoading"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:max="100"
            android:progress="65"
            android:layout_marginBottom="20dp"
            style="@android:style/Widget.ProgressBar.Horizontal" />
        
        <!-- 9. Kết quả -->
        <TextView
            android:id="@+id/tvResult"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Kết quả sẽ hiển thị ở đây"
            android:padding="15dp"
            android:background="#E0E0E0"
            android:textSize="14sp" />
    </LinearLayout>
</ScrollView>
```

**Java Code** (`MainActivity.java`):
```java
package com.example.widgetsdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private EditText edtName;
    private Button btnSubmit;
    private CheckBox cbJava, cbKotlin;
    private RadioGroup rgGender;
    private Spinner spCountry;
    private TextView tvResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_demo);
        
        // Ánh xạ các widget
        edtName = findViewById(R.id.edtName);
        btnSubmit = findViewById(R.id.btnSubmit);
        cbJava = findViewById(R.id.cbJava);
        cbKotlin = findViewById(R.id.cbKotlin);
        rgGender = findViewById(R.id.rgGender);
        spCountry = findViewById(R.id.spCountry);
        tvResult = findViewById(R.id.tvResult);
        
        // 1. Button - Xử lý click
        btnSubmit.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            
            if (name.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
                return;
            }
            
            // 2. CheckBox - Kiểm tra được chọn hay không
            StringBuilder languages = new StringBuilder();
            if (cbJava.isChecked()) {
                languages.append("Java ");
            }
            if (cbKotlin.isChecked()) {
                languages.append("Kotlin");
            }
            
            // 3. RadioButton - Lấy giá trị được chọn
            int selectedId = rgGender.getCheckedRadioButtonId();
            RadioButton rbSelected = findViewById(selectedId);
            String gender = rbSelected.getText().toString();
            
            // 4. Spinner - Lấy item được chọn
            String country = spCountry.getSelectedItem().toString();
            
            // Hiển thị kết quả
            String result = "Tên: " + name + "\n" +
                           "Giới tính: " + gender + "\n" +
                           "Quốc gia: " + country + "\n" +
                           "Ngôn ngữ: " + languages.toString();
            
            tvResult.setText(result);
        });
        
        // Cấu hình Spinner với dữ liệu
        setupSpinner();
    }
    
    private void setupSpinner() {
        // Dữ liệu cho spinner
        String[] countries = {"Việt Nam", "Thái Lan", "Cam Bốt", "Lào"};
        
        // Tạo adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_spinner_item,
            countries
        );
        
        // Set layout mở rộng của spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // Gán adapter vào spinner
        spCountry.setAdapter(adapter);
    }
}
```

**Giải thích:**

| Widget | Cách sử dụng trong code |
|---|---|
| **TextView** | `tvResult.setText("Text mới")` - Hiển thị hoặc cập nhật text |
| **EditText** | `edtName.getText().toString()` - Lấy text người dùng nhập |
| **Button** | `btnSubmit.setOnClickListener(v -> {...})` - Xử lý sự kiện click |
| **CheckBox** | `cbJava.isChecked()` - Kiểm tra được chọn hay chưa |
| **RadioButton** | `rgGender.getCheckedRadioButtonId()` - Lấy radio được chọn |
| **RadioGroup** | `findViewById(selectedId)` - Lấy RadioButton từ ID |
| **Spinner** | `spCountry.getSelectedItem()` - Lấy item được chọn |
| **ImageView** | `android:src="@drawable/..."` - Đặt hình ảnh từ drawable |
| **ProgressBar** | `pbLoading.setProgress(value)` - Cập nhật tiến độ |

---

#### 📝 Bài 1: App Calculator đơn giản với LinearLayout

**Mục tiêu:** Thực hành LinearLayout, EditText, Button, TextView

**Giao diện:**
- 2 EditText: nhập 2 số
- 4 Button: +, -, ×, ÷
- 1 TextView: hiển thị kết quả

**Bước 1: Tạo layout XML** (`res/layout/activity_main.xml`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:gravity="center">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Calculator"
        android:textSize="28sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="30dp" />
    
    <!-- Input số thứ nhất -->
    <EditText
        android:id="@+id/edtNum1"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Nhập số thứ nhất"
        android:inputType="numberDecimal"
        android:padding="10dp"
        android:layout_marginBottom="15dp" />
    
    <!-- Input số thứ hai -->
    <EditText
        android:id="@+id/edtNum2"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="Nhập số thứ hai"
        android:inputType="numberDecimal"
        android:padding="10dp"
        android:layout_marginBottom="20dp" />
    
    <!-- Hàng nút phép toán -->
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
    
    <!-- Kết quả -->
    <TextView
        android:id="@+id/tvResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Kết quả: "
        android:textSize="20sp"
        android:padding="15dp"
        android:gravity="center"
        android:background="#E0E0E0"
        android:textColor="#000000" />
</LinearLayout>
```

**Bước 2: Viết code Java** (`MainActivity.java`)
```java
package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private EditText edtNum1, edtNum2;
    private Button btnAdd, btnSub, btnMul, btnDiv;
    private TextView tvResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Ánh xạ các view từ XML
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);
        
        // Gán listener cho từng button
        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSub.setOnClickListener(v -> calculate("-"));
        btnMul.setOnClickListener(v -> calculate("*"));
        btnDiv.setOnClickListener(v -> calculate("/"));
    }
    
    private void calculate(String operation) {
        try {
            // Lấy giá trị từ EditText
            double num1 = Double.parseDouble(edtNum1.getText().toString());
            double num2 = Double.parseDouble(edtNum2.getText().toString());
            double result = 0;
            boolean valid = true;
            
            // Thực hiện phép toán
            switch(operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        tvResult.setText("Lỗi: Không chia cho 0");
                        valid = false;
                    }
                    break;
            }
            
            // Hiển thị kết quả
            if (valid) {
                tvResult.setText("Kết quả: " + result);
            }
        } catch (NumberFormatException e) {
            tvResult.setText("Lỗi: Nhập số không hợp lệ");
        }
    }
}
```

---

#### 📝 Bài 2: App Tính BMI

**Mục tiêu:** Thực hành LinearLayout, TableLayout, RadioButton, Spinner

**Giao diện:**
- EditText: nhập cân nặng (kg)
- EditText: nhập chiều cao (cm)
- Button: Tính BMI
- TextView: hiển thị kết quả + phân loại

**Bước 1: Tạo layout XML** (`res/layout/activity_main.xml`)
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
        
        <!-- Cân nặng -->
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
        
        <!-- Chiều cao -->
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
        
        <!-- Nút tính toán -->
        <Button
            android:id="@+id/btnCalculate"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Tính BMI"
            android:textSize="18sp"
            android:layout_marginBottom="20dp" />
        
        <!-- Kết quả -->
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
        
        <!-- Phân loại -->
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

**Bước 2: Viết code Java** (`MainActivity.java`)
```java
package com.example.bmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private EditText edtWeight, edtHeight;
    private Button btnCalculate;
    private TextView tvBMI, tvCategory;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Ánh xạ view
        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvBMI = findViewById(R.id.tvBMI);
        tvCategory = findViewById(R.id.tvCategory);
        
        // Bấm nút tính
        btnCalculate.setOnClickListener(v -> calculateBMI());
    }
    
    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double height = Double.parseDouble(edtHeight.getText().toString()) / 100; // convert cm to m
            
            if (weight <= 0 || height <= 0) {
                tvBMI.setText("Lỗi: Giá trị phải lớn hơn 0");
                tvCategory.setText("");
                return;
            }
            
            double bmi = weight / (height * height);
            tvBMI.setText(String.format("BMI: %.1f", bmi));
            
            // Phân loại BMI
            String category;
            if (bmi < 18.5) {
                category = "Phân loại: Gầy";
            } else if (bmi < 25) {
                category = "Phân loại: Bình thường";
            } else if (bmi < 30) {
                category = "Phân loại: Thừa cân";
            } else {
                category = "Phân loại: Béo phì";
            }
            
            tvCategory.setText(category);
        } catch (NumberFormatException e) {
            tvBMI.setText("Lỗi: Nhập số không hợp lệ");
            tvCategory.setText("");
        }
    }
}
```

---

### 🟣 Lab 02 · Lắng nghe và Xử lý sự kiện (Event Handling)

**Mục tiêu:** Nắm vững 5 cách xử lý sự kiện trong Android Java, biết khi nào dùng cách nào.

**Thời gian dự kiến:** 1-2 tuần

#### 📚 Lý thuyết: Sự kiện (Event) là gì?

- **Event**: Là hành động của người dùng (click button, nhập text, cuộn màn hình...)
- **Listener**: Là object nghe/lắng nghe sự kiện
- **Handler**: Là phương thức xử lý khi sự kiện xảy ra

```
User clicks button  →  Listener detects  →  Handler executes
```

#### 5 cách xử lý sự kiện trong Android

##### **Cách 1: XML onClick Attribute** (Nhanh nhưng rải rác logic)

**Cơ chế:** Khai báo tên phương thức trực tiếp trong thuộc tính `android:onClick` của Button

```xml
<!-- res/layout/activity_main.xml -->
<Button
    android:id="@+id/btnSubmit"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Submit"
    android:onClick="handleSubmit" />
```

```java
// MainActivity.java
public void handleSubmit(View v) {
    Toast.makeText(this, "Bạn bấm nút", Toast.LENGTH_SHORT).show();
}
```

**Ưu điểm:** Nhanh, khai báo đơn giản  
**Nhược điểm:** Logic rải rác giữa XML và Java, khó maintain

---

##### **Cách 2: Inline Anonymous Listener** (Phổ biến nhất)

**Cơ chế:** Tạo listener ẩn danh ngay chỗ gán `setOnClickListener()`

```java
// MainActivity.java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Bạn bấm nút", Toast.LENGTH_SHORT).show();
    }
});
```

**Ưu điểm:** Phổ biến, logic tập trung, dễ debug  
**Nhược điểm:** Code dài, khó tái sử dụng

---

##### **Cách 2.2: Lambda Expression** (Hiện đại nhất) 

**Cơ chế:** Dùng lambda (Java 8+) để viết listener ngắn gọn

```java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(v -> {
    Toast.makeText(MainActivity.this, "Bạn bấm nút", Toast.LENGTH_SHORT).show();
});
```

**Ưu điểm:** Ngắn gọn, hiện đại, dễ đọc  
**Nhược điểm:** Yêu cầu Java 8+, chỉ dùng cho single method interface

---

##### **Cách 3: Activity Implements OnClickListener** (Quản lý nhiều button)

**Cơ chế:** Activity tự cài đặt interface `View.OnClickListener`, nhiều button dùng chung handler

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    private Button btnAdd, btnSub, btnMul, btnDiv;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        
        // Gán cùng listener cho tất cả
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        // Xử lý tất cả click ở đây, dùng if-else hoặc switch
        if (v.getId() == R.id.btnAdd) {
            Toast.makeText(this, "Bấm cộng", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnSub) {
            Toast.makeText(this, "Bấm trừ", Toast.LENGTH_SHORT).show();
        }
        // ...
    }
}
```

**Ưu điểm:** Quản lý nhiều button cễ, tập trung logic  
**Nhược điểm:** Code dài, cần if-else/switch

---

##### **Cách 4: Listener in Variable** (Tái sử dụng)

**Cơ chế:** Lưu listener vào biến, dùng lại cho nhiều button

```java
View.OnClickListener myClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Được bấm", Toast.LENGTH_SHORT).show();
    }
};

btnAdd.setOnClickListener(myClickListener);
btnSub.setOnClickListener(myClickListener);
btnMul.setOnClickListener(myClickListener);
btnDiv.setOnClickListener(myClickListener);
```

**Ưu điểm:** Tái sử dụng, tránh lặp code  
**Nhược điểm:** Khó phân biệt button nào được bấm

---

##### **Cách 5: Explicit Listener Class** (Tường minh nhất)

**Cơ chế:** Tạo class listener riêng implements OnClickListener

```java
// File tách riêng: MyClickListener.java
public class MyClickListener implements View.OnClickListener {
    private Context context;
    
    public MyClickListener(Context context) {
        this.context = context;
    }
    
    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Được bấm từ class riêng", Toast.LENGTH_SHORT).show();
    }
}

// Trong MainActivity.java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new MyClickListener(this));
```

**Ưu điểm:** Tường minh, dễ test, architecture rõ ràng  
**Nhược điểm:** Tạo nhiều file, phức tạp cho app nhỏ

---

##### **Cách 6: View Subclassing** (Tùy biến View)

**Cơ chế:** Tạo custom view bằng cách kế thừa từ widget (Button, EditText, v.v.) và override các method, tích hợp xử lý sự kiện sẵn trong view

```java
// File: CustomButton.java
public class CustomButton extends Button {
    
    public CustomButton(Context context) {
        super(context);
        setupListener();
    }
    
    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupListener();
    }
    
    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupListener();
    }
    
    // Cài đặt sự kiện sẵn trong view
    private void setupListener() {
        setOnClickListener(v -> {
            handleButtonClick();
        });
    }
    
    // Xử lý logic khi button được bấm
    private void handleButtonClick() {
        Toast.makeText(getContext(), "Custom Button clicked! ✨", Toast.LENGTH_SHORT).show();
        // Có thể thêm logic khác ở đây
    }
    
    // Các phương thức tùy biến khác
    public void setBtnStyle(int bgColor, int textColor) {
        setBackgroundColor(bgColor);
        setTextColor(textColor);
    }
}
```

**Dùng Custom View trong Layout XML:**
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    
    <com.example.myapp.CustomButton
        android:id="@+id/customBtn1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Custom Button 1" />
    
    <com.example.myapp.CustomButton
        android:id="@+id/customBtn2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Custom Button 2"
        android:layout_marginTop="10dp" />
</LinearLayout>
```

**Dùng Custom View trong Code:**
```java
// MainActivity.java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        CustomButton btn1 = findViewById(R.id.customBtn1);
        CustomButton btn2 = findViewById(R.id.customBtn2);
        
        // Custom button tự xử lý sự kiện sẵn rồi
        // Nhưng có thể override lại nếu muốn
        btn1.setBtnStyle(Color.BLUE, Color.WHITE);
    }
}
```

**Ưu điểm:** Mạnh mẽ, có thể tùy biến hoàn toàn, tái sử dụng dễ  
**Nhược điểm:** Phức tạp nhất, cần hiểu sâu về View lifecycle

---

#### 📝 Bài 1: Demo 5 Cách Xử Lý Sự Kiện

**Giao diện:**
- 5 Button, mỗi cái dùng 1 cách khác nhau
- TextView hiển thị thông tin button nào được bấm

**Bước 1: Layout XML**
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
    
    <!-- Cách 1: XML onClick -->
    <Button
        android:id="@+id/btnWay1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 1: XML onClick"
        android:onClick="handleWay1"
        android:layout_marginBottom="10dp" />
    
    <!-- Cách 2: Anonymous Listener -->
    <Button
        android:id="@+id/btnWay2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 2: Anonymous Listener"
        android:layout_marginBottom="10dp" />
    
    <!-- Cách 3: Lambda -->
    <Button
        android:id="@+id/btnWay3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 3: Lambda"
        android:layout_marginBottom="10dp" />
    
    <!-- Cách 4: Activity Implements -->
    <Button
        android:id="@+id/btnWay4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 4: Activity Implements"
        android:layout_marginBottom="10dp" />
    
    <!-- Cách 5: Explicit Class -->
    <Button
        android:id="@+id/btnWay5"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Cách 5: Explicit Class"
        android:layout_marginBottom="30dp" />
    
    <!-- Kết quả -->
    <TextView
        android:id="@+id/tvResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Kết quả: Chưa bấm nút nào"
        android:textSize="18sp"
        android:padding="15dp"
        android:background="#E0E0E0"
        android:gravity="center" />
</LinearLayout>
```

**Bước 2: MainActivity.java**
```java
package com.example.eventhandling;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    private Button btnWay2, btnWay3, btnWay4, btnWay5;
    private TextView tvResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvResult = findViewById(R.id.tvResult);
        
        // ===== CÁCH 1: XML onClick =====
        // Đã định nghĩa android:onClick="handleWay1" trong XML
        
        // ===== CÁCH 2: Anonymous Listener =====
        btnWay2 = findViewById(R.id.btnWay2);
        btnWay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("Bạn bấm: Cách 2 - Anonymous Listener");
                Toast.makeText(MainActivity.this, "Cách 2", Toast.LENGTH_SHORT).show();
            }
        });
        
        // ===== CÁCH 3: Lambda Expression =====
        btnWay3 = findViewById(R.id.btnWay3);
        btnWay3.setOnClickListener(v -> {
            tvResult.setText("Bạn bấm: Cách 3 - Lambda Expression");
            Toast.makeText(MainActivity.this, "Cách 3 (Lambda)", Toast.LENGTH_SHORT).show();
        });
        
        // ===== CÁCH 4: Activity Implements OnClickListener =====
        btnWay4 = findViewById(R.id.btnWay4);
        btnWay5 = findViewById(R.id.btnWay5);
        btnWay4.setOnClickListener(this);
        btnWay5.setOnClickListener(this);  // Cùng interface
    }
    
    // Cách 1: XML onClick -> Phương thức public void và nhận View v
    public void handleWay1(View v) {
        tvResult.setText("Bạn bấm: Cách 1 - XML onClick");
        Toast.makeText(this, "Cách 1 (XML)", Toast.LENGTH_SHORT).show();
    }
    
    // Cách 4: Activity Implements -> Phải override onClick
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnWay4) {
            tvResult.setText("Bạn bấm: Cách 4 - Activity Implements");
            Toast.makeText(this, "Cách 4", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnWay5) {
            tvResult.setText("Bạn bấm: Cách 5 - Explicit Class");
            // Cách 5: Dùng class listener riêng (xem dưới)
            Toast.makeText(this, "Cách 5", Toast.LENGTH_SHORT).show();
        }
    }
}
```

**Bước 3: Cách 5 - Class listener riêng** (`MyClickListener.java`)
```java
package com.example.eventhandling;

import android.view.View;
import android.widget.TextView;

public class MyClickListener implements View.OnClickListener {
    
    private TextView tvResult;
    
    public MyClickListener(TextView tvResult) {
        this.tvResult = tvResult;
    }
    
    @Override
    public void onClick(View v) {
        tvResult.setText("Bạn bấm: Cách 5 - Explicit Listener Class");
    }
}
```

---

### 🟡 Lab 03 · RecyclerView - Danh Sách Dữ Liệu

**Mục tiêu:** Xây dựng danh sách hiệu năng cao với RecyclerView + CardView, hiểu mô hình Adapter Pattern.

**Thời gian dự kiến:** 2-3 tuần

#### 📚 Lý thuyết: RecyclerView là gì?

**RecyclerView** là một ViewGroup hiệu năng cao để hiển thị danh sách dữ liệu (hoặc grid/staggered grid). Nó **tái sử dụng** các item view, giúp app chạy nhanh hơn ListView.

---

##### **📌 ListView là gì? (Cũ, ít dùng)**

```java
// ListView - Cách cũ (1st gen Android)
public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = findViewById(R.id.listView);
        
        // Dữ liệu
        ArrayList<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        
        // Adapter đơn giản
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        
        // Click listener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Clicked: " + items.get(position), Toast.LENGTH_SHORT).show();
        });
    }
}
```

**Layout XML cho ListView:**
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```

**Vấn đề của ListView:**
- ❌ **Không tái sử dụng ViewHolder** → Tạo view mới mỗi lần cuộn → Slow
- ❌ **Chỉ hỗ trợ layout dọc** → Không grid, không staggered
- ❌ **Không animation sẵn** → Khó add animation
- ❌ **Quản lý header/footer phức tạp**
- ❌ **Memory dùng nhiều** → App lag khi có 1000+ item
- ❌ **Cách 2003, đã deprecated** → Google không support

---

##### **✨ RecyclerView là gì? (Mới, hiện đại)**

**RecyclerView** là phiên bản nâng cấp của ListView:
- ✅ **Tái sử dụng ViewHolder** → Render nhanh hơn
- ✅ **Hỗ trợ nhiều layout:** RecyclerView.LayoutManager (LinearLayout, GridLayout, StaggeredGrid, hoặc custom)
- ✅ **Hỗ trợ animation** sẵn
- ✅ **Memory efficient** → Scroll mượt với 10,000+ items
- ✅ **Modern, được Google support**

```java
// RecyclerView - Cách mới (modern Android)
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView = findViewById(R.id.recyclerView);
        
        // Dữ liệu
        ArrayList<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        
        // Layout manager (cách sắp xếp)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // hoặc: recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        
        // Adapter (chuyển dữ liệu → View)
        adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}

// Adapter class
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<String> items;
    
    public ItemAdapter(ArrayList<String> items) {
        this.items = items;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_simple, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvText.setText(items.get(position));
    }
    
    @Override
    public int getItemCount() {
        return items.size();
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
            
            // Click listener item
            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                Toast.makeText(v.getContext(), "Clicked: " + pos, Toast.LENGTH_SHORT).show();
            });
        }
    }
}
```

**Layout XML cho RecyclerView:**
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```

---

##### **🎛️ RecyclerView.LayoutManager** - Cách sắp xếp item

RecyclerView có nhiều cách sắp xếp item (layout). Bạn set LayoutManager để quyết định cách hiển thị:

**1. LinearLayoutManager** - Xếp theo hàng (dọc hoặc ngang)
```java
// Xếp dọc (mặc định)
recyclerView.setLayoutManager(new LinearLayoutManager(this));

// Xếp ngang
recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
```

**2. GridLayoutManager** - Xếp theo lưới (giống bảng)
```java
// 2 cột
recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

// 3 cột
recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
```

**3. StaggeredGridLayoutManager** - Lưới không đều (Pinterest-style)
```java
// 2 cột, sắp xếp dọc
recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

// 3 cột, sắp xếp ngang
recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
```

**So sánh 3 loại:**

| LayoutManager | Kiểu | Ưu / Nhược điểm |
|---|---|---|
| **LinearLayout** | Danh sách (hàng hoặc cột) | ✅ Đơn giản / ❌ Chỉ một chiều |
| **GridLayout** | Bảng (đều 2x2, 3x3) | ✅ Compact / ❌ Các item cùng kích thước |
| **StaggeredGridLayout** | Lưới giống Pinterest | ✅ Flexible / ❌ Phức tạp hơn |

---

**So sánh chi tiết ListView vs RecyclerView:**

| Tiêu chí | ListView | RecyclerView |
|---|---|---|
| **Hiệu năng** | Bình thường | Cao (tái dùng ViewHolder) |
| **Layout types** | Chỉ dọc | Linear, Grid, Staggered, Custom |
| **ViewHolder** | Optional (khó) | Bắt buộc (tốt) |
| **Animation** | Không sẵn | Có built-in |
| **Memory** | Cao hơn | Thấp hơn |
| **Click listener** | Simple (setOnItemClickListener) | Cần implement |
| **Item decoration** | Khó (divider) | ItemDecoration class |
| **Tái sử dụng code** | Khó | Dễ (Adapter pattern) |
| **Phổ biến** | Cũ, deprecated | Hiện đại, recommended |
| **Thời gian học** | Nhanh | Khó hơn |

---

**🎯 Kết luận:** Trong production app hiện nay, **LUÔN DÙNG RecyclerView thay ListView**! ListView chỉ dùng trong mục đích học lịch sử hoặc app cổ.

#### 🏗️ Cấu trúc RecyclerView: 3 thành phần chính

```
RecyclerView
├── Data Source (ArrayList<T>)
├── Adapter (chuyển đổi dữ liệu thành View)
│   └── ViewHolder (lưu tham chiếu item view)
├── LayoutManager (sắp xếp item: Linear, Grid, v.v.)
└── ItemDecoration (option: trang trí)
```

**1. Data:** ArrayList chứa dữ liệu  
**2. Adapter:** Chuyển dữ liệu thành item view (thế người trung gian)  
**3. LayoutManager:** Định tính cách item sắp xếp  
**4. ViewHolder:** Lưu tham chiếu các widget trong 1 item (tối ưu hiệu năng)

---

#### 📝 Bài: App Danh Sách Cảnh Đẹp

**Mục tiêu:** Danh sách cảnh đẹp với hình ảnh + tên + click listener

**Dữ liệu:** Tên cảnh + URL ảnh

**Bước 1: Tạo Model (Landscape.java)**
```java
package com.example.landscapelist;

public class Landscape {
    private String name;
    private int imageResId;  // drawable resource ID
    private String description;
    
    public Landscape(String name, int imageResId, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
    }
    
    // Getter
    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getDescription() { return description; }
}
```

**Bước 2: Tạo item layout XML** (`res/layout/item_landscape.xml`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:cardCornerRadius="12dp"
    app:cardElevation="8dp"
    android:layout_margin="10dp">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        
        <!-- Hình ảnh -->
        <ImageView
            android:id="@+id/imLandscape"
            android:layout_width="match_parent"
            android:layout_height="250dp"
            android:scaleType="centerCrop"
            android:contentDescription="Landscape image" />
        
        <!-- Nội dung -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="12dp">
            
            <TextView
                android:id="@+id/tvName"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Tên cảnh"
                android:textSize="18sp"
                android:textStyle="bold"
                android:layout_marginBottom="5dp" />
            
            <TextView
                android:id="@+id/tvDescription"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Mô tả"
                android:textSize="14sp"
                android:textColor="#666666" />
        </LinearLayout>
    </LinearLayout>
</androidx.cardview.widget.CardView>
```

**Bước 3: Tạo Adapter** (`LandscapeAdapter.java`)
```java
package com.example.landscapelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.LandscapeViewHolder> {
    
    private Context context;
    private ArrayList<Landscape> landscapeList;
    
    // Constructor
    public LandscapeAdapter(Context context, ArrayList<Landscape> landscapeList) {
        this.context = context;
        this.landscapeList = landscapeList;
    }
    
    // Bước 1: Tạo ViewHolder (tạo layout item)
    @NonNull
    @Override
    public LandscapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout item
        View itemView = LayoutInflater.from(context).inflate(
            R.layout.item_landscape,
            parent,
            false
        );
        return new LandscapeViewHolder(itemView);
    }
    
    // Bước 2: Bind dữ liệu (gắn dữ liệu vào item)
    @Override
    public void onBindViewHolder(@NonNull LandscapeViewHolder holder, int position) {
        Landscape landscape = landscapeList.get(position);
        
        // Set dữ liệu cho item
        holder.tvName.setText(landscape.getName());
        holder.tvDescription.setText(landscape.getDescription());
        holder.imLandscape.setImageResource(landscape.getImageResId());
        
        // Click listener cho item
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Bạn chọn: " + landscape.getName(),
                Toast.LENGTH_SHORT).show();
        });
    }
    
    // Bước 3: Trả về số lượng item
    @Override
    public int getItemCount() {
        return landscapeList.size();
    }
    
    // ViewHolder - Inner class lưu tham chiếu các view
    public static class LandscapeViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription;
        ImageView imLandscape;
        
        public LandscapeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imLandscape = itemView.findViewById(R.id.imLandscape);
        }
    }
}
```

**Bước 4: Khởi tạo trong Activity** (`MainActivity.java`)
```java
package com.example.landscapelist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private LandscapeAdapter adapter;
    private ArrayList<Landscape> landscapeList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 1. Tìm RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        
        // 2. Chuẩn bị dữ liệu
        landscapeList = new ArrayList<>();
        landscapeList.add(new Landscape(
            "Cà Mau",
            R.drawable.ic_landscape1,
            "Mũi Cà Mau - mũi tây bắc của Việt Nam"
        ));
        landscapeList.add(new Landscape(
            "Hạ Long",
            R.drawable.ic_landscape2,
            "Vịnh Hạ Long - di sản thế giới"
        ));
        landscapeList.add(new Landscape(
            "Sapa",
            R.drawable.ic_landscape3,
            "Thị trấn Sapa - thành phố ngàn hoa"
        ));
        landscapeList.add(new Landscape(
            "Mũi Né",
            R.drawable.ic_landscape4,
            "Mũi Né - thành phố biển tươi đẹp"
        ));
        
        // 3. Set LayoutManager (cách sắp xếp)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // 4. Tạo Adapter
        adapter = new LandscapeAdapter(this, landscapeList);
        
        // 5. Gán Adapter cho RecyclerView
        recyclerView.setAdapter(adapter);
    }
}
```

**Bước 5: Activity main layout** (`res/layout/activity_main.xml`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Danh Sách Cảnh Đẹp"
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:padding="16dp"
        android:background="#E0E0E0" />
    
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="8dp" />
</LinearLayout>
```

**Bước 6: Thêm Dependencies** (`build.gradle`)
```gradle
dependencies {
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'
}
```

**Thử nghiệm nâng cao:**
- Đổi `LinearLayoutManager` thành `GridLayoutManager(this, 2)` (2 cột)
- Thêm `onItemClick()` để xử lý khi click item
- Thêm method `update()` để reload dữ liệu

---

---

### 🟣 Lab 02 · Lắng nghe và Xử lý sự kiện (Event Handling)

**Mục tiêu:** Nắm vững 5 cách xử lý sự kiện trong Android Java, biết khi nào dùng cách nào.

**Thời gian dự kiến:** 1-2 tuần

#### 📚 Lý thuyết: Sự kiện (Event) là gì?

- **Event**: Là hành động của người dùng (click button, nhập text, cuộn màn hình...)
- **Listener**: Là object nghe/lắng nghe sự kiện
- **Handler**: Là phương thức xử lý khi sự kiện xảy ra

```
User clicks button  →  Listener detects  →  Handler executes
```

#### 5 cách xử lý sự kiện trong Android

##### **Cách 1: XML onClick Attribute** (Nhanh nhưng rải rác logic)

**Cơ chế:** Khai báo tên phương thức trực tiếp trong thuộc tính `android:onClick` của Button

```xml
<!-- res/layout/activity_main.xml -->
<Button
    android:id="@+id/btnSubmit"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Submit"
    android:onClick="handleSubmit" />
```

```java
// MainActivity.java
public void handleSubmit(View v) {
    Toast.makeText(this, "Bạn bấm nút", Toast.LENGTH_SHORT).show();
}
```

**Ưu điểm:** Nhanh, khai báo đơn giản  
**Nhược điểm:** Logic rải rác giữa XML và Java, khó maintain

---

##### **Cách 2: Inline Anonymous Listener** (Phổ biến nhất)

**Cơ chế:** Tạo listener ẩn danh ngay chỗ gán `setOnClickListener()`

```java
// MainActivity.java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Bạn bấm nút", Toast.LENGTH_SHORT).show();
    }
});
```

**Ưu điểm:** Phổ biến, logic tập trung, dễ debug  
**Nhược điểm:** Code dài, khó tái sử dụng

---

##### **Cách 2.2: Lambda Expression** (Hiện đại nhất)

**Cơ chế:** Dùng lambda (Java 8+) để viết listener ngắn gọn

```java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(v -> {
    Toast.makeText(MainActivity.this, "Bạn bấm nút", Toast.LENGTH_SHORT).show();
});
```

**Ưu điểm:** Ngắn gọn, hiện đại, dễ đọc  
**Nhược điểm:** Yêu cầu Java 8+, chỉ dùng cho single method interface

---

##### **Cách 3: Activity Implements OnClickListener** (Quản lý nhiều button)

**Cơ chế:** Activity tự cài đặt interface `View.OnClickListener`, nhiều button dùng chung handler

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    private Button btnAdd, btnSub, btnMul, btnDiv;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        
        // Gán cùng listener cho tất cả
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        // Xử lý tất cả click ở đây, dùng if-else hoặc switch
        if (v.getId() == R.id.btnAdd) {
            Toast.makeText(this, "Bấm cộng", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnSub) {
            Toast.makeText(this, "Bấm trừ", Toast.LENGTH_SHORT).show();
        }
        // ...
    }
}
```

**Ưu điểm:** Quản lý nhiều button dễ, tập trung logic  
**Nhược điểm:** Code dài, cần if-else/switch

---

##### **Cách 4: Listener in Variable** (Tái sử dụng)

**Cơ chế:** Lưu listener vào biến, dùng lại cho nhiều button

```java
View.OnClickListener myClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Được bấm", Toast.LENGTH_SHORT).show();
    }
};

btnAdd.setOnClickListener(myClickListener);
btnSub.setOnClickListener(myClickListener);
btnMul.setOnClickListener(myClickListener);
btnDiv.setOnClickListener(myClickListener);
```

**Ưu điểm:** Tái sử dụng, tránh lặp code  
**Nhược điểm:** Khó phân biệt button nào được bấm

---

##### **Cách 5: Explicit Listener Class** (Tường minh nhất)

**Cơ chế:** Tạo class listener riêng implements OnClickListener

```java
// File tách riêng: MyClickListener.java
public class MyClickListener implements View.OnClickListener {
    private Context context;
    
    public MyClickListener(Context context) {
        this.context = context;
    }
    
    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Được bấm từ class riêng", Toast.LENGTH_SHORT).show();
    }
}

// Trong MainActivity.java
Button btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(new MyClickListener(this));
```

**Ưu điểm:** Tường minh, dễ test, architecture rõ ràng  
**Nhược điểm:** Tạo nhiều file, phức tạp cho app nhỏ

---

#### 📝 Bài: Demo 5 Cách Xử Lý Sự Kiện

**Giao diện:** 5 Button, mỗi cái dùng 1 cách khác nhau

**Layout XML** (`res/layout/activity_main.xml`):
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
        android:text="Kết quả: Chưa bấm nút nào"
        android:textSize="18sp"
        android:padding="15dp"
        android:background="#E0E0E0"
        android:gravity="center" />
</LinearLayout>
```

**Code Java** (`MainActivity.java`):
```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvResult = findViewById(R.id.tvResult);
        
        // Cách 2: Anonymous Listener
        findViewById(R.id.btnWay2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("Cách 2: Anonymous Listener");
            }
        });
        
        // Cách 3: Lambda
        findViewById(R.id.btnWay3).setOnClickListener(v -> 
            tvResult.setText("Cách 3: Lambda Expression")
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

### 🟡 Lab 03 · RecyclerView - Danh Sách Dữ Liệu

**Mục tiêu:** Xây dựng danh sách hiệu năng cao với RecyclerView + CardView, hiểu mô hình Adapter Pattern.

**Thời gian dự kiến:** 2-3 tuần

#### 📚 Lý thuyết: RecyclerView là gì?

**RecyclerView** là một ViewGroup hiệu năng cao để hiển thị danh sách dữ liệu (hoặc grid/staggered grid). Nó **tái sử dụng** các item view, giúp app chạy nhanh hơn ListView.

**So sánh RecyclerView và ListView:**

| Tiêu chí | ListView | RecyclerView |
|---|---|---|
| Hiệu năng | Trung bình | Cao (tái dùng ViewHolder) |
| Layout types | Chỉ dọc | Linear, Grid, Staggered Grid |
| Animation | Không hỗ trợ | Hỗ trợ |
| Memory | Cao hơn | Thấp hơn |
| Khó độ | Dễ | Khó hơn |

#### 🏗️ Cấu trúc RecyclerView: 4 thành phần

```
Data Source (ArrayList)
    ↓
Adapter (chuyển dữ liệu → View)
    ↓
ViewHolder (tái sử dụng item view)
    ↓
LayoutManager (sắp xếp: Linear/Grid/..)
    ↓
RecyclerView (hiển thị)
```

- **Data:** ArrayList chứa dữ liệu (Model)
- **Adapter:** Người trung gian giữa data và RecyclerView
- **LayoutManager:** Định cách item sắp xếp
- **ViewHolder:** Lưu tham chiếu item view (tối ưu)

---

#### 📝 Bài: App Danh Sách Cảnh Đẹp

**Mục tiêu:** Danh sách cảnh đẹp với ảnh + tên + click listener

**Bước 1: Model** (`Landscape.java`):
```java
public class Landscape {
    private String name;
    private int imageResId;
    private String description;
    
    public Landscape(String name, int imageResId, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
    }
    
    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getDescription() { return description; }
}
```

**Bước 2: Item Layout** (`res/layout/item_landscape.xml`):
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="280dp"
    app:cardCornerRadius="12dp"
    app:cardElevation="8dp"
    android:layout_margin="10dp">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        
        <ImageView
            android:id="@+id/imLandscape"
            android:layout_width="match_parent"
            android:layout_height="180dp"
            android:scaleType="centerCrop" />
        
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:padding="12dp">
            
            <TextView
                android:id="@+id/tvName"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textSize="18sp"
                android:textStyle="bold"
                android:layout_marginBottom="5dp" />
            
            <TextView
                android:id="@+id/tvDescription"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textSize="14sp"
                android:textColor="#666666" />
        </LinearLayout>
    </LinearLayout>
</androidx.cardview.widget.CardView>
```

**Bước 3: Adapter** (`LandscapeAdapter.java`):
```java
public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Landscape> list;
    
    public LandscapeAdapter(Context context, ArrayList<Landscape> list) {
        this.context = context;
        this.list = list;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
            .inflate(R.layout.item_landscape, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Landscape land = list.get(position);
        holder.tvName.setText(land.getName());
        holder.tvDescription.setText(land.getDescription());
        holder.imLandscape.setImageResource(land.getImageResId());
    }
    
    @Override
    public int getItemCount() { return list.size(); }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription;
        ImageView imLandscape;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imLandscape = itemView.findViewById(R.id.imLandscape);
        }
    }
}
```

**Bước 4: Activity** (`MainActivity.java`):
```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RecyclerView recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        
        ArrayList<Landscape> list = new ArrayList<>();
        list.add(new Landscape("Hạ Long", R.drawable.img1, "Vịnh Hạ Long"));
        list.add(new Landscape("Sapa", R.drawable.img2, "Thị trấn Sapa"));
        
        LandscapeAdapter adapter = new LandscapeAdapter(this, list);
        recycler.setAdapter(adapter);
    }
}
```

**Thêm Dependencies** (`build.gradle`):
```gradle
implementation 'androidx.recyclerview:recyclerview:1.3.2'
implementation 'androidx.cardview:cardview:1.0.0'
```

---

## 📘 Giai đoạn 2 · Intermediate Android (Tháng 2–3)

**Mục tiêu:** Xây dựng và quản lý app nhiều màn hình, điều hướng giữa các Activity, lưu dữ liệu cục bộ.

#### 🎯 Các chủ đề chính

| Chủ đề | Chi tiết | Ứng dụng |
|---|---|---|
| **Intent & Activity Navigation** | Chuyển màn hình, truyền dữ liệu qua Bundle | Mở activity khác, khởi động app |
| **Fragment** | Tái sử dụng UI, quản lý lifecycle riêng | Bottom navigation, tab view |
| **SharedPreferences** | Lưu key-value đơn giản (không cần DB) | Lưu cài đặt, remember login |
| **App Permissions** | Xin quyền runtime cho camera, storage | Truy cập file, camera, location |
| **RecyclerView Advanced** | ItemClick, swipe to delete, animation | List app có tương tác |

#### 📝 **Ví dụ 1: Intent - Chuyển Activity**

```java
// Chuyển từ MainActivity sang SecondActivity
Intent intent = new Intent(MainActivity.this, SecondActivity.class);

// Truyền dữ liệu qua Bundle
Bundle bundle = new Bundle();
bundle.putString("name", "John");
bundle.putInt("age", 25);
intent.putExtras(bundle);

startActivity(intent);
```

```java
// Nhận dữ liệu trong SecondActivity
Bundle bundle = getIntent().getExtras();
String name = bundle.getString("name");
int age = bundle.getInt("age");
```

#### 📝 **Ví dụ 2: SharedPreferences - Lưu dữ liệu**

```java
// Lưu dữ liệu
SharedPreferences pref = getSharedPreferences("APP_DATA", MODE_PRIVATE);
SharedPreferences.Editor editor = pref.edit();
editor.putString("username", "john_doe");
editor.putInt("score", 100);
editor.apply(); // hoặc commit()

// Đọc dữ liệu
String username = pref.getString("username", "default_value");
int score = pref.getInt("score", 0);
```

#### 📝 **Ví dụ 3: Fragment - Chia nhỏ UI**

```java
// MyFragment.java
public class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }
}

// MainActivity.java
MyFragment fragment = new MyFragment();
getSupportFragmentManager().beginTransaction()
    .replace(R.id.fragment_container, fragment)
    .addToBackStack(null)
    .commit();
```

---

## 📙 Giai đoạn 3 · Data & Networking (Tháng 4–5)

**Mục tiêu:** Làm việc với cơ sở dữ liệu cục bộ (Room) và dữ liệu từ internet (API).

#### 🎯 Các chủ đề chính

| Chủ đề | Chi tiết | Ứng dụng |
|---|---|---|
| **Room Database** | ORM hiện đại để quản lý SQLite | Lưu todo, contact, note |
| **Retrofit** | HTTP client để gọi REST API | Fetch dữ liệu từ server |
| **JSON Parsing** | Chuyển JSON string thành Object | Parse response từ API |
| **Async/Threading** | Chạy tác vụ nặng không lag UI | Network request, DB query |

#### 📝 **Ví dụ 1: Room Database - Tạo table**

```java
// Entity (Model)
@Entity(tableName = "todos")
public class Todo {
    @PrimaryKey(autoGenerate = true)
    public int id;
    
    @ColumnInfo(name = "title")
    public String title;
    
    @ColumnInfo(name = "completed")
    public boolean completed;
}

// DAO (Database Access Object)
@Dao
public interface TodoDao {
    @Query("SELECT * FROM todos")
    List<Todo> getAllTodos();
    
    @Insert
    void insertTodo(Todo todo);
    
    @Delete
    void deleteTodo(Todo todo);
}

// Database
@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
}

// Sử dụng
AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "app_db").build();
List<Todo> todos = db.todoDao().getAllTodos();
```

#### 📝 **Ví dụ 2: Retrofit - Gọi API**

```java
// Interface API
public interface WeatherApi {
    @GET("weather")
    Call<WeatherResponse> getWeather(
        @Query("lat") double lat,
        @Query("lon") double lon
    );
}

// Tạo Retrofit client
Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org/data/2.5/")
    .addConverterFactory(GsonConverterFactory.create())
    .build();

WeatherApi api = retrofit.create(WeatherApi.class);
api.getWeather(10.8, 106.7).enqueue(new Callback<WeatherResponse>() {
    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
        if (response.isSuccessful()) {
            WeatherResponse data = response.body();
            // Xử lý dữ liệu
        }
    }
    
    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        Log.e("API Error", t.getMessage());
    }
});
```

#### 📝 **Ví dụ 3: Async - Chạy nền**

```java
// Dùng ExecutorService
ExecutorService executor = Executors.newSingleThreadExecutor();
executor.execute(() -> {
    // Chạy tác vụ nặng ở background
    List<Todo> todos = db.todoDao().getAllTodos();
    
    // Quay lại Main thread để update UI
    runOnUiThread(() -> {
        adapter.setData(todos);
    });
});
```

**Dependencies**:
```gradle
implementation 'androidx.room:room-runtime:2.5.2'
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```

---

## 📕 Giai đoạn 4 · Advanced Android (Tháng 6–7)

**Mục tiêu:** Áp dụng architecture pattern hiện đại, sử dụng Firebase, xây dựng app production-ready.

#### 🎯 Các chủ đề chính

| Chủ đề | Chi tiết | Ứng dụng |
|---|---|---|
| **MVVM Architecture** | Tách biệt UI, Logic, Data | App có thể mở rộng, test |
| **ViewModel & LiveData** | Quản lý state, observe data | Update UI khi data thay đổi |
| **Data Binding** | Kết nối XML ↔ ViewModel | Giảm boilerplate code |
| **Firebase** | Authentication, Realtime DB | Chat app, user login |
| **Notifications** | Push notification, LocalNotification | Remind, alert user |

#### 📝 **Ví dụ 1: MVVM - ViewModel**

```java
// ViewModel
public class TodoViewModel extends ViewModel {
    private MutableLiveData<List<Todo>> todos = new MutableLiveData<>();
    
    public LiveData<List<Todo>> getTodos() {
        if (todos.getValue() == null) {
            loadTodos();
        }
        return todos;
    }
    
    private void loadTodos() {
        // Fetch từ DB hoặc API
        // todos.setValue(newList);
    }
}

// Activity
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TodoViewModel viewModel = new ViewModelProvider(this)
            .get(TodoViewModel.class);
        
        viewModel.getTodos().observe(this, todos -> {
            // Update UI
            adapter.setData(todos);
        });
    }
}
```

#### 📝 **Ví dụ 2: Firebase Auth**

```java
FirebaseAuth auth = FirebaseAuth.getInstance();

// Login
auth.signInWithEmailAndPassword("email@gmail.com", "password")
    .addOnSuccessListener(authResult -> {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
    })
    .addOnFailureListener(e -> {
        Toast.makeText(this, "Login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
    });

// Logout
auth.signOut();
```

#### 📝 **Ví dụ 3: Push Notification**

```java
// Tạo notification
NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
    .setSmallIcon(R.drawable.ic_notification)
    .setContentTitle("Title")
    .setContentText("Message")
    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
notificationManager.notify(1, builder.build());
```

**Dependencies**:
```gradle
implementation 'androidx.lifecycle:lifecycle-viewmodel:2.6.1'
implementation 'androidx.lifecycle:lifecycle-livedata:2.6.1'
implementation 'com.google.firebase:firebase-auth:22.1.2'
```

---

## 🎨 Giai đoạn 5 · UI/UX & Optimization (Tháng 8)

**Mục tiêu:** Làm cho app đẹp, mượt, và tối ưu hiệu năng theo chuẩn Material Design 3.

#### 🎯 Các chủ đề chính

| Chủ đề | Chi tiết | Ứng dụng |
|---|---|---|
| **Material Design 3** | Components chuẩn Google (FAB, Snackbar, BottomNav) | UI hiện đại, tuân chuẩn |
| **Advanced Layouts** | ConstraintLayout nâng cao, Motion Layout | Animation, responsive |
| **Dark Mode** | Hỗ trợ theme sáng/tối | Canh chỉnh tema theo hệ thống |
| **Performance** | Tối ưu memory, CPU, battery | App nhanh, không lag |
| **Animations** | Transition, shared element, ObjectAnimator | UI mượt, interactive |

#### 📝 **Ví dụ 1: Material Design - Extended FAB**

```xml
<!-- res/layout/activity_main.xml -->
<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
    android:id="@+id/fabAdd"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_margin="16dp"
    android:text="Add Todo"
    app:icon="@drawable/ic_add"
    app:layout_anchor="@id/bottom_nav"
    app:layout_anchorGravity="top|center_horizontal" />
```

#### 📝 **Ví dụ 2: Hỗ trợ Dark Mode**

```xml
<!-- res/values/colors.xml (Light) -->
<color name="primary">#1F51BA</color>
<color name="background">#FFFFFF</color>

<!-- res/values-night/colors.xml (Dark) -->
<color name="primary">#7FA8FF</color>
<color name="background">#121212</color>
```

#### 📝 **Ví dụ 3: Animation**

```java
// Fade animation
View view = findViewById(R.id.myView);
ObjectAnimator fadeOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
fadeOut.setDuration(2000);
fadeOut.start();

// Hoặc dùng Transition
TransitionSet transitionSet = new TransitionSet();
transitionSet.addTransition(new Fade());
transitionSet.addTransition(new Slide());
TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
```

---

## 🚀 Giai đoạn 6 · Publishing & Monetization (Tuần cuối)

**Mục tiêu:** Build app release và publish lên Google Play Store.

#### 🎯 Các bước chính

1. **Tạo Signed APK/Bundle**
   ```
   Build → Generate Signed App Bundle / Signed APK
   ```

2. **Tạo Google Play Developer Account** ($25 một lần)

3. **Tối ưu Store Listing**
   - Tên app, mô tả, ảnh demo
   - App icon, feature graphic
   - Privacy policy, category

4. **Upload & Test**
   - Internal testing track trước
   - Beta testing (closed track)
   - Production release

5. **Monetization** (tùy chọn)
   - Google AdMob: banner ads, interstitial
   - In-app purchase: bán feature, premium
   - Subscriptions: mô hình đăng ký

---

---


---

## 🚀 Lộ trình nâng cao · 8 tháng (sau khi hoàn thành 3 Lab)

> Lộ trình tự học bổ sung để đạt trình độ **Junior Android Developer**.  
> Tổng thời gian: **7–8 tháng** (học part-time) hoặc **4–5 tháng** (toàn thời gian)

---

### ⏱️ Tổng thời gian ước tính

| Giai đoạn | Thời gian | Phạm vi |
|---|---|---|
| **Lab 01-03** (Foundation) | 3-4 tuần | View, Layout, Event, RecyclerView |
| **Giai đoạn 2** (Intermediate) | 3-4 tuần | Intent, Fragment, SharedPreferences |
| **Giai đoạn 3** (Data & API) | 3-4 tuần | Room, Retrofit, JSON |
| **Giai đoạn 4** (Advanced) | 4-6 tuần | MVVM, Firebase, Notifications |
| **Giai đoạn 5** (UI/UX) | 2-3 tuần | Material Design 3, Animation |
| **Giai đoạn 6** (Publishing) | 1-2 tuần | Build, Deploy, Store |
| **Tổng cộng** | **7-8 tháng** (Part-time) | Junior Android Developer |

---

### 🗂️ Roadmap: Thứ tự làm project

Sau khi hoàn thành 3 Lab core, làm project theo thứ tự này:

```
1. Calculator App              ← Lab 01 + Lab 02 (Layout + Event)
2. To-Do List App              ← Lab 03 + Intent + SharedPreferences
3. Notes App                   ← Fragment + RecyclerView Advanced
4. Weather App                 ← Retrofit + API (OpenWeather)
5. Contact Manager             ← Room Database + MVVM
6. Chat App                    ← Firebase (Realtime + Auth)
7. Expense Tracker             ← MVVM + Room + Chart
8. Publish 1 app to Play Store ← Build Release + Optimization
```

---

## 📚 Chi tiết từng Giai đoạn

### 📘 **Giai đoạn 2 · Intermediate Android** (Tháng 2–3)

**Mục tiêu:** Xây dựng app nhiều màn hình, điều hướng, lưu dữ liệu cục bộ.

**Nội dung chính:**

- **Intent & Activity Navigation**
  - Implicit intent: mở app khác (gọi điện, mở browser)
  - Explicit intent: chuyển sang activity khác
  - Truyền dữ liệu qua Bundle
  - `startActivityForResult()` → lấy kết quả từ activity khác

- **Fragment**
  - Lifecycle của Fragment
  - Trao đổi dữ liệu Fragment ↔ Activity
  - Fragment back stack
  - Bottom Navigation + Multiple Fragments

- **SharedPreferences**
  - Lưu/đọc data key-value
  - Mode: PRIVATE, READABLE, WRITABLE
  - Ứng dụng: lưu cài đặt, token login, user preferences

- **App Permissions**
  - Manifest permissions (declare)
  - Runtime permissions (request khi cần)
  - `ActivityCompat.requestPermissions()`
  - `onRequestPermissionsResult()` xử lý kết quả

- **RecyclerView Advanced**
  - ItemClick listener chi tiết
  - Swipe-to-delete, Long-press menu
  - Animation khi add/remove item
  - DiffUtil để update efficient

**Projects thực hành:**
- 📝 **To-Do List:** Thêm/xóa/sửa todo, lưu vào SP
- 🗒️ **Notes App:** Danh sách note, click xem chi tiết
- 🖼️ **Image Gallery:** Permission + file picker

---

### 📙 **Giai đoạn 3 · Data & Networking** (Tháng 4–5)

**Mục tiêu:** Làm việc với database cục bộ và API từ internet.

**Nội dung chính:**

- **SQLite & Room Database**
  - Entity: @Entity, @ColumnInfo, @PrimaryKey
  - DAO (Data Access Object): @Query, @Insert, @Update, @Delete
  - Database: @Database, instance management
  - LiveData + DAO for reactive queries

- **REST API & JSON**
  - Hiểu HTTP method: GET, POST, PUT, DELETE
  - Request/Response structure
  - JSON to Java Object mapping

- **Retrofit & HTTP Client**
  - Tạo Retrofit instance
  - Define API interface với @GET, @POST
  - Callback: onResponse(), onFailure()
  - Error handling và retry logic

- **Parsing JSON dengan Gson**
  - Các annotation: @SerializedName, @Expose
  - Handle nested JSON
  - Array JSON → ArrayList

- **Async/Threading**
  - Background task không làm lag UI
  - ExecutorService + runOnUiThread()
  - Coroutines (advanced)

**Projects thực hành:**
- 🌤️ **Weather App:** API OpenWeatherMap, hiển thị nhiệt độ
- 📒 **Contact Manager:** Lưu contact vào Room DB
- 📰 **News App:** Gọi API tin tức, danh sách article

**APIs miễn phí để test:**
- OpenWeatherMap (thời tiết)
- NewsAPI (tin tức)
- JSONPlaceholder (fake data)
- TheCatAPI (hình mèo)

---

### 📕 **Giai đoạn 4 · Advanced & Architecture** (Tháng 6–7)

**Mục tiêu:** Áp dụng architecture pattern tiên tiến, quản lý state hiệu quả, tích hợp Firebase.

**Nội dung chính:**

- **MVVM Architecture**
  - Model: dữ liệu và logic
  - View: UI (Activity/Fragment)
  - ViewModel: bridge giữa View và Model
  - Separation of concerns, testable

- **ViewModel & LiveData**
  - ViewModel lifecycle
  - LiveData: observable data holder
  - observe() để subscribe data changes
  - MutableLiveData để update dữ liệu

- **Data Binding**
  - XML binding: `android:text="@{viewModel.name}"`
  - Two-way binding: `android:text="@={viewModel.input}"`
  - Giảm boilerplate code trong Activity

- **Firebase Integration**
  - Firebase Authentication (email/password, Google, Facebook)
  - Firestore Database (cloud database)
  - Firebase Realtime Database (untuk chat)
  - FCM (Firebase Cloud Messaging) for push

- **Notifications & Background Services**
  - Local notifications dengan NotificationManager
  - Push notifications từ Firebase
  - WorkManager cho scheduled tasks
  - Service cho background tasks

- **Content Providers**
  - Chia sẻ dữ liệu giữa các app
  - URI scheme
  - Query, insert, update, delete

**Projects thực hành:**
- 💬 **Chat App:** Firebase Realtime DB + Auth
- 💰 **Expense Tracker:** MVVM + Room + Chart library
- ⏰ **Reminder App:** WorkManager + Notifications

---

### 🎨 **Giai đoạn 5 · UI/UX & Optimization** (Tháng 8)

**Mục tiêu:** Tạo UI đẹp theo Material Design 3, tối ưu hiệu năng.

**Nội dung chính:**

- **Material Design 3 Components**
  - Floating Action Button (FAB), Extended FAB
  - Snackbar vs Toast
  - BottomNavigationView, NavigationRail
  - Material Card, Button, TextField
  - Dialogs, Bottom Sheets

- **Advanced Layouts**
  - ConstraintLayout: chains, barriers, guidelines
  - Flow layout (horizontal/vertical)
  - Motion Layout (animation advanced)
  - CoordinatorLayout (collapsing toolbar)

- **Animations & Transitions**
  - ObjectAnimator (property animation)
  - TransitionManager (automatic layout transition)
  - Shared Element Transition (activity transition)
  - Lottie animations (từ JSON file)

- **Dark Mode Support**
  - Day/Night themes
  - Dynamic colors (Material You)
  - Color resources per theme

- **Performance Tuning**
  - Memory optimization: release resource
  - Rendering performance: avoid janky frames
  - Battery optimization: battery usage
  - APK size reduction: ProGuard/R8

**Projects thực hành:**
- Redesign app cũ với Material Design 3
- Thêm buttersmooth animation
- Hỗ trợ dark mode toàn app

---

### 🚢 **Giai đoạn 6 · Publishing & Monetization** (Tuần cuối)

**Mục tiêu:** Xây dựng app release version và publish lên Google Play Store.

**Nội dung chính:**

- **Build Release Version**
  - Tạo keystore (chứng chỉ số)
  - Signed APK vs AAB (App Bundle)
  - Obfuscation với ProGuard/R8

- **Google Play Developer Account**
  - Đăng ký tài khoản ($25 một lần, vĩnh viễn)
  - Thiết lập lập hành tính thanh toán
  - Địa chỉ developer

- **Prepare Store Listing**
  - App name, short description
  - Full description (chi tiết features)
  - Screenshots (2-8 ảnh)
  - Feature graphic (1024x500 px)
  - App icon (512x512 px)
  - Video preview (optional)
  - Privacy policy, content rating

- **Testing Tracks**
  - **Internal testing:** 15 người, 15 phút
  - **Closed testing:** group testers, close community
  - **Open testing:** public pre-release
  - **Production:** app store release

- **Monetization** (optional)
  - **AdMob:** banner, interstitial, reward ads
  - **In-App Purchases:** bán features
  - **Subscriptions:** monthly/yearly plans

- **Maintenance & Analytics**
  - Google Analytics 4
  - Crash reporting (Crashlytics)
  - User acquisition (UAC)
  - A/B testing

---

## 🔗 Chi tiết cách tạo từng project

### 📝 **Project 1: To-Do List App**

**Công nghệ:** Intent, SharedPreferences, RecyclerView

**Tính năng:**
- ✅ Thêm todo
- ✅ Xóa todo
- ✅ Đánh dấu hoàn thành
- ✅ Lưu vào SharedPreferences (không mất khi tắt app)

**Cấu trúc:**
```
app/
├── MainActivity (danh sách)
├── AddTodoActivity (thêm mới)
├── TodoAdapter (RecyclerView)
├── Todo (Model)
└── TodoManager (SharedPreferences handler)
```

---

### 💬 **Project 2: Chat App (Firebase)**

**Công nghệ:** Firebase Realtime DB, Authentication, RecyclerView

**Tính năng:**
- ✅ Đăng ký / Đăng nhập
- ✅ Gửi/nhận tin nhắn real-time
- ✅ Danh sách tin nhắn
- ✅ Xem online status

**Lưu ý:**
- Setup Firebase project
- Enable Realtime Database
- Setup Authentication rules
- Test data structure trên Firebase Console

---

### 🌤️ **Project 3: Weather App (Retrofit)**

**Công nghệ:** Retrofit, JSON parsing, Location

**Tính năng:**
- ✅ Nhập tên thành phố
- ✅ Gọi API OpenWeatherMap
- ✅ Hiển thị: nhiệt độ, độ ẩm, dự báo
- ✅ Cache dữ liệu

**API:**
```
https://api.openweathermap.org/data/2.5/weather?
q=Ho Chi Minh&appid=YOUR_API_KEY&units=metric
```

---

## 📊 So sánh Các Công Nghệ

### RecyclerView vs ListView

| Tiêu chí | ListView | RecyclerView |
|---|---|---|
| Hiệu năng | Bình thường | Tối ưu (ViewHolder) |
| Layout | Chỉ linear | Linear/Grid/Staggered |
| Animation | Không | Có |
| ViewHolder | Optional | Bắt buộc |
| Phức tạp | Đơn giản | Khó hơn |

→ **Kết luận:** Dùng RecyclerView cho app hiện đại

---

### SharedPreferences vs Room Database

| Tiêu chí | SharedPreferences | Room |
|---|---|---|
| Lưu | Key-value | Table (SQL) |
| Dữ liệu | Đơn giản | Phức tạp |
| Query | Không có | @Query() lọc chi tiết |
| Performance | Nhanh (nhỏ) | Nhanh (lớn) |
| Dùng cho | Cài đặt, token | Todo, contact, note |

→ **Kết luận:** SP cho dữ liệu nhỏ, Room cho lớn

---

### MVVM vs MVC vs MVP

| Tiêu chí | MVC | MVP | MVVM |
|---|---|---|---|
| View biết Logic | Có | Không | Không |
| Testable | Khó | Dễ | Rất dễ |
| Binding | Không | Không | Có |
| Android phổ biến | Cũ | Được | Hiện đại |
| Phức tạp | Thấp | Cao | Cao |

→ **Kết luận:** Dùng MVVM cho app production

---

## 🛠️ Công cụ & Tài liệu

### Essential Tools

| Công cụ | Mục đích |
|---|---|
| **Android Studio** | IDE chính |
| **Firebase Console** | Setup Firebase |
| **Postman** | Test API |
| **Figma** | Design UI |
| **Git/GitHub** | Version control |

### Tài liệu chính thức

- [Android Developer Docs](https://developer.android.com/docs)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Material Design 3](https://m3.material.io/)
- [Google Codelabs](https://developer.android.com/codelabs)

### YouTube Channels

- 🎬 [Coding in Flow](https://www.youtube.com/@codinginflow)
- 🎬 [Philipp Lackner](https://www.youtube.com/@PhilippLackner)
- 🎬 [Android Developers](https://www.youtube.com/@AndroidDevelopers)
- 🎬 [Google I/O](https://www.youtube.com/@GoogleIO)

### Websites

- [Stack Overflow](https://stackoverflow.com/questions/tagged/android) - Q&A
- [Medium](https://medium.com/tag/android) - Articles
- [Dev.to](https://dev.to/t/android) - Community posts
- [Hacker News](https://news.ycombinator.com/) - News

---

## ✅ Checklist Hoàn thành

### Lab 01: View & Layout
- [ ] Hiểu View, ViewGroup, Layout
- [ ] Làm App Calculator
- [ ] Làm App BMI
- [ ] Test trên emulator

### Lab 02: Event Handling
- [ ] Hiểu 5 cách xử lý sự kiện
- [ ] Làm demo app 5 cách
- [ ] Chọn cách phù hợp

### Lab 03: RecyclerView
- [ ] Hiểu Model, Adapter, ViewHolder
- [ ] Làm app danh sách
- [ ] Thêm ItemClick, animation

### Intermediate Stage
- [ ] Intent & Navigation
- [ ] Fragment
- [ ] SharedPreferences
- [ ] Làm app To-Do List

### Data & Networking
- [ ] Room Database
- [ ] Retrofit API
- [ ] JSON parsing
- [ ] Làm app Weather

### Advanced Stage
- [ ] MVVM + ViewModel + LiveData
- [ ] Firebase Auth
- [ ] Messages/Chat
- [ ] Notifications

### Publishing
- [ ] Build APK/AAB signed
- [ ] Tạo Play Store account
- [ ] Upload app
- [ ] Monitor analytics

---

## 🎯 Tips & Best Practices

### Code Quality

```
✅ Đúng:
- Tên biến rõ: userName, totalPrice
- Comment cho logic phức tạp
- Tách file theo chức năng (Model, View, Utils)
- Sử dụng constant thay magic number

❌ Sai:
- Tên biến tối: u, tp, data
- Không comment gì cả
- Tất cả code trong 1 file
- Magic number: if (x == 5) ...
```

### Performance

```
✅ Tối ưu:
- RecyclerView thay ListView
- Room Dao sử dụng LiveData
- Lazy loading images
- Database query efficient

❌ Chậm:
- Main thread chạy network
- N+1 query problem
- Full-size image không resize
- Unoptimized layout hierarchy
```

### Security

```
✅ An toàn:
- Lưu token vào SharedPreferences secure
- API key không hardcode
- SQL injection sanitation
- HTTPS certificate pinning

❌ Nguy hiểm:
- Token hardcoded trong code
- API key public
- Dynamic SQL queries
- HTTP không encrypt
```

---

## 📞 Hỗ trợ & Cộng đồng

- **GitHub Issues:** Hỏi câu hỏi, report bug
- **Discord:** Android dev channels
- **Reddit:** r/Android, r/AndroidDev
- **Slack:** Android Developers community
- **Local Meetups:** JavaHug Vietnam, Android Vietnam

---

*Last updated: 2024*  
*Maintain by: Android Learning Community*  
*Level: Beginner → Junior Developer*

---

## 🛠️ Yêu cầu & Công cụ

### 🖥️ Môi trường Hệ Thống

| Yêu cầu | Chi tiết | Ghi chú |
|---|---|---|
| **OS** | Windows / macOS / Linux | Windows phổ biến nhất |
| **RAM** | Tối thiểu 8GB | Khuyến nghị 16GB |
| **Storage** | Tối thiểu 10GB | Cho Android Studio + SDK |
| **CPU** | i5 trở lên | AMD Ryzen 5 cũng được |

### 📱 Pro Tiêu Chuẩn Android

| Công cụ | Phiên bản | Mục đích |
|---|---|---|
| **Android Studio** | Hedgehog 2023.1+ | IDE chính |
| **JDK** | 17 trở lên | Java compiler |
| **Android SDK** | API 24+ (Android 7.0) | Library + emulator |
| **Emulator** | API 33+ (Android 13) | Test app |
| **Gradle** | 8.0+ | Build tool (auto) |

### 📦 Kotlin Gradle Plugin (opt)

```gradle
plugins {
    id 'com.android.application' version '8.1.0'
}

android {
    compileSdk 34
    minSdk 24
    targetSdk 34
}

dependencies {
    // Core libraries
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    
    // UI Libraries
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'
    
    // Database
    implementation 'androidx.room:room-runtime:2.5.2'
    annotationProcessor 'androidx.room:room-compiler:2.5.2'
    
    // Networking
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
    // Firebase
    implementation 'com.google.firebase:firebase-auth:22.1.2'
    implementation 'com.google.firebase:firebase-database:20.2.4'
    
    // Architecture
    implementation 'androidx.lifecycle:lifecycle-viewmodel:2.6.1'
    implementation 'androidx.lifecycle:lifecycle-livedata:2.6.1'
    
    // Testing
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
```

### 🎨 Design Tools

| Công cụ | Mục đích | Free |
|---|---|---|
| **Figma** | Design UI mockup | ✅ (limited) |
| **Android Studio Preview** | Preview layout | ✅ |
| **Material Design 3** | Design system | ✅ |
| **Icons8** | Icon library | ✅ (limited) |
| **Unsplash** | Free images | ✅ |

### 🧪 Testing & Debug

| Công cụ | Mục đích |
|---|---|
| **Logcat** | In log từ app |
| **Device Monitor** | Debug variables |
| **Debugger** | Breakpoint, step-through |
| **Android Profiler** | Memory, CPU, Network |
| **Firebase Console** | Test Realtime DB |
| **Postman** | Test API |

### 📊 Analytics & Monitoring

| Tool | Mục đích | Free |
|---|---|---|
| Google Analytics 4 | Track user behavior | ✅ |
| Firebase Crashlytics | Crash reporting | ✅ |
| Firebase Performance | App performance | ✅ |
| AdMob | Show ads, earn money | ✅ (earn) |

---

## 📚 Tài liệu Tham Khảo

### 📖 Official Documentation

| Tài liệu | Link | Tiếng |
|---|---|---|
| Android Developers | https://developer.android.com | EN |
| Firebase Docs | https://firebase.google.com/docs | EN |
| Material Design 3 | https://m3.material.io | EN |
| Google Codelabs | https://developer.android.com/codelabs | EN |

### 🎬 YouTube Channels

| Channel | Nội dung | Ngôn ngữ |
|---|---|---|
| Coding in Flow | Android native, project-based | EN |
| Philipp Lackner | Advanced topics, MVVM, Firebase | EN |
| Android Developers | Official tutorials, news | EN |
| CodingHard | Android tiếng Việt | VN |
| Java Code Geeks | Code snippets, tips | EN |

### 📱 Mobile Dev Communities

| Cộng đồng | Loại | Lên Tiếng |
|---|---|---|
| Stack Overflow | Q&A | EN |
| Reddit r/AndroidDev | Forum | EN |
| Dev.to | Blog/Articles | EN |
| Medium Android | Long-form articles | EN |
| GitHub Discussions | Code Q&A | EN |

### 🇻🇳 Tài Liệu Tiếng Việt

| Nguồn | Chi tiết |
|---|---|
| **Viblo** | Tutorial Android tiếng Việt |
| **F8 (Fullstack)** | Khóa học Android paid |
| **YouTube VN** | CodingHard, JavaHug |
| **Facebook Groups** | Android Dev Vietnam |

### 📚 Sách Tham Khảo

| Sách | Tác giả | Mục đích |
|---|---|---|
| Android Programming: The Big Nerd Ranch | Phillips, Stewart | Beginner |
| Professional Android | Reto Meier | Intermediate |
| Head First Android | Freeman, Freeman | Beginner |
| Clean Architecture | Uncle Bob | Architecture |

---

## 🎓 Kết Luận

### 📈 Tiến độ học tập

```
Tuần 1-2: Lab 01 (View & Layout)
  └─ Làm App Calculator + BMI ✅

Tuần 3-4: Lab 02 (Event Handling)
  └─ Demo 5 cách xử lý sự kiện ✅

Tuần 5-6: Lab 03 (RecyclerView)
  └─ App Landscape với CardView ✅
         ↓
        3 LAB CORE HOÀN THÀNH ✅

Tháng 2-3: Giai đoạn 2 (Intermediate)
  └─ To-Do App + Notes App

Tháng 4-5: Giai đoạn 3 (Data & API)
  └─ Weather App + Contact Manager

Tháng 6-7: Giai đoạn 4 (Advanced)
  └─ Chat App (Firebase) + MVVM

Tháng 8: Giai đoạn 5-6 (UI/UX + Publishing)
  └─ Publish app lên Play Store
```

### 🎯 Mục tiêu cuối cùng

Sau 7-8 tháng học tập, bạn sẽ:

✅ Hiểu sâu Android Framework  
✅ Xây dựng app multiscreen  
✅ Tích hợp Database & API  
✅ Áp dụng Architecture pattern tốt  
✅ Publish app lên Google Play  
✅ Sẵn sàng cho công việc Junior Developer  

---

### 💡 Lời Khuyên Cuối Cùng

1. **Code thường xuyên** - 30 min/ngày tốt hơn 4h cuối tuần
2. **Làm project thực** - Không chỉ follow tutorial
3. **Debug kỹ** - Khi bug xảy ra, spend time understand why
4. **Join community** - Học từ người khác, share kiến thức
5. **Biết nói không** - Đừng học mọi thứ cùng lúc

---

### 🔗 Liên Hệ & Hỗ Trợ

- **GitHub:** Fork repo, submit PR, create issues
- **Discord:** [Android Dev Community](https://discord.gg/android)
- **Reddit:** r/AndroidDev
- **Email:** [Tương tác với giảng viên]

---

### 📝 Ghi Chú Cập Nhật

| Phiên bản | Ngày | Thay đổi |
|---|---|---|
| 1.0 | 2024-01-XX | Initial version - 3 Lab core |
| 1.1 | 2024-02-XX | Thêm Giai đoạn 2, 3 |
| 1.2 | 2024-03-XX | Thêm Giai đoạn 4, 5, 6 + Best practices |
| Hiện tại | 2024-03-XX | Bổ sung chi tiết, ví dụ code hoàn chỉnh |

---

*Chúc bạn học tập vui vẻ! Hãy commit code hàng ngày, và sau 3 tháng bạn sẽ kinh ngạc với progress của mình 🙌*

**Happy Coding! 🚀**