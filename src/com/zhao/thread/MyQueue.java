package com.zhao.thread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	
	//��Ҫһ���н�Ԫ�صļ���
	private LinkedList<Object> list = new LinkedList<Object>();
	
	//��Ҫһ��������
	private AtomicInteger count = new AtomicInteger();
	
	//�������ֵ
	private final int maxsize ;
	
	//������Сֵ
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
			System.out.println("���ӵ�Ԫ��Ϊ��" + obj);
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
			//System.out.println("�Ƴ���Ԫ��Ϊ��"+ ret);
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
					System.out.println("�Ƴ���Ԫ��Ϊ��" + obj1);
					Object obj2 = myQueue.take();
					System.out.println("�Ƴ���Ԫ��Ϊ��" + obj2);
				}
			});
			
			t2.start();
			
			System.out.println(myQueue.getSize());
	}
}
