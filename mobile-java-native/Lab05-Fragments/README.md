### 🟧 Lab 05 · Fragments

**Mục tiêu:**

- Hiểu khái niệm và vai trò của **Fragment** trong Android.
- Biết cách **tạo** và **sử dụng** Fragment trong ứng dụng.
- Hiểu cách **giao tiếp giữa Fragment và Activity** (và giữa các Fragment thông qua Activity).
- Dùng Fragment để xây dựng UI **linh hoạt**, **tái sử dụng**.

---

## 🔵 PHẦN 1: Tổng quan về Fragment

### 1.1. Fragment là gì?

- **Activity** là “container” cho các View, thường chiếm **toàn màn hình**.
- **Fragment** là một phần UI **mô-đun** nằm bên trong Activity (có thể xem như “mini-activity”).
- Fragment có **vòng đời riêng**, nhưng **gắn chặt** với Activity chứa nó.

### 1.2. Ưu điểm của Fragment

- **Modularity (Tính mô-đun):** chia nhỏ UI/phần xử lý trong Activity để dễ bảo trì.
- **Reusability (Tái sử dụng):** một Fragment có thể dùng lại ở nhiều Activity.
- **Adaptability (Thích nghi thiết bị):** dễ tùy biến giao diện theo kích thước màn hình (điện thoại/tablet) hoặc xoay màn hình.

---

## 🟠 PHẦN 2: Thêm/Thay thế Fragment (Static vs Dynamic)

### 🛠️ Bài 1: Thêm Fragment tĩnh (Static)

Ý tưởng: Khai báo Fragment trực tiếp trong `activity_main.xml` bằng thẻ `<fragment>` (hoặc `FragmentContainerView`).

**Các bước (Ví dụ 1):**

1) Tạo project mới (Empty Views Activity).
2) Tạo `ContentFragment` và thiết kế UI trong res/layout/fragment_content.xml.
3) Tạo `FooterFragment` và thiết kế UI trong res/layout/fragment_footer.xml.
4) Sửa `activity_main.xml` trong res/layout/activity_main.xml để chứa 2 fragment (ưu tiên dùng `FragmentContainerView` hoặc `FrameLayout` để dễ thay đổi về sau).

**Gợi ý layout ContentFragment (res/layout/fragment_content.xml):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/frameLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ContentFragment">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#55A839"
        android:gravity="center"
        android:text="@string/hello_fragments"
        android:textColor="@android:color/background_light"
        android:textSize="40sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

**Gợi ý layout FooterFragment (res/layout/fragment_footer.xml):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/frameLayout2"
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:background="#009DD9"
    android:paddingTop="20sp"
    android:paddingBottom="20sp"
    tools:context=".FooterFragment">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5">

        <Button
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_marginHorizontal="10dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="@string/one"
            android:textSize="20sp"
            app:cornerRadius="20dp"
            app:strokeColor="#FFFFFF"
            app:strokeWidth="5dp" />

        <Button
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_marginHorizontal="10dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="@string/two"
            android:textSize="20sp"
            app:cornerRadius="20dp"
            app:strokeColor="#FFFFFF"
            app:strokeWidth="5dp" />

        <Button
            android:layout_width="0dp"
            android:gravity="center"
            android:layout_height="match_parent"
            android:layout_marginHorizontal="10dp"
            android:layout_weight="1"
            android:text="@string/three"
            android:textSize="20sp"
            app:cornerRadius="20dp"
            app:strokeColor="#FFFFFF"
            app:strokeWidth="5dp" />
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

**Gợi ý layout (dùng `FragmentContainerView`):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentContent"
        android:name="com.example.lab05_fragments.ContentFragment"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentFooter"
        android:name="com.example.lab05_fragments.FooterFragment"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>
```

> Nếu bạn dùng template Android Studio cũ, có thể gặp thẻ `<fragment ... />` thay cho `FragmentContainerView`. Cả hai đều là “static”.

---

### 🛠️ Bài 2: Thêm Fragment động (Dynamic)

Ý tưởng: Trong code Java, dùng `FragmentManager` để **add/replace/remove** Fragment vào “container” (thường là `FrameLayout` hoặc `FragmentContainerView`).

**FragmentManager:**

- Từ Activity: `getSupportFragmentManager()`
- Từ Fragment: `getParentFragmentManager()`

**Các bước (Ví dụ 2):**

1) Tạo project mới.
2) Tạo `ContentFragment` và `FooterFragment` trong res/layout.
3) Tạo layout `activity_main.xml` có 2 placeholder (2 container) bằng `FrameLayout`.
4) Trong `MainActivity.java`, dùng `FragmentManager` để add 2 fragment.

**Gợi ý `activity_main.xml` (2 placeholder):**

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <FrameLayout
        android:id="@+id/containerContent"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <FrameLayout
        android:id="@+id/containerFooter"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>
```

**Gợi ý code add Fragment (MainActivity.java):**
Thêm đoạn code sau vào `onCreate()`:
```java
FragmentManager fragmentManager = getSupportFragmentManager();
fragmentManager.beginTransaction()
        .add(R.id.containerContent, new ContentFragment())
        .add(R.id.containerFooter, new FooterFragment())
        .commit();
```
Trong đó:
- `R.id.containerContent` và `R.id.containerFooter` là ID của các container trong layout.
- `new ContentFragment()` và `new FooterFragment()` là instance của các Fragment bạn muốn thêm.
- `commit()` để hoàn tất giao dịch.


**Các thao tác thường dùng:** `add()`, `replace()`, `remove()`.

---

### 🛠️ Bài 3: Thay thế Fragment động (Replace)

**Các bước (Ví dụ 3):**

1) Tạo project mới (hoặc tiếp tục từ ví dụ 2).
2) Tạo `ContentFragment`, `FooterFragment`.
3) `activity_main.xml`: có 2 vùng (container) chứa fragment.
4) Tạo `FragmentOne`, `FragmentTwo`, `FragmentThree` và thiết kế UI mỗi fragment.
5) Tạo 3 nút (One/Two/Three) và viết code để `replace()` fragment theo nút bấm.

**Gợi ý replace:**

```java
getSupportFragmentManager().beginTransaction()
        .replace(R.id.containerContent, new FragmentTwo())
        .commit();
```

> Nếu muốn nhấn nút Back quay lại fragment trước đó, bạn có thể dùng `addToBackStack(null)` trước `commit()`.

---

## 🟢 PHẦN 3: Tương tác giữa các Fragment (Fragments Interaction)

Tình huống: Activity chứa **2 fragment** hoạt động cùng nhau. Ví dụ: người dùng bấm nút ở Fragment #2 để đọc nội dung TextView ở Fragment #1 và hiển thị vào vùng trạng thái.

### 3.1. Fragment #1 (fragment_1.xml)

Thêm `TextView` (in đậm theo nội dung yêu cầu):

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#00FF00"
    tools:context=".Fragment1">

    <TextView
        android:id="@+id/lblFragment1"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="This is fragment #1"
        android:textColor="#000000"
        android:textSize="25sp" />
</LinearLayout>
```

### 3.2. Fragment #2 (fragment_2.xml)

Thêm `Button` và `TextView` (in đậm theo nội dung yêu cầu):

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/btnGetText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Get text in Fragment #1"
        android:textColor="#000000" />

    <TextView
        android:id="@+id/lblStatus"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="Status Area"
        android:textColor="#000000"
        android:textSize="25sp" />
</LinearLayout>
```

### 3.3. activity_main.xml: khai báo 2 fragment (static)

Uncomment/khai báo 2 fragment trong `activity_main.xml`:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <fragment
        android:name="com.example.lab05_fragments.Fragment1"
        android:id="@+id/fragment1"
        android:layout_width="fill_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <fragment
        android:name="com.example.lab05_fragments.Fragment2"
        android:id="@+id/fragment2"
        android:layout_width="fill_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />
</LinearLayout>
```

### 3.4. MainActivity.java

Nếu trước đó bạn add fragment động, hãy comment phần đó và dùng lại `setContentView()`:

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // FragmentManager fragmentManager = getSupportFragmentManager();
    // ...
    // fragmentTransaction.commit();
}
```

### 3.5. Fragment2.java: xử lý click để đọc text Fragment #1

```java
public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btnGetText = (Button) getActivity().findViewById(R.id.btnGetText);
        btnGetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.lblFragment1);
                TextView statusarea = (TextView) getActivity().findViewById(R.id.lblStatus);
                statusarea.setText("Fragment#1's text shows: " + lbl.getText());
            }
        });
    }
}
```

> Ghi chú: Cách này đơn giản để học, nhưng sẽ “coupling” chặt giữa 2 fragment. Khi làm bài lớn, nên cân nhắc giao tiếp qua Activity (interface callback) hoặc Shared ViewModel.

---

## 🧪 PHẦN 4: Bài thực hành (Your turn)

### Practice 7, 8, 9 (Exercise 7/8/9)

1) Lặp lại các ví dụ (mỗi ví dụ **1 project mới**).
2) Push lên GitHub repository của bạn.
3) Viết report gồm:
   - Ảnh chụp màn hình app chạy hoàn chỉnh.
   - Mô tả cấu trúc dữ liệu / thiết kế lớp (nếu có).
   - Mô tả logic triển khai (các bước add/replace, tương tác giữa fragments...).

### Practice 10 (Exercise 10) — Homework #4

**Notepad app với custom keypad**

- **Top Fragment:** hiển thị nội dung note đang nhập.
- **Bottom Fragment:** hiển thị nhiều hàng nút (chữ cái/số/ký hiệu). Khi bấm nút, ký tự tương ứng được **append** vào Top Fragment.

**Yêu cầu nộp:**

- Push code lên GitHub.
- Report gồm ảnh chụp app, thiết kế lớp/cấu trúc, và logic giao tiếp giữa fragments.
