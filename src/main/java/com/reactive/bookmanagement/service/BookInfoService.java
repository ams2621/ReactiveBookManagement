package com.reactive.bookmanagement.service;

import java.util.List;

import com.reactive.bookmanagement.domain.BookInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BookInfoService {
	
	public Flux<BookInfo> getBooks()
	{
		var books = List.of(new BookInfo(1, "DragonHill","ArthurKing","12123")
				,new BookInfo(2, "SkyIsPink", "Napolean","234353"),
				new BookInfo(3, "HotGame", "Gazelo","89777"));
		return Flux.fromIterable(books);
		
	}

	public Mono<BookInfo> getBookBYiD(long bookId)
	{
		var book = new BookInfo(bookId, "DragonHill","ArthurKing","12123");
		return Mono.just(book);
		
	}
}
