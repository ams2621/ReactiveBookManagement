package com.reactive.bookmanagement.service;

import java.util.List;

import com.reactive.bookmanagement.domain.Review;

import reactor.core.publisher.Flux;

public class ReviewService {
	
	public Flux<Review> getReviews(long bookId)
	{
		var reviewList = List.of(
				new Review(1,"Great Book",bookId, 9.2 ),
				new Review(2, "Bad read", bookId, 5.5 )
				);
		
		return Flux.fromIterable(reviewList);
				
	}

}
