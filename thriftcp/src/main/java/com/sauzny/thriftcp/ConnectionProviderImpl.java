package com.sauzny.thriftcp;

import lombok.Data;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * *************************************************************************
 * @文件名称: ConnectionProviderImpl.java
 *
 * @包路径  : com.sauzny.thriftcp
 *
 * @版权所有: Copyright © 2016.Personal liujinxin
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月15日 - 上午11:02:54
 *
 **************************************************************************
 */
@Data
public class ConnectionProviderImpl implements ConnectionProvider, InitializingBean, DisposableBean{  
    

	    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionProviderImpl.class);
		
	    /** 服务的IP地址 */  
	    private String serviceIP;  
	    /** 服务的端口 */  
	    private int servicePort;  
	    /** 连接超时配置 */  
	    private int conTimeOut;  
	    
	    /** 可以从缓存池中分配对象的最大数量 */
	    
	    private int maxTotal = GenericObjectPoolConfig.DEFAULT_MAX_TOTAL;
	   
	    /** 缓存池中最大空闲对象数量 */  
	    private int maxIdle = GenericObjectPoolConfig.DEFAULT_MAX_IDLE;  
	    /** 缓存池中最小空闲对象数量 */  
	    private int minIdle = GenericObjectPoolConfig.DEFAULT_MIN_IDLE;  
	    /** 阻塞的最大数量 */  
	    private long maxWaitMillis = GenericObjectPoolConfig.DEFAULT_MAX_WAIT_MILLIS;  
	  
	    /** 从缓存池中分配对象，是否执行PoolableObjectFactory.validateObject方法 */  
	    private boolean testOnBorrow = GenericObjectPoolConfig.DEFAULT_TEST_ON_BORROW;  
	    private boolean testOnReturn = GenericObjectPoolConfig.DEFAULT_TEST_ON_RETURN;  
	    private boolean testWhileIdle = GenericObjectPoolConfig.DEFAULT_TEST_WHILE_IDLE;  
	  
	    /** 连接对象缓存池 */  
	    private ObjectPool<TTransport> objectPool = null;  
	  
	    /**
	     * 	方法描述:  从连接池中获取连接
	     *
	     *	@see com.sauzny.thriftcp.ConnectionProvider#getConnection()
	     *  @author : ljx 创建时间 2016年6月20日 下午6:09:11
	     */
	    @Override  
	    public TSocket getConnection() {  
	        try {  
	            // 从对象池取对象  
	            TSocket socket = (TSocket) objectPool.borrowObject();  
	            LOGGER.debug("borrow socket:{} NumActive:{} NumIdle:{}", socket.hashCode(), objectPool.getNumActive(), objectPool.getNumIdle());
	            
	            return socket;  
	        } catch (Exception e) {  
	            throw new RuntimeException("error getConnection()", e);  
	        }  
	    }  
	  
	    /**
	     * 	方法描述:  回收连接，将连接放回连接池中
	     *
	     *	@see com.sauzny.thriftcp.ConnectionProvider#returnCon(org.apache.thrift.transport.TSocket)
	     *  @author : ljx 创建时间 2016年6月20日 下午6:09:27
	     */
	    @Override  
	    public void returnCon(TSocket socket) {  
	        try {  
	            // 将对象放回对象池  
	            objectPool.returnObject(socket);  
	        } catch (Exception e) {  
	            throw new RuntimeException("error returnCon()", e);  
	        }  
	    }  
	    
	    /**
	     * 	方法描述:  处理失效连接
	     *
	     *	@see com.sauzny.thriftcp.ConnectionProvider#invalidateObject(org.apache.thrift.transport.TSocket)
	     *  @author : ljx 创建时间 2016年6月20日 下午6:10:42
	     */
	    @Override  
	    public void invalidateObject(TSocket socket) {  
	        try {  
	            //  从连接池中释放连接，释放资源
	            objectPool.invalidateObject(socket);  
	        } catch (Exception e) {
	        	LOGGER.error("error invalidateObject()",e);
//	            throw new RuntimeException("error invalidateObject()", e);  
	        }  
	    }  
	  
	    /**
	     * 	方法描述:  连接池对象销毁时执行的方法，关闭连接池，断开连接池中的所有连接，释放资源
	     *
	     *	@see org.springframework.beans.factory.DisposableBean#destroy()
	     *  @author : ljx 创建时间 2016年6月20日 下午6:05:58
	     */
	    @Override  
	    public void destroy() throws Exception {  
	        try {  
	            objectPool.close();  
	        } catch (Exception e) {  
	            throw new RuntimeException("erorr destroy()", e);  
	        }  
	    }  
	  
	    /**
	     * 	方法描述:  本类的对象获取配置文件中属性（Properties） 之后执行，设置 连接池对象 所需要的属性值 
	     *
	     *	@see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	     *  @author : ljx 创建时间 2016年6月20日 下午6:06:40
	     */
	    @Override  
	    public void afterPropertiesSet() throws Exception {  
	    	 // 设置factory  
	        ThriftPoolableObjectFactory thriftPoolableObjectFactory = new ThriftPoolableObjectFactory(serviceIP, servicePort, conTimeOut);  
	        AbandonedConfig abandonedConfig = new AbandonedConfig();
	        abandonedConfig.setRemoveAbandonedTimeout(1);
	        // 对象池  
	        objectPool = new GenericObjectPool<TTransport>(thriftPoolableObjectFactory);  
	        //  
	        ((GenericObjectPool<TTransport>) objectPool).setMaxTotal(maxTotal);;  
	        ((GenericObjectPool<TTransport>) objectPool).setMaxIdle(maxIdle);  
	        ((GenericObjectPool<TTransport>) objectPool).setMinIdle(minIdle);  
	        ((GenericObjectPool<TTransport>) objectPool).setMaxWaitMillis(maxWaitMillis);  
	        ((GenericObjectPool<TTransport>) objectPool).setTestOnBorrow(testOnBorrow);  
	        ((GenericObjectPool<TTransport>) objectPool).setTestOnReturn(testOnReturn);  
	        ((GenericObjectPool<TTransport>) objectPool).setTestWhileIdle(testWhileIdle); 
	        ((GenericObjectPool<TTransport>) objectPool).setAbandonedConfig(abandonedConfig);
	        
//	        ((GenericObjectPool<TTransport>) objectPool).setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_BLOCK);  
	    }


	  
	 
}
