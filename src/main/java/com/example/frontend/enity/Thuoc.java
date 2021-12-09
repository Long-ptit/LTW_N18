package com.example.frontend.enity;

import lombok.Data;

@Data
public class Thuoc {
    private long id;
//    @Min(value = 0, message = "Giá phải lớn hơn không")
    private int gia;
//    @NotBlank(message = "Không được để trống")
    private String ten;
//    @NotBlank(message = "Thiếu Tên Loại Thuốc")
    private String loaiThuoc;
}
