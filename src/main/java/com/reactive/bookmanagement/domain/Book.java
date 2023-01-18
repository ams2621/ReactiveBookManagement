package com.reactive.bookmanagement.domain;

import java.util.List;

public class Book {

	private BookInfo bookInfo;
	private List<Review> reviews;

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Book() {

	}

	public Book(BookInfo bookInfo, List<Review> reviews) {
		super();
		this.bookInfo = bookInfo;
		this.reviews = reviews;
	}
}
