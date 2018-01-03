package com.zhao.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseExecutors {
	
	public static void main(String[] args) {
		ExecutorService pool1 = Executors.newFixedThreadPool(5);
		pool1.execute(null);
		
		ExecutorService pool2 = Executors.newSingleThreadExecutor(); //�����̳߳�,�����̰߳�ȫ
		pool2.execute(null);
		
		ExecutorService pool3 = Executors.newCachedThreadPool();
		pool3.execute(null);
		
		ExecutorService pool4 = Executors.newScheduledThreadPool(0);
		pool4.execute(null);
	}
}
