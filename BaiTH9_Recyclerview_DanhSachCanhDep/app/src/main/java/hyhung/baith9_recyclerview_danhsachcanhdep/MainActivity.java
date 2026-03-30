package hyhung.baith9_recyclerview_danhsachcanhdep;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toast currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Landscape> list = new ArrayList<>();
        list.add(new Landscape("Hạ Long Quảng Ninh", R.drawable.img, "Vịnh Hạ Long"));
        list.add(new Landscape("Đại Nội Huế", R.drawable.img_1, "Vẻ đẹp trầm mặc, mộng mơ cùng nhiều giá trị văn hóa, lịch sử lâu đời"));
        list.add(new Landscape("Đà Nẵng", R.drawable.img_2, "Thành phố của nhiều cây cầu đẹp như cầu sông Hàn, cầu Rồng, ..."));
        list.add(new Landscape("Phú Quốc", R.drawable.img_3, "Thiên đường du lịch"));
        list.add(new Landscape("Phú Quý", R.drawable.img_4, "Phú Quý còn được gọi là cù lao Thu"));
        list.add(new Landscape("Nha Trang", R.drawable.img_5, "Vẻ đẹp tựa như tranh của địa điểm du lịch Nha Trang để lại ấn tượng khó phai trong lòng du khách"));

        LandscapeAdapter adapter = new LandscapeAdapter(this, list, landscape -> {
            // Khi click item
            showToastSingle(landscape.getName() + " is clicked");
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