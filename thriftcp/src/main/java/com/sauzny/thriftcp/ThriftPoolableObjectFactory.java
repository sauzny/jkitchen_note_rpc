package com.sauzny.thriftcp;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * *************************************************************************
 * @文件名称: ThriftPoolableObjectFactory.java
 *
 * @包路径  : com.sauzny.thriftcp
 *
 * @版权所有: Copyright © 2016.Personal liujinxin
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月15日 - 上午11:02:46
 *
 **************************************************************************
 */
public class ThriftPoolableObjectFactory extends BasePooledObjectFactory<TTransport> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThriftPoolableObjectFactory.class);

	/** 服务的IP */
	private String serviceIP;
	/** 服务的端口 */
	private int servicePort;
	/** 超时设置 */
	private int timeOut;

	public ThriftPoolableObjectFactory(String serviceIP, int servicePort, int timeOut) {
		super();
		this.serviceIP = serviceIP;
		this.servicePort = servicePort;
		this.timeOut = timeOut;
	}

	/**
	 * 	方法描述:  创建单个连接
	 *
	 *	@see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 *  @author : ljx 创建时间 2016年6月20日 下午6:20:47
	 */
	@Override
	public TTransport create() throws Exception {
	    
		try {
			TTransport transport = new TSocket(this.serviceIP, this.servicePort, this.timeOut);
			transport.open();
	        LOGGER.debug("create() 创建对象结-- hashCode : " + transport.hashCode());
			return transport;
		} catch (Exception e) {
			LOGGER.error("error ThriftPoolableObjectFactory()", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 	方法描述:  创建连接池，包装方法，将单个连接打包在连接池中
	 *
	 *	@see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 *  @author : ljx 创建时间 2016年6月20日 下午6:21:11
	 */
	@Override
	public PooledObject<TTransport> wrap(TTransport obj) {
		return new DefaultPooledObject<TTransport>(obj);
	}

	/**
	 * 	方法描述:  销毁一个连接池中的连接
	 *
	 *	@see org.apache.commons.pool2.BasePooledObjectFactory#destroyObject(org.apache.commons.pool2.PooledObject)
	 *  @author : ljx 创建时间 2016年6月20日 下午6:31:20
	 */
	@Override
	public void destroyObject(PooledObject<TTransport> p) throws Exception {
		TTransport tTransport = p.getObject();
		if (tTransport.isOpen()) {
			tTransport.close();
		}
	}

	/**
	 * 	方法描述:  验证连接池中的连接的可用性
	 *
	 *	@see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
	 *  @author : ljx 创建时间 2016年6月20日 下午6:23:07
	 */
	@Override
	public boolean validateObject(PooledObject<TTransport> p) {
		
	    Boolean isAvailable = false;
	    
	    TTransport tTransport = p.getObject();
		
	    try {  
            if (tTransport instanceof TSocket) {  
                TSocket thriftSocket = (TSocket) tTransport;  
                if (thriftSocket.isOpen()) {  
                    isAvailable =  true;  
                }  
            } 
        } catch (Exception e) {  
            return isAvailable;  
        }  
        LOGGER.debug("验证池中的对象 -- hashCode : " + tTransport.hashCode()+ " 当前对象状态：" + isAvailable);
	    
	    return isAvailable;  
	}

	/**
	 * 	方法描述:  激活连接池中的连接
	 *
	 *	@see org.apache.commons.pool2.BasePooledObjectFactory#activateObject(org.apache.commons.pool2.PooledObject)
	 *  @author : ljx 创建时间 2016年6月20日 下午6:23:38
	 */
	@Override
	public void activateObject(PooledObject<TTransport> p) throws Exception {
		TTransport tTransport = p.getObject();
		if(!tTransport.isOpen()){
			tTransport.open();
		}
//		TTransport tTransport = p.getObject();
	}

	
	/**
	 * 	方法描述:  钝化连接池中的连接
	 *
	 *	@see org.apache.commons.pool2.BasePooledObjectFactory#passivateObject(org.apache.commons.pool2.PooledObject)
	 *  @author : ljx 创建时间 2016年6月20日 下午6:31:50
	 */
	@Override
	public void passivateObject(PooledObject<TTransport> p) throws Exception {
//		TTransport tTransport = p.getObject();
	}
}