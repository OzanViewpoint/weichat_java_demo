//package com.example.demo.controller;
//
//import com.example.demo.enums.ResultEnum;
//import com.example.demo.exception.BusinessException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
///**
// * @Author: Ozan
// * @Description:
// * @Date: Created in 17:29 2018/5/2.
// * @Modified By:
// */
//@Slf4j
//public class SavePicController {
//
//
//    @PutMapping("/upload")
//    public MarkDVo uploadImg(@RequestParam("file") MultipartFile multipartFile)  {
//        if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
//            throw new BusinessException(ResultEnum.IMG_EMPTY);
//        }
//        String contentType = multipartFile.getContentType();
//        if (!contentType.contains("")) {
//            throw new BusinessException(ResultEnum.IMG_FORMAT_ERROR);
//        }
//        String root_fileName = multipartFile.getOriginalFilename();
//        log.info("上传图片:name={},type={}", root_fileName, contentType);
//        //处理图片
//        User currentUser = userService.getCurrentUser();
//        //获取路径
//        String return_path = ImageUtil.getFilePath(currentUser);
//        String filePath = location + return_path;
//        log.info("图片保存路径={}", filePath);
//        String file_name = null;
//        try {
//            file_name = ImageUtil.saveImg(multipartFile, filePath);
//            MarkDVo markDVo = new MarkDVo();
//            markDVo.setSuccess(0);
//            if(StringUtils.isEmpty(file_name)){
//                markDVo.setSuccess(1);
//                markDVo.setMessage("上传成功");
//                markDVo.setUrl(return_path+File.separator+file_name);
//                markDVo.setCallback(callback);
//            }
//            log.info("返回值：{}",markDVo);
//            return markDVo;
//        } catch (IOException e) {
//            throw new BusinessException(ResultEnum.SAVE_IMG_ERROE);
//        }
//    }
//}
