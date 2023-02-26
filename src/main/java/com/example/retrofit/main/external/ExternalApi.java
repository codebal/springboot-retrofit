package com.example.retrofit.main.external;


import com.example.retrofit.main.external.dto.RequestDataDto;
import com.example.retrofit.main.external.dto.ResponseDataDto;

import java.util.List;

public class ExternalApi {
    private final ITestApi testApi;
    private final RetrofitExecutor retrofitExecutor;

    public ExternalApi(ITestApi testApi, RetrofitExecutor retrofitExecutor) {
        this.testApi = testApi;
        this.retrofitExecutor = retrofitExecutor;
    }

    public ResponseDataDto get(Long userId) {
        var call = testApi.get(userId);
        return retrofitExecutor.execute(call);
    }

    public List<ResponseDataDto> getList(Long userId) {
        var call = testApi.getAll(userId);
        return retrofitExecutor.execute(call);
    }

    public ResponseDataDto post(RequestDataDto requestDataDto) {
        var call = testApi.post(requestDataDto);
        return retrofitExecutor.execute(call);
    }

    public ResponseDataDto postByForm(
            Long userId,
            String title,
            String body
    ) {
        var call = testApi.postByForm(
                userId,
                title,
                body
        );
        return retrofitExecutor.execute(call);
    }

}
