package com.sauzny.blacksmith.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sauzny.finagle.thrift.blacksmith.*;
import com.sauzny.finagle.thrift.common.CommonResult;
import com.twitter.util.Future;

@Service
public class ServiceHandle implements BlackSmithServer.ServiceIface{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceHandle.class);

    @Override
    public Future<QueryResult> query(QueryParams QueryParams) {
        // TODO Auto-generated method stub
        return Future.value(new QueryResult());
    }

    @Override
    public Future<CommonResult> ping() {
        // TODO Auto-generated method stub
        
        LOGGER.info("ServiceHandle.ping()");
        
        return Future.value(new CommonResult());
    }
    
  

}
