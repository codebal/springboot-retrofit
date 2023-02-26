package com.example.retrofit.main.external;

import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Getter
@Configuration
public class ExternalConfig {

    @Value("${api.test.url}")
    private String url;

    private static final HttpLoggingInterceptor loggingInterceptor
            = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    @Bean
    ITestApi testApi() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ITestApi.class);
    }

    @Bean
    ExternalApi externalApi(
            ITestApi testApi
    ) {
        return new ExternalApi(
                testApi,
                new RetrofitExecutor()
        );
    }
}
