package com.example.retrofit.main.external;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitExecutor {

    public <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException(response.raw().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
