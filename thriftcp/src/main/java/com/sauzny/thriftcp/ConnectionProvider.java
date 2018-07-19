package com.sauzny.thriftcp;

import org.apache.thrift.transport.TSocket;

/**
 * *************************************************************************
 * @文件名称: ConnectionProvider.java
 *
 * @包路径  : com.sauzny.thriftcp
 *
 * @版权所有: Copyright © 2016.Personal liujinxin
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月15日 - 上午11:03:04
 *
 **************************************************************************
 */
public interface ConnectionProvider {
		/** 
	    * 取链接池中的一个链接 
	    * @return TSocket 
	    */  
	    TSocket getConnection();  
	      
	    /** 
	    * 返回链接 
	    * @param socket 
	    */  
	    void returnCon(TSocket socket);  
	    
	    /**
	     * 	方法描述:  处理无效连接
	     *
	     *  @author  ljx 创建时间 2016年6月20日 下午6:05:25
	     */
	    void invalidateObject(TSocket socket);
}
