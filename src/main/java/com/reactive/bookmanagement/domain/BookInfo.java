package com.reactive.bookmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class BookInfo {
	

	public BookInfo()
	{
		
	}
	
	
	private long bookId;
	private String title;
	private String author;
	private String ISBN;
	public BookInfo(long bookId, String title, String author, String iSBN) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		ISBN = iSBN;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
}
