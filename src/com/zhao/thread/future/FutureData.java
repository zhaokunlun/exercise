package com.zhao.thread.future;

public class FutureData implements Data{
	private RealData realData;
	
	private boolean isReady = false;

	public synchronized void setRealData(RealData realData) {
		if(isReady){
			return;
		}
		this.realData = realData;
		isReady = true;
		//进行通知
		notify();
	}

	@Override
	public synchronized String getRequest() {
		//如果没装载好，程序就一直处于阻塞状态
		while(!isReady) {
			try {
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		return this.realData.getRequest();
	}
	
}
