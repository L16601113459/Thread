package com.atguigu.thread1018;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程 		操作 		资源类
 * 判断 		干活		通知
 * @author Wp
 * @date 2018.03.18
 */

// 3、资源类
class ShareResource{
	
	// 1 = A 2 = B 3 = C ...
	private int number = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	// 2、操作
	public void print5() {
		lock.lock();
		try {
			
			// 1. 判断
			while(number != 1) {
				c1.await();
			}
			
			// 2. 干活
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			// 3. 通知
			number = 2;
			c2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void print10() {
		lock.lock();
		try {
			
			// 1. 判断
			while(number != 2) {
				c2.await();
			}
			
			// 2. 干活
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			// 3. 通知
			number = 3;
			c3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void print15() {
		lock.lock();
		try {
			
			// 1. 判断
			while(number != 3) {
				c3.await();
			}
			
			// 2. 干活
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			// 3. 通知
			number = 1;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}

/**
 * 线程的顺序调度 AA >	BB 	> CC
 * 
 * @author Wp
 *
 */
public class ThreadOrderAccess {

	public static void main(String[] args) {
		ShareResource sr = new ShareResource();
		// 1、线程
		new Thread(() -> {
			for (int i = 1; i <= 10; i++) 
				sr.print5();
		}, "AA").start();
		new Thread(() -> {
			for (int i = 1; i <= 10; i++) 
				sr.print10();
		}, "BB").start();
		new Thread(() -> {
			for (int i = 1; i <= 10; i++) 
				sr.print15();
		}, "CC").start();
		
	}
}
