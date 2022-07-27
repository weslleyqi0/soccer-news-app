package com.weslleyqi0.soccernews.data.remote;

import com.weslleyqi0.soccernews.domain.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
