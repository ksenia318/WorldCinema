package com.example.cinema.network.service;

import com.example.cinema.network.models.LoginBody;
import com.example.cinema.network.models.LoginResponse;
import com.example.cinema.network.models.MoviesResponse;
import com.example.cinema.network.models.RegisterBody;
import com.example.cinema.network.models.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("/auth/login")
    Call<LoginResponse> doLogin(@Body LoginBody loginBody);

    @POST("/auth/register")
    Call<Void> doRegister(@Body RegisterBody registerBody);

    @GET("/movies")
    Call<List<MoviesResponse>> getMovies(@Query("filter") String filter);

    @GET("/user")
    Call<List<UserResponse>> getUserInfo();
}
