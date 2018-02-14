package com.sauzny.blacksmith.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sauzny.blacksmith.utils.JVMUtils;
import com.sauzny.fts.FtsManager;

public class BlackSmithServerBoot {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackSmithServerBoot.class);

    public static void main(String[] args) {
        start();
    }

    private static void start(){
        
        String pid = JVMUtils.populateProcessID();
        
        LOGGER.debug("pid : " + pid);
        
        // 结束前执行的钩子
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                BlackSmithServerBoot.stop();
            }
        });
        
        new ClassPathXmlApplicationContext("/spring/boot.xml");
        
    }
    
    private static void status(){
        
    }
    
    private static void stop() {
        System.out.println("finagle thrift server stop");
        FtsManager.stop();
    }
}
