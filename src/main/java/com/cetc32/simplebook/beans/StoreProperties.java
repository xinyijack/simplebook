/**
 * Copyright(C),2019-2020,CETC-32
 * Describtion 属性存储类
 * Date     2020/10/1912:14
 * FileName StoreProperties
 * Author  xinyijie
 * Version 1.0
 * Remarks
 * History
 * <desc>   <date>   <filename>   <author>  <version>  <remarks>  <history>
 * 描述    创建日期     文件名         作者       版本号      备注     修改历史描述
 */
package com.cetc32.simplebook.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *@Describtion 属性存储类
 * @ConfigurationProperties 注解
 *  著有该注解的类，类中的变量可以通过外接的。properties文件进行配置。
 *@ClassName StoreProperties
 *@author xinyijie
 *@version 1.0
 *@date 2020/10/19 12:14
 *@Remarks
 *@History
 *<desc>   <classname>   <author>   <version>  <date>  <remarks>  <history>
 * 描述        类名         作者        版本号    创建日期    备注     修改历史描述
 */
@PropertySource(value = {"classpath:store.properties"})
@Component
@ConfigurationProperties(prefix = "store")
public class StoreProperties {
    private String location;

    @Override
    public String toString() {
        return "StoreProperties{" +
                "location='" + location + '\'' +
                '}';
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

}
