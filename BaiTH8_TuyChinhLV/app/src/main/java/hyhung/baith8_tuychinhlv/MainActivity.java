package hyhung.baith8_tuychinhlv;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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

        // Lấy reference của ListView từ layout
        ListView listViewApp = findViewById(R.id.lvApp);

        // Chuẩn bị dữ liệu - Danh sách 9 món ăn
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Bánh Xèo", 25000, "Bánh tráng nước cốn chiên", R.drawable.banhxeo));
        foodList.add(new Food("Bún Riêu", 30000, "Cua, tôm cua nấu canh chua", R.drawable.bunrieu));
        foodList.add(new Food("Gỏi Cuốn", 15000, "Rau sống cuốn bánh tráng", R.drawable.goicuon));
        foodList.add(new Food("Thịt Kho Tộ", 40000, "Thịt heo kho nước cốt dừa", R.drawable.thitkhoto));
        foodList.add(new Food("Bún Bò Huế", 35000, "Bún với thịt bò nước dùng", R.drawable.bunbohue));
        foodList.add(new Food("Rau Muống Xào Tỏi", 20000, "Rau muống tươi xào tỏi thơm", R.drawable.raumuongxaotoi));
        foodList.add(new Food("Bánh Cuốn", 18000, "Bánh tráng cuốn thịt heo", R.drawable.banhcuon));
        foodList.add(new Food("Bò Lúc Lắc", 45000, "Bò xào nóng với dưa leo", R.drawable.boluclac));
        foodList.add(new Food("Gỏi Xoài", 25000, "Xoài xanh gỏi chua cay", R.drawable.goixoai));

        // Tạo Custom Adapter
        FoodAdapter adapter = new FoodAdapter(this, foodList);

        // Set adapter cho ListView
        listViewApp.setAdapter(adapter);

        // Xử lý click item
        listViewApp.setOnItemClickListener((parent, view, position, id) -> {
            Food food = foodList.get(position);
            String message = "Bạn chọn: " + food.getTenMonAn() +
                    "\nGiá: " + String.format("%,d VNĐ", food.getGiaBan());
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });

        // Xử lý long click (nhấn giữ)
        listViewApp.setOnItemLongClickListener((parent, view, position, id) -> {
            Food food = foodList.get(position);
            Toast.makeText(MainActivity.this,
                    "Xoá: " + food.getTenMonAn() + "?",
                    Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}