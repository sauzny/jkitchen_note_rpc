package com.sauzny.example;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.thrift.bellbang.BellBangServer;
import com.sauzny.thrift.common.CommonResult;
import com.sauzny.thriftcp.ConnectionManager;

/**
 * *************************************************************************
 * @文件名称: Demo1.java
 *
 * @包路径  : com.sauzny.example
 *
 * @版权所有: 
 *
 * @类描述:    连接池的测试
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月20日 - 下午5:15:40
 *
 **************************************************************************
 */
@Component
public class Demo1 {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Demo1.class);
    
    @Autowired
    private ConnectionManager connectionManager;
    
    /**
     * 	方法描述:   测试ping接口
     *
     *  @author  ljx 创建时间 2016年6月20日 下午5:29:11
     */
    public void bellBangServerPing(){
        
        CommonResult commonResult = new CommonResult();
        
        TSocket socket = null;
        long costTime = -1L;
        
        try {
            
            socket = connectionManager.getSocket();
            TProtocol protocol = new TBinaryProtocol(socket);
            BellBangServer.Client client = new BellBangServer.Client(protocol);

            long start = System.currentTimeMillis();
            
            commonResult = client.ping();
            
            costTime = System.currentTimeMillis() - start;
            
            LOGGER.info("commonResult : {} costTime : {}", commonResult, costTime);
            
        } catch (Exception e) {
            
            connectionManager.invalidateObject(socket);
            
        } finally {
            
            if (socket != null) {
                connectionManager.closeSocket(socket);
            }
        }
    }
}
