package com.weslleyqi0.soccernews.ui.news;


import android.os.AsyncTask;

import com.weslleyqi0.soccernews.data.remote.SoccerNewsApi;
import com.weslleyqi0.soccernews.data.repository.SoccerNewsRepository;
import com.weslleyqi0.soccernews.domain.News;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    public enum State {
        DOING, DONE, ERROR;
    }

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final MutableLiveData<State> state = new MutableLiveData<>();

    public NewsViewModel() {
        this.findNews();
    }

    public void findNews() {
        state.setValue(State.DOING);
        SoccerNewsRepository.getInstance().getRemoteApi().getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(@NonNull Call<List<News>> call, @NonNull Response<List<News>> response) {
                if (response.isSuccessful()) {
                    news.setValue(response.body());
                    state.setValue(State.DONE);
                } else {
                    state.setValue(State.ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<News>> call, Throwable error) {
                error.printStackTrace();
                state.setValue(State.ERROR);
            }
        });
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }

    public MutableLiveData<List<News>> getNews() {
        return this.news;
    }

    public LiveData<State> getState() {
        return this.state;
    }
}