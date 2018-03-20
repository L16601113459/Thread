package com.atguigu.thread1018;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * 线程   操作  资源类
 * 判断   通知  唤醒
 */
// 资源类
// queue 队列等待
class MyQueue {

	private Object obj;
	private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

	public void writeObj(Object obj) {
		rwlock.writeLock().lock();
		try {
			this.obj = obj;
			System.out.println(Thread.currentThread().getName() + "\t" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwlock.writeLock().unlock();
		}
	}
	public void readObj() {
		rwlock.readLock().lock();
		try {
			this.obj = obj;
			System.out.println(Thread.currentThread().getName() + "\t" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwlock.readLock().unlock();
		}
	}
}

/**
 * 一个进程写入，多个进程读取。
 * 
 * @author Wp
 * @date 2018.03.18
 */
public class ReadWriteLockDemo {

	public static void main(String[] args) throws InterruptedException {
		MyQueue q = new MyQueue();
		new Thread(() -> { q.writeObj("wwwwwww"); }, "Write Name").start();
		Thread.sleep(100);
		for (int i = 0; i < 100; i++) {
			new Thread(() -> { q.readObj(); }, String.valueOf(i)).start();
		}
	}

}
