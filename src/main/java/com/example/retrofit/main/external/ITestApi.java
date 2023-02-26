package com.example.retrofit.main.external;

import com.example.retrofit.main.external.dto.RequestDataDto;
import com.example.retrofit.main.external.dto.ResponseDataDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ITestApi {

    @GET("/posts/{userId}")
    Call<ResponseDataDto> get(@Path("userId") Long userId);

    @GET("/posts")
    Call<List<ResponseDataDto>> getAll(@Query("userId") Long userId);

    @POST("/posts")
    Call<ResponseDataDto> post(@Body RequestDataDto request);

    @FormUrlEncoded
    @POST("/posts")
    Call<ResponseDataDto> postByForm(
            @Field("userId") Long userId,
            @Field("title") String title,
            @Field("body") String body
    );

}
