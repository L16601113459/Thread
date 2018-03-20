package com.atguigu.thread1018;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaPhoreDemo {

	public static void main(String[] args) {
		// 模拟三个车位
		Semaphore sp = new Semaphore(3);
		
		// 模拟六辆车
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				try {
					sp.acquire();
					System.out.println(Thread.currentThread().getName()+"\t  抢到车位");
					TimeUnit.SECONDS.sleep(new Random().nextInt(8));
					System.out.println(Thread.currentThread().getName()+"\t  离开车位");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					sp.release();
				}

			}, String.valueOf(i)).start();
		}
	}
	
}
