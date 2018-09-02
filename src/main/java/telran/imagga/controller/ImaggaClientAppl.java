package telran.imagga.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.imagga.model.ResponseDto;

public class ImaggaClientAppl {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "secret code");
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		String url = "https://api.imagga.com/v1/colors";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("url",
				"https://images8.alphacoders.com/414/414960.jpg");
		ResponseEntity<ResponseDto> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,
				requestEntity, ResponseDto.class);
		displayColors(response.getBody());

	}

	private static void displayColors(ResponseDto results) {
		if (results.getResults().length == 0) {
			System.out.println("Wrong url image");
		} else {
			System.out.println("color\t\tparent color\tpercent");
			System.out.println("----------------------------------------------");
			//Arrays.stream(results.getResults()[0].getInfo().getImage_colors()).forEach(System.out::println);
			results.getResults()[0].getInfo().getListOfCollors()
				.stream().forEach(System.out::println);
		}

	}

}
