package com.atguigu.thread1018;

import java.util.concurrent.CountDownLatch;

public class SeasonTest {
	public static void main(String[] args) throws InterruptedException {
		int i = 1;
//		SeasonDemo sd = new SeasonDemo();
		CountDownLatch cdl = new CountDownLatch(4);
		while (i <= 4) {
			if (i == 1) {
				new Thread(() -> {
//					sd.spring();
					System.out.println(Thread.currentThread().getName() + "\t 过了！！");
					cdl.countDown();
				}, SeasonEnums.forEatchSeason(i).getRetMessage()).start();
			}
			i++;
			if (i == 2) {
				new Thread(() -> {
//					sd.summer();
					System.out.println(Thread.currentThread().getName() + "\t 过了！！");
					cdl.countDown();
				}, SeasonEnums.forEatchSeason(i).getRetMessage()).start();
			}
			i++;
			if (i == 3) {
				new Thread(() -> {
//					sd.autumn();
					System.out.println(Thread.currentThread().getName() + "\t 过了！！");
					cdl.countDown();
				}, SeasonEnums.forEatchSeason(i).getRetMessage()).start();
			}
			i++;
			if (i == 4) {
				new Thread(() -> {
//					sd.winter();
					System.out.println(Thread.currentThread().getName() + "\t 过了！！");
					cdl.countDown();
				}, SeasonEnums.forEatchSeason(i).getRetMessage()).start();
			}
		}
		cdl.await();
		System.out.println(Thread.currentThread().getName() + "\t 一年四季！！");

	}
}
