package com.zhao.thread;

import java.util.Vector;

public class Tickets {
	public static void main(String[] args) {
		
		//��ʼ����Ʊ
		final Vector<String> tickets = new Vector<String>();
		
		
		for(int i = 0; i < 1000; i++) {
			tickets.add("��Ʊ" + i);
		}
		
		
		for(int i = 1; i <= 10; i++){
			new Thread("�߳�" + i) {
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
