package hyhung.baith7_listview_danhsachtinhthanh;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // B1: Lấy reference của ListView từ layout
        ListView listView = findViewById(R.id.lvDstt);

        // B2: Tạo ArrayList chứa danh sách tỉnh thành
        ArrayList<String> dsTinhThanh = new ArrayList<>();
        dsTinhThanh.add("An Giang");
        dsTinhThanh.add("Bà Rịa - Vũng Tàu");
        dsTinhThanh.add("Bắc Giang");
        dsTinhThanh.add("Bắc Kạn");
        dsTinhThanh.add("Bạc Liêu");
        dsTinhThanh.add("Bắc Ninh");
        dsTinhThanh.add("Bến Tre");
        dsTinhThanh.add("Bình Định");
        dsTinhThanh.add("Bình Dương");
        dsTinhThanh.add("Bình Phước");
        dsTinhThanh.add("Bình Thuận");
        dsTinhThanh.add("Cà Mau");
        dsTinhThanh.add("Cao Bằng");
        dsTinhThanh.add("Cần Thơ");
        dsTinhThanh.add("Đà Nẵng");
        dsTinhThanh.add("Đắk Lắk");
        dsTinhThanh.add("Đắk Nông");
        dsTinhThanh.add("Điện Biên");
        dsTinhThanh.add("Đồng Nai");
        dsTinhThanh.add("Đồng Tháp");
        dsTinhThanh.add("Gia Lai");
        dsTinhThanh.add("Hà Giang");
        dsTinhThanh.add("Hà Nam");
        dsTinhThanh.add("Hà Nội");
        dsTinhThanh.add("Hà Tĩnh");
        dsTinhThanh.add("Hải Dương");
        dsTinhThanh.add("Hải Phòng");
        dsTinhThanh.add("Hậu Giang");
        dsTinhThanh.add("Hòa Bình");
        dsTinhThanh.add("Hưng Yên");
        dsTinhThanh.add("Khánh Hòa");
        dsTinhThanh.add("Kiên Giang");
        dsTinhThanh.add("Kon Tum");
        dsTinhThanh.add("Lai Châu");
        dsTinhThanh.add("Lâm Đồng");
        dsTinhThanh.add("Lạng Sơn");
        dsTinhThanh.add("Lào Cai");
        dsTinhThanh.add("Long An");
        dsTinhThanh.add("Nam Định");
        dsTinhThanh.add("Nghệ An");
        dsTinhThanh.add("Ninh Bình");
        dsTinhThanh.add("Ninh Thuận");
        dsTinhThanh.add("Phú Thọ");
        dsTinhThanh.add("Phú Yên");
        dsTinhThanh.add("Quảng Bình");
        dsTinhThanh.add("Quảng Nam");
        dsTinhThanh.add("Quảng Ngãi");
        dsTinhThanh.add("Quảng Ninh");
        dsTinhThanh.add("Quảng Trị");
        dsTinhThanh.add("Sóc Trăng");
        dsTinhThanh.add("Sơn La");
        dsTinhThanh.add("Tây Ninh");
        dsTinhThanh.add("Thái Bình");
        dsTinhThanh.add("Thái Nguyên");
        dsTinhThanh.add("Thanh Hóa");
        dsTinhThanh.add("Thừa Thiên - Huế");
        dsTinhThanh.add("Tiền Giang");
        dsTinhThanh.add("TP Hồ Chí Minh");
        dsTinhThanh.add("Trà Vinh");
        dsTinhThanh.add("Tuyên Quang");
        dsTinhThanh.add("Vĩnh Long");
        dsTinhThanh.add("Vĩnh Phúc");
        dsTinhThanh.add("Yên Bái");

        // B3: Tạo ArrayAdapter để kết nối dữ liệu với ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsTinhThanh);

        // B4: Gắn adapter vào ListView
        listView.setAdapter(adapter);

        // B5: Xử lý sự kiện click item
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String tinhThanh = dsTinhThanh.get(position);
            Toast.makeText(this, tinhThanh + " is clicked", Toast.LENGTH_SHORT).show();
        });
    }
}