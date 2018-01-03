package com.zhao.thread.future;

public class RealData implements Data{
	
	private String result = "";
	

	public RealData(String queryStr) {
		System.out.println("根据" + queryStr + "进行查询,这是一个很耗时的操作..");
		for (int i = 0; i<20; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result += i;
		}
		System.out.println("操作完毕，获取结果:"+result);
	}
	
	@Override
	public String getRequest() {
		return result;
	}

}
