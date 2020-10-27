/**
 * Copyright(C),2019-2020,CETC-32
 * Describtion 接口的具体实现
 * Date     2020/10/1911:31
 * FileName StoreFileService
 * Author  xinyijie
 * Version 1.0
 * Remarks
 * History
 * <desc>   <date>   <filename>   <author>  <version>  <remarks>  <history>
 * 描述    创建日期     文件名         作者       版本号      备注     修改历史描述
 */
package com.cetc32.simplebook.service;

import com.cetc32.simplebook.beans.StoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 *@Describtion 接口的具体实现
 *@ClassName StoreFileService
 *@author xinyijie
 *@version 1.0
 *@date 2020/10/19 11:31
 *@Remarks
 *@History
 *<desc>   <classname>   <author>   <version>  <date>  <remarks>  <history>
 * 描述        类名         作者        版本号    创建日期    备注     修改历史描述
 */
@Service
public class StoreFileService implements StoreService {
    private final Logger logger = LoggerFactory.getLogger(StoreFileService.class);
    private final Path rootDirectory;//存储用户名的文件夹位置

    /**
     * @title
     * @description   传入了一个参数：storeProperties，故名思意就是“存储属性”，一切关于存储
     *       有关的属性，比如用户文件存储在哪里，一个文件夹里最多储存多少文件等，这些
     *       属性都存储在storeProperties中。
     *       使用@Autowired让IoC容器自动注入你的StoreProperties依赖。
     * @param storeProperties
     * @returns
     * @updateTime 2020/10/19 13:25
     * @throws
     */
    @Autowired
    public StoreFileService(StoreProperties storeProperties) {
        rootDirectory = Paths.get(storeProperties.getLocation());
    }

    /**
     * @title 
     * @description 先使用File API中的 .getInputStream() 获得传入文件的输入流（InputStream），
     *       再调用Files API 中的 .copy(InputStream, target, copyType) 来将传入的文件
     *       写进目标路径中, target就是我们的目标路径, 详情可查阅相关文档。
     * @author jack 
     * @param  file 多文件对象类
     * @return 
     * @updateTime 2020/10/19 14:37
     * @throws 
     */
    @Override
    public void store(MultipartFile file) {
        String filename = file.getOriginalFilename();
        logger.info("filename");
        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, this.rootDirectory.resolve(filename), StandardCopyOption.REPLACE_EXISTING);}
            catch(IOException e) {
                throw new StorageException("Failed to store file");
            }
        }

        /**
         * @title init
         * @description  使用File API中的.mkdir()创建一个目录, 目录是由rootDirectory指定的。
         * @author jack
         * @updateTime 2020/10/19 14:40
         * @throws 
         */
    @Override
    public void init() {
        File file = new File(rootDirectory.toString());
        file.mkdir();
    }

    /**
     * @title
     * @description
     * @author jack
     * @param
     * @return
     * @updateTime 2020/10/19 14:50
     * @throws
     */
    @Override
    public UrlResource retrieve(String filename) {
        Path path = retrievePath(filename);
        UrlResource resource;
        try {
            resource = new UrlResource(path.toUri());
            return resource;
        } catch (MalformedURLException e) {
            throw new StorageException("Failed to store file");
        }
    }

    /**
     * @title
     * @description
     * @author jack
     * @param
     * @return
     * @updateTime 2020/10/19 14:51
     * @throws
     */
    @Override
    public Path retrievePath(String filename) {
        return rootDirectory.resolve(filename);
    }

    /**
     * @title
     * @description
     * @author jack
     * @param
     * @return
     * @updateTime 2020/10/19 15:03
     * @throws
     */
    @Override
    public Stream<Path> retrieveAllpath() {
        try {
            return Files.walk(rootDirectory, 1).filter(path -> !path.equals(this.rootDirectory)).map(rootDirectory::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }

    /**
     * @title
     * @description 
     * @author jack 
     * @param 
     * @return 
     * @updateTime 2020/10/19 15:05
     * @throws 
     */
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootDirectory.toFile());
    }
    
}
    
    
