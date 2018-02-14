package com.sauzny.blacksmith.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * *************************************************************************
 * @文件名称: JVMUtils.java
 *
 * @包路径  : com.sauzny.blacksmith.utils
 *
 * @版权所有: 
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年6月30日 - 下午6:51:19
 *
 **************************************************************************
 */
public final class JVMUtils {
    
    private JVMUtils () {}
    
    public static String populateProcessID(){   
        /*
         * runtimeMXBean.getName()取得的值包括两个部分：PID和hostname，两者用@连接。
         */
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return runtimeMXBean.getName().split("@")[0];
    }
}
