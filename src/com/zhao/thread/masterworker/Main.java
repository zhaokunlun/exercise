package com.zhao.thread.masterworker;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Master master = new Master(new Worker(), 20);
		
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			Task t = new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		master.execute();
		
		long startTime = System.currentTimeMillis();
		
		while(true) {
			if (master.isComplete()) {
				long endTime = System.currentTimeMillis() - startTime;
				int princeResult = master.getResult();
				System.out.println("最终结果：" + princeResult + ", 执行时间为" + endTime);
				break;
			}
			
		}
	}
}
