package com.zhao.thread.executors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler{
	
	public MyRejected() {
		
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("�Զ��崦��...");
		System.out.println("��ǰ���ܾ�����Ϊ: " + r.toString());
	}
	
	
}
