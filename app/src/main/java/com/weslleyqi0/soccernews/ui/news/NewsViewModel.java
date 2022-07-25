package com.weslleyqi0.soccernews.ui.news;


import com.weslleyqi0.soccernews.domain.News;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {
    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News(0, "Title 0", "", "", "", false));
        news.add(new News(1, "Title 1", "", "", "", false));
        news.add(new News(2, "Title 2", "", "", "", false));
        news.add(new News(3, "Title 3", "", "", "", false));
        this.news.setValue(news);
    }

    public MutableLiveData<List<News>> getNews() {
        return this.news;
    }
}