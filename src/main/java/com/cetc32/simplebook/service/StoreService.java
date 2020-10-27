/**
 * Copyright(C),2019-2020,CETC-32
 * Describtion 存储服务的接口, 用来存储, 删除, 调用用户传入的文件
 * Date     2020/10/1910:57
 * FileName StoreService
 * Author  xinyijie
 * Version 1.0
 * Remarks
 * History
 * <desc>   <date>   <filename>   <author>  <version>  <remarks>  <history>
 * 描述    创建日期     文件名         作者       版本号      备注     修改历史描述
 */
package com.cetc32.simplebook.service;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 *@Describtion 存储服务的接口, 用来存储, 删除, 调用用户传入的文件
 *@InterfaceName StoreService
 *@author xinyijie
 *@version 1.0
 *@date 2020/10/19 10:57
 *@Remarks
 *@History
 *<desc>   <interfacename>   <author>   <version>  <date>  <remarks>  <history>
 * 描述         接口名           作者        版本号    创建日期    备注     修改历史描述
 */
@Service
public interface StoreService {
/**
 * @title store
 * @description 储存用户传入的文件
 * @param file
 * @returns
 * @updateTime 2020/10/19 11:20
 * @throws
 */
    void store(MultipartFile file);

    /**
     * @title init
     * @description 初始化用户存储用户文件的文件夹
     * @param
     * @returns
     * @updateTime 2020/10/19 11:21
     * @throws
     */
    void init();

    /**
     * @title retrive
     * @description  根据文件名返回用户存储的文件
     * @param filename 文件名
     * @returns 文件路径
     * @updateTime 2020/10/19 11:22
     * @throws
     */
    UrlResource retrieve(String filename);

    /**
     * @title retrievePath
     * @description 根据用户名返回用户存储的文件的路径
     * @param filename
     * @returns
     * @updateTime 2020/10/19 11:24
     * @throws
     */
    Path retrievePath(String filename);

    /**
     * @title retrieveAllpath
     * @description 返回用户传入所有文件的文件名，以Stream的形式
     * @param
     * @returns
     * @updateTime 2020/10/19 11:25
     * @throws
     */
    Stream<Path> retrieveAllpath();

    /**
     * @title deleteAll
     * @description 删除所有用户传入的文件
     * @param
     * @returns
     * @updateTime 2020/10/19 11:25
     * @throws
     */
    void deleteAll();

}
