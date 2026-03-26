package hyhung.docbaotonghop;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import java.util.ArrayList;

public class RSSFetcher {
    private static final String TAG = "RSSFetcher";
    private static final String BASE_URL = "https://vnexpress.net/";
    private final Retrofit retrofit;
    private final RSSApi apiService;

    public interface FetchCallback {
        void onSuccess(ArrayList<Item> items);

        void onError(String errorMessage);
    }

    public RSSFetcher() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        apiService = retrofit.create(RSSApi.class);
    }

    public void fetchRSSFeed(String feedUrl, FetchCallback callback) {
        Call<RssFeed> call = apiService.getFeed(feedUrl);
        call.enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        ArrayList<Item> items = parseRssFeed(response.body());
                        callback.onSuccess(items);
                    } else {
                        callback.onError("Response không thành công");
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Lỗi parse RSS: " + e.getMessage(), e);
                    callback.onError("Lỗi: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Log.e(TAG, "Lỗi fetch RSS: " + t.getMessage(), t);
                callback.onError("Lỗi kết nối: " + t.getMessage());
            }
        });
    }

    private ArrayList<Item> parseRssFeed(RssFeed rssFeed) {
        ArrayList<Item> items = new ArrayList<>();
        if (rssFeed.getChannel() != null && rssFeed.getChannel().getItems() != null) {
            for (RssItem rssItem : rssFeed.getChannel().getItems()) {
                items.add(new Item(
                        rssItem.getTitle(),
                        rssItem.getImageUrl(), // Image URL từ HTML description
                        rssItem.getPubDate(),
                        rssItem.getLink() // Link đến bài báo
                ));
            }
        }
        return items;
    }
}
