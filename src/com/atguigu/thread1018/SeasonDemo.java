package com.atguigu.thread1018;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SeasonDemo {

	private int number = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	private Condition c4 = lock.newCondition();

	public void spring() {
		lock.lock();
		try {
			while (number != 1) {
				c1.await();
			}
			System.out.println(Thread.currentThread().getName() + "\t 到了！！!");
			number = 2;
			c2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void summer() {
		lock.lock();
		try {
			while (number != 2) {
				c2.await();
			}
			System.out.println(Thread.currentThread().getName() + "\t 到了！！!");
			number = 3;
			c3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void autumn() {
		lock.lock();
		try {
			while (number != 3) {
				c3.await();
			}
			System.out.println(Thread.currentThread().getName() + "\t 到了！！!");
			number = 4;
			c4.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void winter() {
		lock.lock();
		try {
			while (number != 4) {
				c4.await();
			}
			System.out.println(Thread.currentThread().getName() + "\t 到了！！!");
			number = 1;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
