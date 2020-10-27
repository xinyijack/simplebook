/**
 * Copyright(C),2019-2020,CETC-32
 * Describtion 文件存储出现错误，该类将抛出Exception异常
 * Date     2020/10/1913:17
 * FileName StorageException
 * Author  xinyijie
 * Version 1.0
 * Remarks
 * History
 * <desc>   <date>   <filename>   <author>  <version>  <remarks>  <history>
 * 描述    创建日期     文件名         作者       版本号      备注     修改历史描述
 */
package com.cetc32.simplebook.service;

import java.util.stream.Stream;

/**
 *@Describtion 文件存储出现错误，该类将抛出Exception异常
 *@ClassName StorageException
 *@author xinyijie
 *@version 1.0
 *@date 2020/10/19 13:17
 *@Remarks
 *@History
 *<desc>   <classname>   <author>   <version>  <date>  <remarks>  <history>
 * 描述        类名         作者        版本号    创建日期    备注     修改历史描述
 */

public class StorageException extends RuntimeException {
    private static final long serialVersionUTD = 1L;

    public StorageException(String message) {
        super(message);
    }
    public StorageException(String message, Throwable cause){
        super(message, cause);
    }
}
