package com.reactive.bookmanagement.domain;

import lombok.Data;

@Data
public class Review {

	
	private long reviewId;
	private String comments;
	private long bookId;
	private double ratings;
	
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public Review()
	{
		
	}
	
	public Review(long reviewId, String comments, long bookId, double ratings) {
		super();
		this.reviewId = reviewId;
		this.comments = comments;
		this.bookId = bookId;
		this.ratings = ratings;
	}
}
