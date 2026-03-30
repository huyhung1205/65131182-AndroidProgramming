### 🟡 Lab 03 · ListView - RecyclerView

**Mục tiêu:** Xây dựng danh sách dữ liệu với ListView (cơ bản, cũ) và RecyclerView (hiệu năng cao, hiện đại). Hiểu mô hình Adapter Pattern.

**Thời gian dự kiến:** 3-4 tuần

#### 📚 Lý thuyết: ListView và RecyclerView là gì?

**ListView** là widget cũ hơn để hiển thị danh sách, còn được dùng trong các dự án cũ nhưng **không được recommend** cho app mới. Tuy nhiên, hiểu ListView là bước cơ bản để nắm RecyclerView.

**RecyclerView** là một ViewGroup hiệu năng cao để hiển thị danh sách dữ liệu (hoặc grid/staggered grid). Nó **tái sử dụng** các item view, giúp app chạy nhanh hơn ListView.

---

## 🔵 PHẦN 1: ListView - Danh Sách Cơ Bản (Cũ nhưng cần hiểu)

#### 📚 ListView là gì?

**ListView** là ViewGroup hiển thị danh sách dữ liệu theo hàng dọc (hoặc ngang). Mỗi item là một row có thể click được.

**Cấu trúc:**
```
Data Source (ArrayList)
    ↓
Adapter (ArrayAdapter hoặc CustomAdapter)
    ↓
ListView (hiển thị, mỗi item là View)
```

---

#### 🛠️ Bài 1: ListView Đơn Giản (Built-in Layout)

**Mục tiêu:** Danh sách 10 tên việc cần làm (To-Do List)

**Bước 1: Layout Activity** (`res/layout/activity_main.xml`):
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Danh Sách Công Việc"
        android:textSize="22sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="16dp" />
    
    <ListView
        android:id="@+id/listViewTodo"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```

**Bước 2: Activity Code** (`MainActivity.java`):
```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = findViewById(R.id.listViewTodo);
        
        // Chuẩn bị dữ liệu
        ArrayList<String> todoList = new ArrayList<>();
        todoList.add("Làm bài tập Android");
        todoList.add("Đọc sách lập trình");
        todoList.add("Tập thể dục");
        todoList.add("Ăn trưa");
        todoList.add("Ôn tập kiến thức cũ");
        todoList.add("Nấu cơm");
        todoList.add("Rửa bát");
        todoList.add("Đi ngủ sớm");
        todoList.add("Gọi điện cho mẹ");
        todoList.add("Cập nhật lên GitHub");
        
        // Dùng ArrayAdapter (built-in, hiển thị từng item là 1 dòng text)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,  // ← Built-in layout từ Android SDK (1 TextView)
            todoList
        );
        
        listView.setAdapter(adapter);
        
        // Bấm item → hiển thị Toast
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String item = todoList.get(position);
            Toast.makeText(this, "Bạn bấm: " + item, Toast.LENGTH_SHORT).show();
        });
    }
}
```

**Kết quả:** ✅ Danh sách 10 công việc có thể click!

---

#### 📌 Giải Thích: `android.R.layout.simple_list_item_1` là gì?

**`android.R.layout.simple_list_item_1`** là một **layout XML có sẵn** từ Android SDK. Nó được cung cấp bởi Google, không phải do bạn tạo.

**Cấu trúc của nó:**
```xml
<?xml version="1.0" encoding="utf-8"?>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@android:id/text1"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textAppearance="?attr/textAppearanceListItem"
    android:gravity="center_vertical"
    android:paddingStart="?attr/listPreferredItemPaddingStart"
    android:paddingEnd="?attr/listPreferredItemPaddingEnd"
    android:minHeight="?attr/listPreferredItemHeightSmall" />
```

**Các Layout có sẵn khác (trong `android.R.layout`):**
| Layout | Nội dung | Dùng cho |
|---|---|---|
| `simple_list_item_1` | 1 TextView | Danh sách text đơn |
| `simple_list_item_2` | 2 TextView (title + desc) | Danh sách 2 dòng |
| `simple_list_item_checked` | TextView + checkbox | Danh sách có tickbox |
| `simple_list_item_multiple_choice` | Multiple choice | Chọn nhiều |
| `simple_list_item_single_choice` | Single choice | Chọn 1 |

**Cách sử dụng:**
```java
// Sử dụng built-in layout
ArrayAdapter<String> adapter = new ArrayAdapter<>(
    context,
    android.R.layout.simple_list_item_1,  // ← Từ Android SDK
    dataList
);

// Sử dụng custom layout (tạo riêng)
ArrayAdapter<String> adapter = new ArrayAdapter<>(
    context,
    R.layout.item_custom,  // ← Từ res/layout folder của app mình
    dataList
);
```

**Khi nào dùng cái nào?**
- **Built-in layout:** Nhanh, đơn giản, nhưng ít tuỳ chỉnh
- **Custom layout:** Chậm hơn, nhưng linh hoạt hơn (thêm ảnh, button, v.v)

**Tài liệu:** https://developer.android.com/reference/android/R.layout

---

#### 🛠️ Bài 2: ListView Tùy Chỉnh (Custom Layout)

**Mục tiêu:** Danh sách học sinh với ảnh + tên + email

**Bước 1: Model** (`Student.java`): Tạo class Student để lưu thông tin học sinh (name, email, photoResId) - Đây là phần dữ liệu (Model)
```java
// src/main/java/com/example/app/Student.java
public class Student {
    private String name;
    private String email;
    private int photoResId;
    
    public Student(String name, String email, int photoResId) {
        this.name = name;
        this.email = email;
        this.photoResId = photoResId;
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getPhotoResId() { return photoResId; }
}
```

**Bước 2: Item Layout** (`res/layout/item_student.xml`): Tạo layout riêng cho mỗi item trong ListView (ảnh + tên + email)
```xml
// res/layout/item_student.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:padding="12dp"
    android:background="#FFFFFF"
    android:layout_margin="5dp">
    
    <ImageView
        android:id="@+id/imStudent"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:scaleType="centerCrop"
        android:layout_marginRight="16dp" />
    
    <LinearLayout
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical"
        android:gravity="center_vertical">
        
        <TextView
            android:id="@+id/tvStudentName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:textStyle="bold"
            android:textColor="#000000"
            android:layout_marginBottom="5dp" />
        
        <TextView
            android:id="@+id/tvStudentEmail"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="14sp"
            android:textColor="#666666" />
    </LinearLayout>
</LinearLayout>
```

**Bước 3: Custom Adapter** (`StudentAdapter.java`): Tạo adapter riêng để chuyển dữ liệu Student → item_student layout (View)
```java
// src/main/java/com/example/app/StudentAdapter.java

/**
 * StudentAdapter - Custom Adapter để hiển thị danh sách học sinh trong ListView
 * - Extends BaseAdapter (class cơ bản của tất cả adapter)
 * - Dùng ViewHolder pattern để tối ưu hiệu năng (tái sử dụng view)
 * - Chuyển dữ liệu Student object thành UI view trên ListView
 */
public class StudentAdapter extends BaseAdapter {
    private Context context;              // Để inflate layout, hiển thị dialog, v.v
    private ArrayList<Student> list;      // Danh sách dữ liệu cần hiển thị
    private LayoutInflater inflater;      // Tool để chuyển XML layout → Java View object
    
    /**
     * Constructor - gọi lúc khởi tạo adapter
     * @param context: Context của Activity (this)
     * @param list: ArrayList chứa tất cả Student cần hiển thị
     */
    public StudentAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
        // LayoutInflater.from(context) là cách để lấy tool inflate layout
        this.inflater = LayoutInflater.from(context);
    }
    
    /**
     * getCount() - Bắt buộc override
     * @return: Số lượng item cần hiển thị trong ListView
     * ListView dùng cái này để biết phải tạo bao nhiêu row
     */
    @Override
    public int getCount() {
        return list.size();  // Trả về số học sinh
    }
    
    /**
     * getItem() - Bắt buộc override
     * @param position: Vị trí của item (0, 1, 2, ...)
     * @return: Object tại vị trí đó
     * Ít dùng, nhưng ListView yêu cầu phải implement
     */
    @Override
    public Object getItem(int position) {
        return list.get(position);  // Trả về Student tại vị trí position
    }
    
    /**
     * getItemId() - Bắt buộc override
     * @param position: Vị trí của item
     * @return: ID duy nhất của item (thường là position)
     * Dùng khi có xử lý database, còn không thì return position là được
     */
    @Override
    public long getItemId(int position) {
        return position;  // Thường dùng position làm ID (0, 1, 2, ...)
    }
    
    /**
     * getView() - PHẦN QUAN TRỌNG NHẤT!
     * Phương thức này gọi cho MỖI item khi ListView cần hiển thị
     * Dùng ViewHolder pattern để tối ưu (tái sử dụng view cũ thay vì tạo mới)
     * 
     * @param position: Vị trí item cần hiển thị (0, 1, 2, ...)
     * @param convertView: View cũ từ row trước (có thể null nếu là row đầu)
     * @param parent: ListView container
     * @return: View đã setup xong, sẵn sàng hiển thị
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        
        /**
         * BƯỚC 1: Kiểm tra convertView
         * - convertView != null: Row View đã tồn tại từ trước
         *   → Cải sử dụng lại (tối ưu hiệu năng, tránh memory leak)
         *   → Chỉ cần cập nhật dữ liệu
         * - convertView == null: Row View mới lần đầu
         *   → Phải inflate (tạo) layout item_student XML → Java View
         *   → Rồi tìm tất cả các widget con (TextView, ImageView)
         */
        if (convertView == null) {
            // ❌ NẾU KHÔNG CÓ VIEW CŨ: Tạo view mới
            
            // 1. Inflate: Chuyển item_student.xml → convertView object
            //    parent là LinearLayout parent, false = không attach vào parent
            convertView = inflater.inflate(R.layout.item_student, parent, false);
            
            // 2. Tạo ViewHolder object (lưu references của các widget)
            holder = new ViewHolder();
            
            // 3. Tìm tất cả widget con trong convertView XML
            //    findViewById cần gọi trên convertView, không phải context
            holder.tvName = convertView.findViewById(R.id.tvStudentName);
            holder.tvEmail = convertView.findViewById(R.id.tvStudentEmail);
            holder.imStudent = convertView.findViewById(R.id.imStudent);
            
            // 4. Lưu holder vào convertView.setTag()
            //    Lần tới gọi getView cùng row này, convertView sẽ có holder sẵn
            convertView.setTag(holder);
        } else {
            // ✅ NẾUD CÓ VIEW CŨ: Tái sử dụng
            // Lấy holder từ tag đã lưu trước đó
            holder = (ViewHolder) convertView.getTag();
            // Tiết kiệm: không cần inflate, không cần findViewById lại
        }
        
        /**
         * BƯỚC 2: Cập nhật dữ liệu (điều này LUÔN thực hiện, 
         * dù convertView cũ hay mới)
         * - Lấy Student object từ list tại vị trí position
         * - Gán dữ liệu (tên, email, ảnh) vào holder widgets
         */
        Student student = list.get(position);  // Lấy Student tại index position
        holder.tvName.setText(student.getName());        // Gán tên vào TextView
        holder.tvEmail.setText(student.getEmail());      // Gán email vào TextView
        holder.imStudent.setImageResource(student.getPhotoResId());  // Gán ảnh vào ImageView
        
        /**
         * BƯỚC 3: Trả về view hoàn chỉnh
         * ListView sẽ hiển thị convertView này tại vị trí position
         */
        return convertView;
    }
    
    /**
     * ViewHolder Pattern - Tối ưu hiệu năng
     * Thay vì gọi findViewById nhiều lần (tốn time),
     * ta lưu references một lần rồi tái sử dụng
     * 
     * Cơ chế:
     * - Row 1 scroll off: convertView được tái sử dụng cho Row N
     * - ViewHolder lưu trong convertView.setTag() để tái sử dụng
     * - Chỉ cần update dữ liệu, không cần tao mới view
     */
    private static class ViewHolder {
        // Lưu references của các widget trong item_student.xml
        TextView tvName;      // Để set student name
        TextView tvEmail;     // Để set student email
        ImageView imStudent;  // Để set student photo
    }
}
```

**Bước 4: Activity** (`MainActivity.java`):
```java
// src/main/java/com/example/app/MainActivity.java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = findViewById(R.id.listViewStudent);
        
        // Chuẩn bị dữ liệu
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Nguyễn Văn A", "a@gmail.com", R.drawable.student1));
        studentList.add(new Student("Trần Thị B", "b@gmail.com", R.drawable.student2));
        studentList.add(new Student("Lê Văn C", "c@gmail.com", R.drawable.student3));
        studentList.add(new Student("Phạm Thị D", "d@gmail.com", R.drawable.student4));
        studentList.add(new Student("Hoàng Văn E", "e@gmail.com", R.drawable.student5));
        
        // Dùng Custom Adapter
        StudentAdapter adapter = new StudentAdapter(this, studentList);
        listView.setAdapter(adapter);
        
        // Xử lý click item
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Student student = studentList.get(position);
            Toast.makeText(this, 
                "Bạn bấm: " + student.getName(), 
                Toast.LENGTH_SHORT).show();
        });
        
        // Xử lý long click (nhấn giữ)
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            String name = studentList.get(position).getName();
            Toast.makeText(this, 
                "Xoá: " + name + "?", 
                Toast.LENGTH_SHORT).show();
            return true;  // Consume event
        });
    }
}
```

**Activity Layout** (`res/layout/activity_main.xml`):
```xml
// res/layout/activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="8dp">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Danh Sách Học Sinh"
        android:textSize="22sp"
        android:textStyle="bold"
        android:gravity="center"
        android:padding="16dp" />
    
    <ListView
        android:id="@+id/listViewStudent"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:divider="#CCCCCC"
        android:dividerHeight="1dp" />
</LinearLayout>
```

**Kết quả:** ✅ Danh sách học sinh với ảnh, tên, email!

---

#### ⚡ ListView vs Custom Adapter

| Trường hợp | Dùng gì |
|---|---|
| Danh sách text đơn giản | **ArrayAdapter** |
| Danh sách text 2 cột | **ArrayAdapter** (layout 2 text) |
| Danh sách ảnh + text phức tạp | **Custom BaseAdapter** |

---

####  Phần Mở Rộng: Mở Web từ ListView

**Mục tiêu:** Danh sách công ty kỹ thuật, bấm item → mở website công ty

**Bước 1: Model** (`Company.java`):
```java
public class Company {
    private String name;
    private String website;
    private int logoResId;
    private String description;
    
    public Company(String name, String website, int logoResId, String description) {
        this.name = name;
        this.website = website;
        this.logoResId = logoResId;
        this.description = description;
    }
    
    public String getName() { return name; }
    public String getWebsite() { return website; }
    public int getLogoResId() { return logoResId; }
    public String getDescription() { return description; }
}
```

**Bước 2: Item Layout** (`res/layout/item_company.xml`):
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:padding="12dp"
    android:background="#FFFFFF"
    android:layout_margin="5dp">
    
    <ImageView
        android:id="@+id/imLogo"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:scaleType="centerCrop"
        android:layout_marginRight="16dp" />
    
    <LinearLayout
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical"
        android:gravity="center_vertical">
        
        <TextView
            android:id="@+id/tvCompanyName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:textStyle="bold"
            android:textColor="#000000"
            android:layout_marginBottom="3dp" />
        
        <TextView
            android:id="@+id/tvWebsite"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="12sp"
            android:textColor="#0066CC"
            android:layout_marginBottom="5dp" />
        
        <TextView
            android:id="@+id/tvDescription"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="13sp"
            android:textColor="#666666"
            android:maxLines="1"
            android:ellipsize="end" />
    </LinearLayout>
    
    <Button
        android:id="@+id/btnOpenWeb"
        android:layout_width="70dp"
        android:layout_height="40dp"
        android:text="🌐 Web"
        android:textSize="10sp"
        android:layout_gravity="center_vertical" />
</LinearLayout>
```

**Bước 3: Custom Adapter với Click Listener** (`CompanyAdapter.java`):
```java
public class CompanyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Company> list;
    private LayoutInflater inflater;
    private OnCompanyClickListener listener;
    
    // Interface để xử lý click
    public interface OnCompanyClickListener {
        void onOpenWebClick(Company company);
        void onItemClick(Company company);
    }
    
    public CompanyAdapter(Context context, ArrayList<Company> list, OnCompanyClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        this.inflater = LayoutInflater.from(context);
    }
    
    @Override
    public int getCount() { return list.size(); }
    
    @Override
    public Object getItem(int position) { return list.get(position); }
    
    @Override
    public long getItemId(int position) { return position; }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_company, parent, false);
            holder = new ViewHolder();
            holder.imLogo = convertView.findViewById(R.id.imLogo);
            holder.tvName = convertView.findViewById(R.id.tvCompanyName);
            holder.tvWebsite = convertView.findViewById(R.id.tvWebsite);
            holder.tvDescription = convertView.findViewById(R.id.tvDescription);
            holder.btnOpenWeb = convertView.findViewById(R.id.btnOpenWeb);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        Company company = list.get(position);
        holder.imLogo.setImageResource(company.getLogoResId());
        holder.tvName.setText(company.getName());
        holder.tvWebsite.setText(company.getWebsite());
        holder.tvDescription.setText(company.getDescription());
        
        // Click nút "Web" → mở browser
        holder.btnOpenWeb.setOnClickListener(v -> {
            if (listener != null) {
                listener.onOpenWebClick(company);
            }
        });
        
        // Bấm item → show thông tin
        convertView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(company);
            }
        });
        
        return convertView;
    }
    
    private static class ViewHolder {
        ImageView imLogo;
        TextView tvName, tvWebsite, tvDescription;
        Button btnOpenWeb;
    }
}
```

**Bước 4: Activity - Mở Web Browser** (`MainActivity.java`):
```java
public class MainActivity extends AppCompatActivity {
    private Toast currentToast;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = findViewById(R.id.listViewCompany);
        
        // Chuẩn bị dữ liệu
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("Google", "www.google.com", R.drawable.google, "Công ty tìm kiếm hàng đầu"));
        companies.add(new Company("Meta", "www.meta.com", R.drawable.meta, "Công ty mạng xã hội"));
        companies.add(new Company("Apple", "www.apple.com", R.drawable.apple, "Công ty công nghệ premium"));
        companies.add(new Company("Microsoft", "www.microsoft.com", R.drawable.microsoft, "Phần mềm & cloud"));
        companies.add(new Company("Amazon", "www.amazon.com", R.drawable.amazon, "E-commerce & AWS"));
        
        // Custom Adapter với listener
        CompanyAdapter adapter = new CompanyAdapter(this, companies, new CompanyAdapter.OnCompanyClickListener() {
            @Override
            public void onOpenWebClick(Company company) {
                // Mở browser
                openWebsite(company.getWebsite());
            }
            
            @Override
            public void onItemClick(Company company) {
                // Hiển thị thông tin
                showToastSingle("📱 " + company.getName() + "\n" + company.getDescription());
            }
        });
        
        listView.setAdapter(adapter);
    }
    
    // Mở website trong browser
    private void openWebsite(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    
    // Phương thức show Toast (tránh queue)
    private void showToastSingle(String message) {
        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        currentToast.show();
    }
}
```

**Activity Layout** (`res/layout/activity_main.xml`):
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="8dp">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="🏢 Danh Sách Công Ty Tech"
        android:textSize="22sp"
        android:textStyle="bold"
        android:gravity="center"
        android:padding="16dp" />
    
    <ListView
        android:id="@+id/listViewCompany"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:divider="#CCCCCC"
        android:dividerHeight="1dp" />
</LinearLayout>
```

**Cấp quyền Internet** (`AndroidManifest.xml`):
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

**Kết quả:** ✅ Click "Web" → mở browser vào website công ty!

---

#### 🔴 Nhược điểm ListView (tại sao nên dùng RecyclerView):
- ❌ Không tái sử dụng view hiệu quả
- ❌ Scrolling không mượt khi item nhiều
- ❌ Không hỗ trợ animation sẵn
- ❌ Khó customize
- ❌ **Deprecated** - Google khuyên dùng RecyclerView

---

##### **📌 So sánh ListView vs RecyclerView**

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

## 🟢 PHẦN 2: RecyclerView - Danh Sách Hiệu Năng Cao (Hiện Đại - Recommended)

#### 📚 RecyclerView là gì?

**RecyclerView** là ViewGroup hiệu năng cao để hiển thị danh sách dữ liệu (hoặc grid/staggered grid). Nó **tái sử dụng** các item view, giúp app chạy nhanh hơn ListView.

**Ưu điểm của RecyclerView:**
- ✅ **Tái sử dụng ViewHolder** → Render nhanh hơn
- ✅ **Hỗ trợ nhiều layout:** LinearLayout, GridLayout, StaggeredGrid
- ✅ **Hỗ trợ animation** sẵn
- ✅ **Memory efficient** → Scroll mượt với 10,000+ items
- ✅ **Modern, được Google support**

**Cấu trúc:**
```
Data Source (ArrayList)
    ↓
Adapter (RecyclerView.Adapter)
    ↓
ViewHolder (tái sử dụng item view)
    ↓
LayoutManager (sắp xếp: Linear/Grid/..)
    ↓
RecyclerView (hiển thị)
```

---

#### 🛠️ Bài 1: RecyclerView Cơ Bản (Danh Sách Cảnh Đẹp)

**Mục tiêu:** Danh sách cảnh đẹp với ảnh + tên + description, có thể click item

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

**Bước 3: Adapter với Click Listener** (`LandscapeAdapter.java`):
```java
public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Landscape> list;
    private OnItemClickListener listener;
    
    // Interface để xử lý click
    public interface OnItemClickListener {
        void onItemClick(Landscape landscape);
    }
    
    public LandscapeAdapter(Context context, ArrayList<Landscape> list, OnItemClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
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
        
        // Click item → trigger listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(land);
            }
        });
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

**Bước 4: Activity với Click Handler** (`MainActivity.java`):
```java
public class MainActivity extends AppCompatActivity {
    private Toast currentToast;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RecyclerView recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        
        ArrayList<Landscape> list = new ArrayList<>();
        list.add(new Landscape("Hạ Long", R.drawable.img1, "Vịnh Hạ Long"));
        list.add(new Landscape("Sapa", R.drawable.img2, "Thị trấn Sapa"));
        list.add(new Landscape("Phú Quốc", R.drawable.img3, "Đảo Phú Quốc"));
        list.add(new Landscape("Đà Nẵng", R.drawable.img4, "Bà Nà Hills"));
        
        LandscapeAdapter adapter = new LandscapeAdapter(this, list, landscape -> {
            // Khi click item
            showToastSingle("📍 " + landscape.getName());
        });
        recycler.setAdapter(adapter);
    }
    
    private void showToastSingle(String message) {
        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        currentToast.show();
    }
}
```

**Bước 5: Activity Layout** (`res/layout/activity_main.xml`):
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

**Bước 6: Thêm Dependencies** (`build.gradle`):
```gradle
dependencies {
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'
}
```

**Kết quả:** ✅ Danh sách cảnh đẹp với ảnh, tên, description có thể click!

---

#### 📌 Giải Thích: RecyclerView.LayoutManager - Cách Sắp Xếp Item Là Gì?

**RecyclerView.LayoutManager** là component quyết định **cách item sắp xếp** trong RecyclerView. Không giống ListView chỉ xếp dọc, RecyclerView linh hoạt hơn.

**3 loại LayoutManager phổ biến:**

**1. LinearLayoutManager** - Xếp theo hàng (dọc hoặc ngang)
```java
// Xếp dọc (mặc định)
recyclerView.setLayoutManager(new LinearLayoutManager(this));

// Xếp ngang
recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
```

**2. GridLayoutManager** - Xếp theo lưới (giống bảng, tính năng này ListView không có!)
```java
// 2 cột
recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

// 3 cột
recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
```

**3. StaggeredGridLayoutManager** - Lưới không đều (Pinterest-style, hình ảnh khác kích thước)
```java
// 2 cột, sắp xếp dọc
recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

// 3 cột, sắp xếp ngang
recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
```

**Ví dụ:** Nếu bạn muốn hiển thị danh sách cảnh đẹp thành 2 cột, chỉ cần đổi:
```java
// Thay vì:
recyclerView.setLayoutManager(new LinearLayoutManager(this));

// Thành:
recyclerView.setLayoutManager(new GridLayoutManager(this, 2));  // ← 2 cột
```

**Khi nào dùng cái nào?**
| LayoutManager | Dùng Khi | Ví Dụ |
|---|---|---|
| **LinearLayoutManager** | Danh sách thường (dọc) | Feed mạng xã hội, comment |
| **GridLayoutManager** | Hiển thị grid đều | Ứng dụng ảnh, cửa hàng online |
| **StaggeredGridLayoutManager** | Hình khác kích thước | Pinterest, Instagram |

---

#### 🛠️ Bài 2: RecyclerView Nâng Cao (RSS Feed Application)

**Mục tiêu:** App đọc tin tức từ RSS Feed thực tế, hiển thị trong RecyclerView, click tin → mở browser

**Bước 1: Hiểu RSS Feed Structure**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<rss version="2.0">
  <channel>
    <title>Báo Công Nghệ</title>
    <item>
      <title>Tiêu đề bài viết 1</title>
      <description>Mô tả, tóm tắt bài viết</description>
      <link>https://example.com/article1</link>
      <pubDate>Thu, 28 Mar 2024 10:00:00 GMT</pubDate>
    </item>
    <item>
      <title>Tiêu đề bài viết 2</title>
      ...
    </item>
  </channel>
</rss>
```

---

**Bước 2: Model** (`Article.java`):
```java
public class Article {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    
    public Article(String title, String description, String link, String pubDate) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
    }
    
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
    public String getPubDate() { return pubDate; }
}
```

---

**Bước 3: Item Layout** (`res/layout/item_article.xml`):
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:cardCornerRadius="8dp"
    app:cardElevation="4dp"
    android:layout_margin="8dp">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="12dp">
        
        <TextView
            android:id="@+id/tvArticleTitle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:textStyle="bold"
            android:textColor="#1976D2"
            android:layout_marginBottom="8dp"
            android:maxLines="2"
            android:ellipsize="end" />
        
        <TextView
            android:id="@+id/tvArticleDesc"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="14sp"
            android:textColor="#666666"
            android:layout_marginBottom="8dp"
            android:maxLines="3"
            android:ellipsize="end" />
        
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:gravity="space-between">
            
            <TextView
                android:id="@+id/tvArticleDate"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="12sp"
                android:textColor="#999999" />
            
            <Button
                android:id="@+id/btnReadMore"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Đọc"
                android:textSize="12sp"
                android:padding="6dp" />
        </LinearLayout>
    </LinearLayout>
</androidx.cardview.widget.CardView>
```

---

**Bước 4: RSS Parser** (`RSSParser.java`):
```java
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class RSSParser {
    public static ArrayList<Article> parseRSS(String rssUrl) {
        ArrayList<Article> articles = new ArrayList<>();
        
        try {
            URL url = new URL(rssUrl);
            URLConnection conn = url.openConnection();
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(reader);
            
            String title = "", description = "", link = "", pubDate = "";
            int eventType = parser.getEventType();
            
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String tagName = parser.getName();
                    
                    if (tagName.equals("item")) {
                        title = description = link = pubDate = "";
                    } else if (tagName.equals("title")) {
                        title = parser.nextText();
                    } else if (tagName.equals("description")) {
                        description = parser.nextText();
                    } else if (tagName.equals("link")) {
                        link = parser.nextText();
                    } else if (tagName.equals("pubDate")) {
                        pubDate = parser.nextText();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (parser.getName().equals("item") && !title.isEmpty()) {
                        articles.add(new Article(title, description, link, pubDate));
                    }
                }
                eventType = parser.next();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return articles;
    }
}
```

---

**Bước 5: Adapter** (`ArticleAdapter.java`):
```java
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Article> articles;
    private OnArticleClickListener listener;
    
    public interface OnArticleClickListener {
        void onReadMoreClick(Article article);
    }
    
    public ArticleAdapter(Context context, ArrayList<Article> articles, OnArticleClickListener listener) {
        this.context = context;
        this.articles = articles;
        this.listener = listener;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
            .inflate(R.layout.item_article, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        holder.tvDate.setText(article.getPubDate());
        holder.btnReadMore.setText("Đọc →");
        
        holder.btnReadMore.setOnClickListener(v -> {
            if (listener != null) {
                listener.onReadMoreClick(article);
            }
        });
    }
    
    @Override
    public int getItemCount() { return articles.size(); }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvDate;
        Button btnReadMore;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvArticleTitle);
            tvDescription = itemView.findViewById(R.id.tvArticleDesc);
            tvDate = itemView.findViewById(R.id.tvArticleDate);
            btnReadMore = itemView.findViewById(R.id.btnReadMore);
        }
    }
}
```

---

**Bước 6: Activity - Tải RSS Feed** (`MainActivity.java`):
```java
public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private ArticleAdapter adapter;
    private ProgressBar progressBar;
    private Toast currentToast;
    
    // RSS Feed URL (ví dụ)
    private static final String RSS_URL = "https://vnexpress.net/rss/tin-tuc.rss";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recycler = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        
        recycler.setLayoutManager(new LinearLayoutManager(this));
        
        // Tải RSS trong background thread
        loadRSSFeed();
    }
    
    private void loadRSSFeed() {
        progressBar.setVisibility(View.VISIBLE);
        
        new Thread(() -> {
            ArrayList<Article> articles = RSSParser.parseRSS(RSS_URL);
            
            runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
                
                if (articles.isEmpty()) {
                    showToastSingle("❌ Không thể tải RSS!");
                } else {
                    adapter = new ArticleAdapter(this, articles, article -> {
                        openWebsite(article.getLink());
                    });
                    recycler.setAdapter(adapter);
                    showToastSingle("✅ Tải " + articles.size() + " bài viết!");
                }
            });
        }).start();
    }
    
    private void openWebsite(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    
    private void showToastSingle(String message) {
        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        currentToast.show();
    }
}
```

---

**Bước 7: Activity Layout** (`res/layout/activity_main.xml`):
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:padding="16dp"
        android:background="#E3F2FD"
        android:gravity="center_vertical">
        
        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="📰 Tin Tức Công Nghệ"
            android:textSize="20sp"
            android:textStyle="bold" />
        
        <Button
            android:id="@+id/btnRefresh"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="🔄 Làm mới" />
    </LinearLayout>
    
    <ProgressBar
        android:id="@+id/progressBar"
        android:layout_width="match_parent"
        android:layout_height="4dp"
        android:indeterminate="true"
        android:visibility="gone" />
    
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="8dp" />
</LinearLayout>
```

---

**Bước 8: Cấp Quyền** (`AndroidManifest.xml`):
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

**Kết quả:** ✅ App đọc tin tức từ RSS Feed, hiển thị trong RecyclerView, click → mở browser!

---

## 📊 Bảng Tổng Hợp: Khi nào dùng ListView vs RecyclerView?

| Tiêu chí | ListView | RecyclerView |
|---|---|---|
| **Độ khó** | ⭐⭐ Dễ | ⭐⭐⭐ Khó |
| **Hiệu năng** | Bình thường | Cao (scroll 10K+ items) |
| **Layout** | Chỉ dọc | Linear/Grid/Staggered/Custom |
| **Item có ảnh?** | Cần cache | ViewHolder built-in |
| **Scroll mượt?** | Không | Rất mượt |
| **Tái dùng code** | Khó | Dễ (Adapter pattern) |
| **Google recommend** | ❌ Cũ | ✅ Hiện đại |
| **Dự án mới** | Tránh | Luôn dùng |
| **Thời học** | 1 ngày | 3-5 ngày |

---

## 🎓 Lộ Trình Học Tập

**Bước 1:** Học ListView đơn giản (ArrayAdapter) → Test chạy
**Bước 2:** Học ListView custom + BaseAdapter → Hiểu Adapter Pattern
**Bước 3:** So sánh ListView vs RecyclerView → Hiểu tại sao RecyclerView tốt hơn
**Bước 4:** Học RecyclerView + ViewHolder → Thực hành
**Bước 5:** Thử GridLayout + StaggeredGrid → Mở rộng

---

## ✅ Bài Tập Về Nhà

### **Bài 1: Extend ListView Example**
- Thêm nút "Xoá" cho mỗi item
- Khi bấm "Xoá" → item biến mất
- Cập nhật adapter sau xoá

### **Bài 2: Extend RecyclerView Example**
- Thêm nút "Thích" (❤️) bên phải card
- Khi bấm thích → đổi màu background card
- Lưu danh sách yêu thích

### **Bài 3: So Sánh Thực Tế**
- Tạo app với 1000 items
- Thử ListView → quan sát lag/mượt
- Thử RecyclerView → so sánh
- Ghi nhận sự khác biệt

---

### **🎯 Bài 4: App Đọc Báo (Advanced Project)**

**Mục tiêu:** Tạo app đọc tin tức từ RSS Feed thực tế

**Yêu cầu:**
1. **Lấy 2-3 RSS Feed từ các trang news nổi tiếng:**
   - VNExpress: `https://vnexpress.net/rss/tin-tuc.rss`
   - Tuổi Trẻ: `https://tuoitre.vn/rss/`
   - Căn bản: `https://kenh14.vn/rss.xml`

2. **Chức năng tối thiểu:**
   - ✅ Hiển thị danh sách tin tức trong RecyclerView
   - ✅ Mỗi tin có: tiêu đề, mô tả, ngày đăng
   - ✅ Click nút "Đọc" → mở link trong browser
   - ✅ Spinner chọn chuyên mục (hoặc RSS source khác)
   - ✅ Nút "Làm mới" để reload RSS

3. **Chức năng mở rộng (nâng cao):**
   - 💫 Lưu tin yêu thích vào file/database (SharedPreferences)
   - 💫 Tìm kiếm tin theo từ khóa
   - 💫 Thêm ảnh từ RSS feed (nếu có)
   - 💫 Dùng AsyncTask hoặc RxJava thay vì luồng thô
   - 💫 Caching dữ liệu để load nhanh hơn

4. **Code Architecture:**
   ```
   src/
   ├── model/
   │   └── Article.java
   ├── adapter/
   │   └── ArticleAdapter.java
   ├── parser/
   │   └── RSSParser.java
   ├── MainActivity.java
   └── ...
   ```

5. **Testing Checklist:**
   - ✅ Chạy trên API 24+ (Android 7.0+)
   - ✅ Xử lý lỗi khi không có internet
   - ✅ Xử lý RSS feed lỗi/không hợp lệ
   - ✅ Thử nhiều RSS source khác nhau

---

## 📚 Tài Liệu Tham Khảo

- **ListView:** https://developer.android.com/reference/android/widget/ListView
- **RecyclerView:** https://developer.android.com/guide/topics/ui/layout/recyclerview
- **BaseAdapter:** https://developer.android.com/reference/android/widget/BaseAdapter

---
