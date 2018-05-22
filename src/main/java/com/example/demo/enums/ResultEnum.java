package com.example.demo.enums;


import lombok.Getter;

/**
 * @Author: Ozan
 * @Description:
 * @Date: Created in 18:01 2018/5/2.
 * @Modified By:
 */
@Getter
public enum ResultEnum {
    IMG_EMPTY(0, "传入的图片不存在"),

    IMG_FORMAT_ERROR(1, "图片格式错误"),

    SAVE_IMG_ERROE(2,"图片保存错误"),
    ;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
