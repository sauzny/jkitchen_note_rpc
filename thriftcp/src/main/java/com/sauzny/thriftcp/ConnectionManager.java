package com.sauzny.thriftcp;

import org.apache.thrift.transport.TSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * *************************************************************************
 * @文件名称: ConnectionManager.java
 *
 * @包路径  : com.sauzny.thriftcp
 *
 * @版权所有: Copyright © 2016.Personal liujinxin
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月15日 - 上午11:01:52
 *
 **************************************************************************
 */
public class ConnectionManager {
	/** 日志记录器 */  
    private final Logger logger = LoggerFactory.getLogger(getClass());  
    
    /** 保存local对象 */  
    ThreadLocal<TSocket> socketThreadSafe = new ThreadLocal<TSocket>();   
  
    /** 连接提供池 */  
//    @Autowired  
    private ConnectionProvider connectionProvider;  
  
    /**
     * 	方法描述:   获取连接
     *
     *  @author  ljx 创建时间 2016年6月20日 下午6:03:52
     */
    public TSocket getSocket() {  
        TSocket socket = null;  
        try {  
            socket = connectionProvider.getConnection();  
            socketThreadSafe.set(socket);  
            socket = socketThreadSafe.get();  
        }catch (Exception e) {  
            logger.error("error ConnectionManager.invoke()", e); 
            throw new RuntimeException("error getSocket()", e);
        } finally {  
            socketThreadSafe.remove();  
        }  
        return socket;  
    }  
    
    /**
     * 	方法描述:   将连接放回连接池
     *
     *  @author  ljx 创建时间 2016年6月20日 下午6:04:07
     */
    public void closeSocket(TSocket socket){
    	connectionProvider.returnCon(socket);
    }

    /**
     * 	方法描述:   对于无效连接的处理
     *
     *  @author  ljx 创建时间 2016年6月20日 下午6:04:11
     */
    public void invalidateObject(TSocket socket){
    	if(socket != null){
    		connectionProvider.invalidateObject(socket);
    	}
    }

//	public ConnectionProvider getConnectionProvider() {
//		return connectionProvider;
//	}

	public void setConnectionProvider(ConnectionProvider connectionProvider) {
		this.connectionProvider = connectionProvider;
	}
    
}
