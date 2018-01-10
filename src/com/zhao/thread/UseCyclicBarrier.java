package com.zhao.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseCyclicBarrier {
	
	static class Runner implements Runnable {
		private CyclicBarrier barrier;
		private String name;
		
		public Runner(CyclicBarrier barrier, String name) {
			this.barrier = barrier;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000 * (new Random()).nextInt(5));
				System.out.println(name + " ×¼±¸OK.");
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " GO.");
		}
	}
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.submit(new Thread(new Runner(cyclicBarrier, "zhangsan")));
		executor.submit(new Thread(new Runner(cyclicBarrier, "lisi")));
		executor.submit(new Thread(new Runner(cyclicBarrier, "wangwu")));
		executor.submit(new Thread(new Runner(cyclicBarrier, "zhaoliu")));
		
		executor.shutdown();
		
	}
}
