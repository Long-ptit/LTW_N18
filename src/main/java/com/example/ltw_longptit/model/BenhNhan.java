package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class BenhNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bn")
    private int id;
    @Column
    private String ten;
    private String ngaySinh;
    private String diaChi;
    private String sdt;

}