package com.example.frontend.enity;

import lombok.Data;

@Data
public class Benh {

    private long id;

   // @NotBlank(message = "Tên bệnh không được để trống!")
    private String ten;

    private String moTa;
}
