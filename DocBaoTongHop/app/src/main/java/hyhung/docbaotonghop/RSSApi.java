package hyhung.docbaotonghop;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RSSApi {
    @GET
    Call<RssFeed> getFeed(@Url String url);
}
