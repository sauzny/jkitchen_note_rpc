package com.sauzny.blacksmith.test;

import org.apache.thrift.protocol.TBinaryProtocol;

import com.sauzny.finagle.thrift.blacksmith.BlackSmithServer;
import com.sauzny.finagle.thrift.common.CommonResult;
import com.twitter.finagle.Service;
import com.twitter.finagle.Thrift;
import com.twitter.finagle.ThriftMux;
import com.twitter.finagle.builder.ClientBuilder;
import com.twitter.finagle.builder.ClientConfig.Yes;
import com.twitter.finagle.thrift.RichClientParam;
import com.twitter.finagle.thrift.ThriftClientRequest;
import com.twitter.util.Await;
import com.twitter.util.Duration;
import com.twitter.util.Function;
import com.twitter.util.Future;

import scala.runtime.BoxedUnit;

public class APITest {

    public static void main(String[] args) {
        
        final String ip_port = "127.0.0.1:50002";
        
        /*
        String zkHosts="127.0.0.1:9000";
        String zkPath="/soa/test/finagle";
        String zkFullPath = String.format("zk!%s!%s", zkHosts, zkPath);
        ServiceFactory<ThriftClientRequest, byte[]> factory = Thrift.newClient(zkFullPath);
        
         ServiceToClient  这个方法过时了
        BlackSmithServer.ServiceIface helloClient = new BlackSmithServer.ServiceToClient(factory.toService(), new TBinaryProtocol.Factory());
        */
        
        /*
         
         newIface 这个方法过时了…… 这还是官方github中给的例子
         
        BlackSmithServer.ServiceIface client = Thrift.client().newIface("localhost:50002", BlackSmithServer.ServiceIface.class);
        Future<CommonResult> response = client.ping().onSuccess(new Function<String, BoxedUnit>() {
          @Override
          public BoxedUnit apply(String response) {
            System.out.println("Received response: " + response);
            return null;
          }
        });

        Await.result(response);
        */
        
        // https://twitter.github.io/finagle/docs/com/twitter/finagle/builder/ClientBuilder.html
        // 明确写出了ClientBuilder中的参数作用
        // 有时间我再详细看看
        
        // 新的api  看上去比原来的好一些，只是好了一些
        ClientBuilder<ThriftClientRequest, byte[], Yes, Yes, Yes> clientBuilder = ClientBuilder.get()
                //.name("zk!myzkhost.mycompany.com:2181!/my/zk/path") //这个参数是服务注册发现时使用的，参考server启动时候的配置
                .hosts(ip_port) 
                .stack(ThriftMux.client())
                .keepAlive(true)
                .hostConnectionLimit(1)
                .hostConnectionCoresize(1)
                // 这三个方法应该是废弃了……
                //.hostConnectionIdleTime( new Duration(300L * Duration.NanosPerSecond()))
                //.hostConnectionMaxIdleTime( new Duration(300L * Duration.NanosPerSecond()))
                //.hostConnectionMaxLifeTime( new Duration(30L * Duration.NanosPerSecond()))
                .tcpConnectTimeout(new Duration(2L * Duration.NanosPerSecond()));

        System.out.println(System.currentTimeMillis());
        Service<ThriftClientRequest, byte[]> service = ClientBuilder.safeBuild(clientBuilder);
        System.out.println(System.currentTimeMillis());
        
        service.isAvailable();
        
        // 新的api使用  RichClientParam 这个参数

        BlackSmithServer.ServiceIface client = new BlackSmithServer.ServiceToClient(service, new RichClientParam(new TBinaryProtocol.Factory()));
        
        try {
             /*
             Future<CommonResult> responseFuture = Await.ready(client.ping()); 
             responseFuture.onSuccess();
             responseFuture.onFailure();
             */
            
            
            /* 这种Lambda表达式的写法是错的  可能是Scala2.11的原因，使用Scala2.12也许可以
            responseFuture.onSuccess(response -> {
                System.out.println(String.format("response status: %s, response string: %s",
                        response.status().toString(), response.contentString()));
                return BoxedUnit.UNIT;
            });
            */
            
            Future<CommonResult> response = client.ping().onSuccess(new Function<CommonResult, BoxedUnit>() {
                @Override
                public BoxedUnit apply(CommonResult response) {
                  System.out.println("Received response: " + response);
                  return null;
                }
              });
            
            CommonResult commonResult = Await.result(response, new Duration(Duration.NanosPerMinute()));
            
            System.out.println(commonResult);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
