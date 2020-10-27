/**
 * Copyright(C),2019-2020,CETC-32
 * Describtion 文件上传的控制器
 * Date     2020/10/1915:09
 * FileName UploadController
 * Author  xinyijie
 * Version 1.0
 * Remarks
 * History
 * <desc>   <date>   <filename>   <author>  <version>  <remarks>  <history>
 * 描述    创建日期     文件名         作者       版本号      备注     修改历史描述
 */
package com.cetc32.simplebook.controller;

import com.cetc32.simplebook.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *@Describtion 文件上传的控制器
 *@ClassName UploadController
 *@author xinyijie
 *@version 1.0
 *@date 2020/10/19 15:09
 *@Remarks
 *@History
 *<desc>   <classname>   <author>   <version>  <date>  <remarks>  <history>
 * 描述        类名         作者        版本号    创建日期    备注     修改历史描述
 */
@Controller
public class UploadController{
   private final StoreService storeService;

   /**
    * @title
    * @description
    * @author jack
    * @param
    * @return
    * @updateTime 2020/10/19 15:18
    * @throws
    */
   @Autowired
   public UploadController(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * @title
     * @description
     * @author jack
     * @param
     * @return
     * @updateTime 2020/10/19 15:27
     * @throws
     */
    @PostMapping("/")
    public String uploadHandler(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
       //用来存储文件以及执行存储的接口
       storeService.store(file);
       redirectAttributes.addFlashAttribute("message","you successfully uploaded!");
       //存储文件
       return "redirect:/";
    }

    @GetMapping("/files/{filename:.+}")
    public @ResponseBody
    ResponseEntity<Resource> reclaimHandler(@PathVariable String filename) {
        Resource file = storeService.retrieve(filename);
        ResponseEntity<Resource> responseEntity = ResponseEntity.ok().header(
                HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\\" +
                        file.getFilename() + "\\").body(file);
        return responseEntity;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

}


