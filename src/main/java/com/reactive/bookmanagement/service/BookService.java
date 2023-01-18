package com.reactive.bookmanagement.service;

import java.time.Duration;
import java.util.List;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;

import com.reactive.bookmanagement.domain.Book;
import com.reactive.bookmanagement.domain.Review;
import com.reactive.bookmanagement.exception.BookException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.Retry.RetrySignal;

@Slf4j
public class BookService {

	private BookInfoService bookInfoService;
	private ReviewService reviewService;
	public BookService(BookInfoService bookInfoService,  ReviewService reviewService)
	{
		this.bookInfoService = bookInfoService;
		this.reviewService = reviewService;
	}
	public Flux<Book> getBooks()
	{
		var allBooks = bookInfoService.getBooks();
		return allBooks.flatMap(bookInfo ->{
			Mono<List<Review>> reviews = 
			reviewService.getReviews(bookInfo.getBookId())
			.collectList();
			return reviews.map(review -> new Book(bookInfo,review));
			
		})
				.onErrorMap(throwable  -> {
					//log.error("Exception is:" + throwable);
					return new BookException("Exception occurred while fetching books");
		});
		
		//return null;
		
	}
	public Flux<Book> getBooksRetry()
	{
		var allBooks = bookInfoService.getBooks();
		return allBooks.flatMap(bookInfo ->{
			Mono<List<Review>> reviews = 
			reviewService.getReviews(bookInfo.getBookId())
			.collectList();
			return reviews.map(review -> new Book(bookInfo,review));
			
		})
				.onErrorMap(throwable  -> {
					//log.error("Exception is:" + throwable);
					return new BookException("Exception occurred while fetching books");
		}).retry(3); //retry 3 times if eception occurs after first attempt -- total 4 then 
		
		//return null;
		
	}
	public Flux<Book> getBooksRetryWhen()
	{
		var retryCat = Retry.backoff(3, Duration.ofMillis(1000)).filter(throwable -> throwable instanceof BookException).onRetryExhaustedThrow((retryBackOffSpec, retrySignal) -> Exceptions.propagate(retrySignal.failure()));
		var allBooks = bookInfoService.getBooks();
		return allBooks.flatMap(bookInfo ->{
			Mono<List<Review>> reviews = 
			reviewService.getReviews(bookInfo.getBookId())
			.collectList();
			return reviews.map(review -> new Book(bookInfo,review));
			
		})
				.onErrorMap(throwable  -> {
					//log.error("Exception is:" + throwable);
					return new BookException("Exception occurred while fetching books");
		})
				.retryWhen(retryCat);
		
		//return null;
		
	}
	
	
	public Mono<Book> getBookById(long bookId)
	{
		var book = bookInfoService.getBookBYiD(bookId); //mono
		var review = reviewService.getReviews(bookId).collectList(); //flux
		//different reactive types available ---> zip operator
		return book.zipWith(review, (b,r) -> new Book(b,r));
		
		
	}
}
