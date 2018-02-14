package com.sauzny.fts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.Data;

@Data
public class FtsConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(FtsConfig.class);
    
    public FtsConfig(){
        LOGGER.debug("ftsFutureHandle 构造器");
    }
    
    //服务名字
    private String name = "";
    //本serverServer.ServiceIface实现类，全路径
    private String serviceHandle = "";
    //启动服务的端口
    private Integer port = 0;
    //服务端处理超时时间
    private Long requestTimeout = 3000L;
    //服务版本号
    private String version = "";
    //保持长连接
    private Boolean keepAlive = true; 
   
}
