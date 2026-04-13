# 📱 Bottom Navigation trong Android

## 📌 Giới thiệu

Bottom Navigation là thanh điều hướng nằm ở phía dưới màn hình, cho phép người dùng chuyển nhanh giữa các màn hình chính (Fragment).

👉 Phù hợp khi ứng dụng có từ **3–5 mục điều hướng chính**.

---

## 🧱 Công nghệ sử dụng

- Java hoặc Kotlin
- Android Studio
- Material Components

---

## Bước 1: Thêm thư viện

- Dùng được các component UI chuẩn Material Design, trong đó có:
  - BottomNavigationView ← cái đang dùng
  - FloatingActionButton
  - TextInputLayout
  - Snackbar

Mở file `build.gradle (Module: app)`:

```gradle
dependencies {
    implementation 'com.google.android.material:material:1.9.0'
}
```

---

## Bước 2: Tạo menu cho Bottom Navigation

Tạo file: `res/menu/bottom_nav_menu.xml`

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/nav_home"
        android:icon="@drawable/ic_home"
        android:title="Home" />

    <item
        android:id="@+id/nav_search"
        android:icon="@drawable/ic_search"
        android:title="Search" />

    <item
        android:id="@+id/nav_profile"
        android:icon="@drawable/ic_profile"
        android:title="Profile" />
</menu>
```

---

## Bước 3: Thêm BottomNavigationView vào layout

Mở `activity_main.xml`:

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- Container để chứa Fragment -->
    <FrameLayout
        android:id="@+id/frame_container"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <!-- Bottom Navigation -->
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        app:menu="@menu/bottom_nav_menu" />

</RelativeLayout>
```

---

## Bước 4: Tạo các Fragment

### HomeFragment.java

```java
public class HomeFragment extends Fragment {
    public HomeFragment() {
        super(R.layout.fragment_home);
    }
}
```

### SearchFragment.java

```java
public class SearchFragment extends Fragment {
    public SearchFragment() {
        super(R.layout.fragment_search);
    }
}
```

### ProfileFragment.java

```java
public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }
}
```

---

## Bước 5: Xử lý sự kiện click

Mở `MainActivity.java`:

```java
BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

// Fragment mặc định
loadFragment(new HomeFragment());

bottomNavigationView.setOnItemSelectedListener(item -> {
    Fragment fragment = null;

    switch (item.getItemId()) {
        case R.id.nav_home:
            fragment = new HomeFragment();
            break;
        case R.id.nav_search:
            fragment = new SearchFragment();
            break;
        case R.id.nav_profile:
            fragment = new ProfileFragment();
            break;
    }

    if (fragment != null) {
        loadFragment(fragment);
        return true;
    }
    return false;
});
```

---

## Hàm load Fragment

```java
private void loadFragment(Fragment fragment) {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.frame_container, fragment)
        .commit();
}
```

---

## Tuỳ chỉnh (Optional)

### 1. Ẩn label

```xml
app:labelVisibilityMode="unlabeled"
```

### 2. Đổi màu icon/text

```xml
app:itemIconTint="@color/color_selector"
app:itemTextColor="@color/color_selector"
```

### 3. Tắt animation shift

```xml
app:itemHorizontalTranslationEnabled="false"
```

---

## Best Practices

- Chỉ dùng tối đa **5 tab**
- Mỗi tab nên có:
  - Icon rõ ràng
  - Tên ngắn gọn
- Không nên reload Fragment quá nhiều → dùng cache nếu cần

---

## 🔥 Gợi ý nâng cao

- Dùng **Navigation Component (Jetpack)**
- Kết hợp với **ViewPager2**
- Thêm badge (notification count)

---

## 📌 Tổng kết

Bottom Navigation giúp:

- Điều hướng nhanh
- UI thân thiện
- Chuẩn Material Design
