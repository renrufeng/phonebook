package com.java.controller;

import com.java.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 图像上传
 *
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-23 19:35
 */
@RestController
@RequestMapping("/")
public class ImagController {
    @Value("${imageFilePath}")
    private String imageFilePath;

    @RequestMapping("/uploadImage")
    public Map<String, Object> uploadImage(MultipartFile file) throws Exception {

        Map<String, Object> map = new HashMap<>();

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();//获取文件名
            String suffixName = fileName.substring(fileName.lastIndexOf('.'));//获取后缀
            String newFileName = DateUtil.getCurrentDateStr() + suffixName;//新文件名
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));
            map.put("code", 0);
            map.put("msg", "上传成功");
            Map<String, Object> map2 = new HashMap<>();
            map2.put("title", newFileName);
            map2.put("src", "/image/" + newFileName);
            map.put("data", map2);
        }

        return map;

    }


}