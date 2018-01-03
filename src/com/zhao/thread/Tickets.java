package com.zhao.thread;

import java.util.Vector;

public class Tickets {
	public static void main(String[] args) {
		
		//初始化火车票
		final Vector<String> tickets = new Vector<String>();
		
		
		for(int i = 0; i < 1000; i++) {
			tickets.add("火车票" + i);
		}
		
		
		for(int i = 1; i <= 10; i++){
			new Thread("线程" + i) {
				public void run() {
					while(true) {
						if(tickets.isEmpty()) break;
						System.out.println(Thread.currentThread().getName() + "----------" + tickets.remove(0));	
						
					}
					
				}
			}.start();
		}
	}
}
