package huhung.demoesp32_android;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView txtTemp, txtHumi, txtSmoke, txtStatus; // Thêm txtStatus để báo Online/Offline
    DatabaseReference mRef;
    long lastTimeReceived = 0; // Lưu mốc thời gian cuối cùng nhận dữ liệu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTemp = findViewById(R.id.txtTemp);
        txtHumi = findViewById(R.id.txtHumi);
        txtSmoke = findViewById(R.id.txtSmoke);
        txtStatus = findViewById(R.id.txtStatus);

        mRef = FirebaseDatabase.getInstance().getReference("sensor");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String t = snapshot.child("data1").exists() ? snapshot.child("data1").getValue().toString() : "--";
                    String h = snapshot.child("data2").exists() ? snapshot.child("data2").getValue().toString() : "--";
                    String s = snapshot.child("data3").exists() ? snapshot.child("data3").getValue().toString() : "--";

                    txtTemp.setText("Nhiệt độ: " + t + " °C");
                    txtHumi.setText("Độ ẩm: " + h + " %");
                    txtSmoke.setText("Mức khói: " + s);

                    // CÁCH 1: Cập nhật trạng thái Online
                    txtStatus.setText("Trạng thái: Đang hoạt động");
                    txtStatus.setTextColor(Color.GREEN);
                    lastTimeReceived = System.currentTimeMillis();
                } else {
                    // Nếu node "sensor" chưa tồn tại trên Firebase
                    txtStatus.setText("Trạng thái: Thiết bị chưa khởi tạo");
                    txtStatus.setTextColor(Color.GRAY);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        // Tạo một luồng chạy ngầm để kiểm tra Offline mỗi 2 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Nếu quá 10 giây (10000ms) không nhận được tin nhắn mới từ ESP32
                if (System.currentTimeMillis() - lastTimeReceived > 10000 && lastTimeReceived != 0) {
                    txtStatus.setText("Trạng thái: Mất kết nối (Offline)");
                    txtStatus.setTextColor(Color.RED);
                }
                new Handler().postDelayed(this, 2000);
            }
        }, 2000);
    }
}