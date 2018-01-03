package com.zhao.thread.future;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		FutureClient client = new FutureClient();
		Data data = client.request("name");
		

		System.out.println("发送请求成功!时间：" + System.currentTimeMillis());
		for(int i = 0; i < 100; i++) {
			i += i;
		}
		
		
		System.out.println("结果为："+data.getRequest()); 
		
		
	}
}
