package com.example.SampleFacebook.form;

import lombok.Data;

@Data
public class SearchForm {
    private String text;
    private Integer pageIndex;
    private Integer pageSize;
}
