package com.zhao.thread.future;

public class FutureClient {
	public Data request(final String queryStr) {
		//1 ����Ҫһ���������Data�ӿڵ�ʵ���ࣩ �ȷ��ظ���������Ŀͻ��ˡ������������Ѿ����յ������������������
		final FutureData futureData = new FutureData();
		//2 ����һ���µ��̣߳�ȥ������ʵ�����ݣ����ݸ�����������
		new Thread(){
			public void run() {
				//3 ����µ��߳̿���������ȥ������ʵ����Ȼ�󴫵ݸ��������
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
		}.start();
		
		return futureData;
	}
}
