package com.example.retrofit;

import com.example.retrofit.main.external.ExternalApi;
import com.example.retrofit.main.external.dto.RequestDataDto;
import com.example.retrofit.main.external.dto.ResponseDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RestClientTest
@Import(TestConfig.class)
class RetrofitApplicationTests {

	@Autowired
	ExternalApi externalApi;

	@Test
	void contextLoads() {
		assertThat(true)
				.isTrue();
	}

	@Test
	void sut_get() {
		ResponseDataDto data = externalApi.get(50L);
		assertThat(data)
				.isNotNull();
	}

	@Test
	void sut_getList() {
		var list = externalApi.getList(1L);
		assertThat(list)
				.isInstanceOf(List.class);
	}

	@Test
	void sut_post() {
		var request = new RequestDataDto(
				100L,
				"new title",
				"new body"
		);
		var response = externalApi.post(request);
		assertThat(response)
				.usingRecursiveComparison()
				.ignoringFields("id")
				.isEqualTo(request);
	}

	@Test
	void sut_postByForm() {
		var request = new RequestDataDto(
				100L,
				"new title",
				"new body"
		);
		var response = externalApi.postByForm(
				request.getUserId(),
				request.getTitle(),
				request.getBody()
		);

		assertThat(response)
				.usingRecursiveComparison()
				.ignoringFields("id")
				.isEqualTo(request);
	}


}
