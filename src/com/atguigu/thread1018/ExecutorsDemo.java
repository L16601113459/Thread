package com.atguigu.thread1018;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo {


	public static void main(String[] args) {
//		ExecutorService service = Executors.newFixedThreadPool(5);  // 一池五线程
//		ExecutorService service = Executors.newSingleThreadExecutor();  // 一池一线程
		ExecutorService service = Executors.newCachedThreadPool();  // 一池N线程
		Future<Integer> result = null;

		try {
			for (int i = 1; i <= 15; i++) {
				result = service.submit(() -> {
					Thread.sleep(100);
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);	
				});
				System.out.println("  *******result:" + result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
		
	}

}
