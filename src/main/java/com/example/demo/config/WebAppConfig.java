//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.MultipartConfigFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import javax.servlet.MultipartConfigElement;
//
///**
// * @Author: Ozan
// * @Description:
// * @Date: Created in 17:25 2018/5/2.
// * @Modified By:
// */
//@Configuration
//public class WebAppConfig extends WebMvcConfigurerAdapter {
//
//    /**
//     * 在配置文件中配置的文件保存路径
//     */
//    @Value("${img.location}")
//    private String location;
//
//    @Bean
//    public MultipartConfigElement multipartConfigElement(){
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //文件最大KB,MB
//        factory.setMaxFileSize("10MB");
//        //设置总上传数据总大小
//        factory.setMaxRequestSize("10MB");
//        return factory.createMultipartConfig();
//    }
//}
