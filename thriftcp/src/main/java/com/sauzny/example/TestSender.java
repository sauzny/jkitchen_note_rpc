package com.sauzny.example;

/**
 * *************************************************************************
 * @文件名称: TestSender.java
 *
 * @包路径  : com.sauzny.example
 *
 * @版权所有: 
 *
 * @类描述:    测试发送 单个线程
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月21日 - 上午11:36:24
 *
 **************************************************************************
 */
public class TestSender extends Thread {

    private Demo1 demo1;
    
    public TestSender(Demo1 demo1){
        this.demo1 = demo1;
    }
    
    @Override
    public void run() {
        
        demo1.bellBangServerPing();
        
        super.run();
    }
}