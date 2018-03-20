package com.atguigu.thread1018;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NotSafeDemo {

	public static void main(String[] args) {
		
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
//		CopyOnWriteArraySet<String> list = new CopyOnWriteArraySet<>();
//		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 4));
				System.out.println(map);
			}, String.valueOf(i)).start();
		}

//		for (int i = 0; i < 30; i++) {
//			new Thread(() -> {
//				list.add(UUID.randomUUID().toString().substring(0, 4));
//				System.out.println(list);
//			}, String.valueOf(i)).start();
//		}
	}
	
}
