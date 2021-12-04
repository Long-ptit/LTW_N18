package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Thuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thuoc")
    private int id;
    @Column
    private String tenThuoc;
    @Column
    private String gia;
}
