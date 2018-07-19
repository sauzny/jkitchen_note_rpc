package com.sauzny.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * *************************************************************************
 * @文件名称: DemoBoot.java
 *
 * @包路径  : com.sauzny.example
 *
 * @版权所有: 
 *
 * @类描述:    测试demo启动引导类
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月20日 - 下午5:31:11
 *
 **************************************************************************
 */
public class DemoBoot {

    private static AbstractApplicationContext applicationContext;

    public static void main(String[] args) throws InterruptedException {
        applicationContext = new ClassPathXmlApplicationContext("/spring/thrift-pool-demo.xml");
        applicationContext.start();
        
        Demo1 demo1 = (Demo1) applicationContext.getBean("demo1");
        
        ExecutorService service1 = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 50; i++) {
            service1.execute(new TestSender(demo1));
        }
        service1.shutdown();
    }
   
}


