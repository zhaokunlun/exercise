package com.zhao.thread;

import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch{
  public static void main(String[] args){
    final CountDownLatch countDown = new CountDownLatch(2);
    
    Thread t1 = new Thread(new Runnable() {
    	public void run() {
	        try {
	          System.out.println("�����߳�t1�ȴ������̴߳������...");
	          countDown.await();
	          System.out.println("t1�̼߳���ִ��...");
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
    	}
    }, "t1");
    
    Thread t2 = new Thread(new Runnable() {
    	public void run(){
    		try{
    			System.out.println("t2�߳̽��г�ʼ������...");
    			Thread.sleep(3000L);
    			System.out.println("t2�̳߳�ʼ����ϣ�֪ͨt1�̼߳���...");
    			countDown.countDown();;
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    });
    
    Thread t3 = new Thread(new Runnable() {
    	public void run() {
	        try {
	          System.out.println("t3�߳̽��г�ʼ������...");
	          Thread.sleep(4000L);
	          System.out.println("t3�̳߳�ʼ����ϣ�֪ͨt1�̼߳���...");
	          countDown.countDown();
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
    });
    
    t1.start();
    t2.start();
    t3.start();
  }

protected void await() {
	// TODO Auto-generated method stub
	
}
}
