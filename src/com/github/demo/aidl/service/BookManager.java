package com.github.demo.aidl.service;

import java.util.ArrayList;
import java.util.List;

import com.github.demo.aidl.Book;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

public class BookManager extends com.github.demo.aidl.IBookManager.Stub{
	
	private final String TAG = getClass().getSimpleName();
	private List<Book> list;
	Context mContext;
	
	public BookManager(Context context) {
		super();
		mContext = context;
		init();
		Log.d(TAG, "BookManager init");
	}
	
	private void init() {
		list = new ArrayList<>();
		for (int i=1; i < 5; i++) {
			Book book = new Book("第" + i + "本书");
			list.add(book);
		}
	}
	
	@Override
	public List<Book> getBookList() throws RemoteException {
		Log.d(TAG, "getBookList");
		return list;
	}

	@Override
	public void addBook(Book book) throws RemoteException {
		Log.d(TAG, "addBook");
		if(book != null && !TextUtils.isEmpty(book.getBookName())) {
			list.add(book);
		}
		Log.d(TAG, list.toString());
	}
}
