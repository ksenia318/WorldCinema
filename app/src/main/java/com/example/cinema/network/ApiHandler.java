package com.example.cinema.network;
import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.cinema.network.models.DataManager;
import com.example.cinema.network.service.ApiService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {
    private static ApiHandler mInstance;
    private static final String BASE_URL = "http://cinema.areas.su";
    private Retrofit retrofit;

    public ApiHandler(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient getOkHttp(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + DataManager.token)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }).build();
        return client;
    }
    //будет получать экземпляр нашего ApiHandler
    public static ApiHandler getInstance(){
        if(mInstance == null)
            mInstance = new ApiHandler();
        return mInstance;
    }
    //класс у которого вызываем запросы к API
    public ApiService getService(){
        return retrofit.create(ApiService.class);
    }
}
