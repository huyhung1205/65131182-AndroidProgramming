package hyhung.baith7_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView view;

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
        // Lấy đối tượng có id=listView trong xml
        view = findViewById(R.id.listView);
        ArrayList<String> ds = new ArrayList<>();
        ds.add("Xi măng");
        ds.add("Gạch");
        ds.add("Đá ốp lát");
        ds.add("Ống nhựa");
        ds.add("Sơn chống thấm");
        // Tạo adapter để truyền data
        ArrayAdapter<String> adapterlist = new ArrayAdapter<String>(
                this,R.layout.item,R.id.item,ds);
        view.setAdapter(adapterlist);
        view.setOnItemClickListener((AdapterView<?> adapterView, View view, int position, long id) -> {
            String ten = ds.get(position);

            Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + ten, Toast.LENGTH_SHORT).show();
        });
    }
}