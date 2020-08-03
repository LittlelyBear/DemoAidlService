package com.github.demo.aidl;

import android.os.Parcelable;
import android.os.Parcel;

public class Book implements Parcelable{
	private String bookName;
	
	public Book() {
		bookName = null;
	}
	
	public Book(String name) {
		bookName = name;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String name) {
		bookName = name;
	}

	public static final Creator<Book> CREATOR = new Creator<Book>() {
		
		@Override
		public Book[] newArray(int size) {
			return new Book[size];
		}
		
		@Override
		public Book createFromParcel(Parcel source) {
			Book book = new Book();
			book.setBookName(source.readString());
			return book;
		}
	};
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(bookName);
	}
	
	public void readFromParcel(Parcel desc) {
		bookName = desc.readString();
	}
	
	@Override
	public String toString() {
		return "bookName = " + bookName;
	}
}
