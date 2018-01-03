package com.zhao.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UseConcurrentHashMap {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<String, Object>();
		chm.put("a", "a");
		chm.put("b", "b");
		chm.put("c", "c");
		chm.putIfAbsent("c", "ccc");
		for (Map.Entry<String, Object> me : chm.entrySet()) {
			System.out.println("key:" + me.getKey() + ",value:" + me.getValue());
		}
	}
}
