package com.sauzny.fts;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.blacksmith.services.ServiceHandle;
import com.sauzny.finagle.thrift.blacksmith.BlackSmithServer;
import com.twitter.finagle.ListeningServer;
import com.twitter.finagle.Thrift;
import com.twitter.finagle.ThriftMux;
import com.twitter.finagle.builder.ServerBuilder;
import com.twitter.finagle.builder.ServerConfig.Yes;
import com.twitter.finagle.thrift.RichServerParam;
import com.twitter.util.Duration;
import com.twitter.util.TimeoutException;


/**
 * *************************************************************************
 * @文件名称: FtsManager.java
 *
 * @包路径  : com.sauzny.fts
 *
 * @版权所有: Personal (C) 2015~2016
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年7月6日 - 下午4:35:56
 *
 **************************************************************************
 */
@Component
public class FtsManager{

    private static final Logger LOGGER = LoggerFactory.getLogger(FtsManager.class);
    
    // 一些配置
    @Autowired
    private FtsConfig ftsConfig;
    
    private static ListeningServer server;
    
    public FtsManager(){
        
        LOGGER.debug("FtsManager 构造器");
    }
    
    @PostConstruct
    public void start() throws TimeoutException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        LOGGER.debug("ftsConfig toString() " + ftsConfig.toString());
        
        // 配置文件获取全路径，生成实际对象
        // 这个是官网给的简单demo
        /*
        Class<?> clazz = Class.forName(ftsConfig.getServiceHandle());
        server = Thrift.server().serveIface("localhost:"+ftsConfig.getPort(), clazz.newInstance());
        */
        
        // 服务注册
        
        /*
        //这是zk服务器的地址 我这里只有一台 如果多台；分割
        String zkHosts="127.0.0.1:9000";
        String zkPath="/soa/test/finagle";
        
        String zkFullPath = String.format("zk!%s!%s!0", zkHosts, zkPath);
        server.announce(zkFullPath);
        
                        最终name的格式是：zk!myzkhost.mycompany.com:2181!/my/zk/path
        
        */ 
        
        ServerBuilder<byte[], byte[], Yes, Yes, Yes> serverBuilder = ServerBuilder.get()
                .stack(ThriftMux.server())
                .requestTimeout(new Duration(ftsConfig.getRequestTimeout() * Duration.NanosPerMillisecond()))
                .keepAlive(ftsConfig.getKeepAlive())
                .bindTo(new InetSocketAddress(ftsConfig.getPort()))
                .name(ftsConfig.getName()) // 服务注册
                ;
        
        server = ServerBuilder.safeBuild(
                new BlackSmithServer.Service(new ServiceHandle(), new RichServerParam(new TBinaryProtocol.Factory())),
                serverBuilder);
        
        
        
    }
    
    public static void stop(){
        server.close();
    } 
}
