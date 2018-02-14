# blacksmith

## 一、简介

finagle-thrift-demo

使用finagle+thrift搭建的一个项目

## 二、版本

pom.xml中描述了，语言版本，框架版本。

##### thrift版本说明

finagle目前只支持thrift-0.5.0的版本，finagle-thrift的包中包含了一个Twitter自己维护的thrift.jar。

如果这个finagle-thrift中的thrift.jar不能下载的话，就需要自己【doc/将本地jar包加入本地仓库中.md】。

https://github.com/twitter/finagle/issues/133 中说一个月内就能升级到支持 thrift-0.10.0 :stuck_out_tongue_closed_eyes:

## 三、目录说明

| 包名 | 作用 |
|--------|--------|
| com.sauzny.blacksmith | 业务逻辑 |
| com.sauzny.finagle.thrift | scrooge生成的finagle-thrift文件 |
| com.sauzny.fts | finagle thrift server 启动类 |
| com.sauzny.blacksmith.test | finagle thrift client 测试类 |

## 四、启动

mvn install之后生成tar.gz的包

解压之后 运行start脚本即可，start脚本是linux上运行的脚本

如果要在windows上运行，修改脚本中-cp的参数部分。将 `:` 换成 `;`即可

## 五、其他

==关于mux==

https://twitter.github.io/finagle/guide/Protocols.html#mux