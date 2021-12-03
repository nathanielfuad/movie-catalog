package com.bca.service.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.bca.service.models.CatalogItem;
import com.bca.service.models.Movie;
import com.bca.service.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatologResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		// get all rated movie IDs

		UserRating userRating = restTemplate.getForObject("http://localhost:8082/ratingData/users/" + userId,
				UserRating.class);

		return userRating.getRatings().stream().map(rating -> {
			// for each movie ID, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
//			Movie movie = webClientBuilder.build().get().uri("http://localhost:8081/movies/" + rating.getMovieId())
//					.retrieve().bodyToMono(Movie.class).block();
			// put them all together
			return new CatalogItem(movie.getName(), "Deskripsi Nathaniel Fuad", rating.getRating());
		}).collect(Collectors.toList());

	}

	// Using WebClient

//	@GetMapping("/{userId}")
//	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//		
//		// get all rated movie IDs
//		UserRating userRating = restTemplate.getForObject("http://localhost:8082/ratingsData/users/" + userId,
//				UserRating.class);
//
//		return userRating.getRatings().stream().map(rating -> {
//			// for each movie ID, call movie info service and get details
//			Movie movie = webClientBuilder.build().get().uri("http://localhost:8081/movies/" + rating.getMovieId())
//					.retrieve().bodyToMono(Movie.class).block();
//			// put them all together
//			return new CatalogItem(movie.getName(), "Deskripsi Nathaniel Fuad", rating.getRating());
//		}).collect(Collectors.toList());
//
//	}

}
