package com.example.frontend.enity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BenhNhan {
    private int id;
    @NotBlank(message = "ao ma lazada")
    private String ten;
    @NotBlank(message = "ao ma lazada")
    private String ngaySinh;
    @NotBlank(message = "ao ma lazada")
    private String diaChi;
    @NotBlank(message = "ao ma lazada")
    private String sdt;
}
