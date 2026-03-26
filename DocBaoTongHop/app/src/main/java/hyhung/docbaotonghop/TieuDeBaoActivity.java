package hyhung.docbaotonghop;

import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TieuDeBaoActivity extends AppCompatActivity {
    private static final String TAG = "TieuDeBaoActivity";
    private static final String RSS_URL = "https://vnexpress.net/rss/the-thao.rss";

    private RecyclerView recyclerView;
    private ListItemAdapter listItemAdapter;
    private ArrayList<Item> dsBaiBao;
    private RSSFetcher rssFetcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tieu_de_bao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initRecyclerView();
        rssFetcher = new RSSFetcher();
        fetchNews();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.revyvlerView);
        dsBaiBao = new ArrayList<>();
        listItemAdapter = new ListItemAdapter(this, dsBaiBao);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listItemAdapter);
    }

    private void fetchNews() {
        Toast.makeText(this, "Đang tải tin tức...", Toast.LENGTH_SHORT).show();
        rssFetcher.fetchRSSFeed(RSS_URL, new RSSFetcher.FetchCallback() {
            @Override
            public void onSuccess(ArrayList<Item> items) {
                Log.d(TAG, "Đã fetch được " + items.size() + " bài viết");
                dsBaiBao.clear();
                dsBaiBao.addAll(items);
                listItemAdapter.notifyDataSetChanged();
                Toast.makeText(TieuDeBaoActivity.this, "Tải xong " + items.size() + " bài viết", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, "Lỗi: " + errorMessage);
                Toast.makeText(TieuDeBaoActivity.this, "Lỗi: " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}