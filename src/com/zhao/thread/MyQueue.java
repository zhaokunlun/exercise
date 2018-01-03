package com.zhao.thread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	
	//需要一个承接元素的集合
	private LinkedList<Object> list = new LinkedList<Object>();
	
	//需要一个计数器
	private AtomicInteger count = new AtomicInteger();
	
	//定义最大值
	private final int maxsize ;
	
	//定义最小值
	private final int minsize = 0;
	
	MyQueue (int size) {
		this.maxsize = size;
	}
	
	private final Object lock = new Object();
	
	public void put(Object obj){
		synchronized(lock){
			while(count.get() == maxsize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(obj);
			count.incrementAndGet();
			lock.notify();
			System.out.println("增加的元素为：" + obj);
		}
	}
	
	public Object take(){
		Object ret = null;
		synchronized (lock) {
			while(count.get() == minsize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ret = list.removeFirst();
			count.decrementAndGet();
			lock.notify();
			//System.out.println("移除的元素为："+ ret);
		}
		return ret;
	}
	
	private int getSize(){
		return this.count.get();
	}
	
	public static void main(String[] args) {
			final MyQueue myQueue = new MyQueue(5);
			myQueue.put("a");
			myQueue.put("b");
			myQueue.put("c");
			myQueue.put("d");
			myQueue.put("e");
			
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					myQueue.put("f");
					myQueue.put("g");
				}
			});
			
			t1.start();
			
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					Object obj1 = myQueue.take();
					System.out.println("移除的元素为：" + obj1);
					Object obj2 = myQueue.take();
					System.out.println("移除的元素为：" + obj2);
				}
			});
			
			t2.start();
			
			System.out.println(myQueue.getSize());
	}
}
