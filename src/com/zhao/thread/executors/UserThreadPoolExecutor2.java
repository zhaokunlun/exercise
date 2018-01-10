package com.zhao.thread.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadPoolExecutor2 implements Runnable{
	
	private static AtomicInteger count = new AtomicInteger(0);
	

	@Override
	public void run() {
		try {
			int temp = count.incrementAndGet();
			System.out.println("ÈÎÎñ" + temp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> queue =
				new LinkedBlockingQueue<Runnable>();
				//new ArrayBlockingQueue<Runnable>(10);
		
		ExecutorService executor = new ThreadPoolExecutor(
				5,
				10,
				120L,
				TimeUnit.SECONDS,
				queue
				);
		for (int i = 0; i < 20; i++) {
			executor.execute(new UserThreadPoolExecutor2());
		}
		Thread.sleep(1000);
		System.out.println("queue size:" + queue.size());
		Thread.sleep(2000);
				
	}
}
