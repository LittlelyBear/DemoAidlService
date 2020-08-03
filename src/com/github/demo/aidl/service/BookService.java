package com.github.demo.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class BookService extends Service {
	private static final String TAG = BookService.class.getSimpleName();
	
	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind");
		return new BookManager(BookService.this);
	}

	@Override
	public void unbindService(ServiceConnection conn) {
		Log.d(TAG, "unbindService");
		super.unbindService(conn);
	}
	
	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
}
