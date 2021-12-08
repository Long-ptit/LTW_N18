package com.example.frontend.enity;

import lombok.Data;

@Data
public class Kham {

    private int id;
    private String datein;
    private String dateout;
    private String status;
    private String type;
    private int tongTien;
    BacSi bacSy;
    BenhNhan benhNhan;
    Benh benh;

}
