package com.zhao.thread.future;

public class RealData implements Data{
	
	private String result = "";
	

	public RealData(String queryStr) {
		System.out.println("����" + queryStr + "���в�ѯ,����һ���ܺ�ʱ�Ĳ���..");
		for (int i = 0; i<20; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result += i;
		}
		System.out.println("������ϣ���ȡ���:"+result);
	}
	
	@Override
	public String getRequest() {
		return result;
	}

}
