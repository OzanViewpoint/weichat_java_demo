package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * @Author: Ozan
 * @Description:
 * @Date: Created in 18:00 2018/5/2.
 * @Modified By:
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
