package com.example.frontend.enity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BacSi  {
    private int id;
    private int bacsyThamNien;
    @NotBlank(message = "fuck you")
    private String bacsyCMT;
    @NotBlank(message = "fuck you")
    private String bacsyTen;
    @NotBlank(message = "fuck you")
    private String bacsySDT;
    @NotBlank(message = "fuck you")
    private String bacsyDiaChi;
    @NotBlank(message = "fuck you")
    private String bacsyNgaySinh;
    @NotBlank(message = "fuck you")
    private String bacsyBacNghe;
    @NotBlank(message = "fuck you")
    private String bacsyTrinhDoDaoTao;
    @NotBlank(message = "fuck you")
    private String bacsyChuyenMon;
}
