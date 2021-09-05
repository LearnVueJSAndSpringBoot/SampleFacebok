package com.example.SampleFacebook.common.entity;

import lombok.Data;

@Data
public class ResponseBase {
    private Object data;
    private String message;
    private Integer status;
}
