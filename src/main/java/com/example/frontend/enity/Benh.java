package com.example.frontend.enity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Benh {

    private long id;
    @NotBlank(message = "heolo")
    private String ten;
    @NotBlank(message = "heolo")
    private String moTa;
}
