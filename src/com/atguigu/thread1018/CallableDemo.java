package com.atguigu.thread1018;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

	public Integer call() throws Exception {
		System.out.println("*********  call() ******");
		Thread.sleep(2000);
		return 1018;
	}

}

/**
 * @Description: Callable接口获得多线程
 * @author Wp
 * @date 2018.3.18
 */
public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> ft = new FutureTask<>(new MyThread());
		new Thread( ft , "AA").start();
		
		System.out.println(Thread.currentThread().getName() + "***********主线程");
		
		Integer result01 = ft.get();
		System.out.println(result01);
	}

}
