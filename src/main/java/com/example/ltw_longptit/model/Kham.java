package com.example.ltw_longptit.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Kham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kham")
    private int id;
    @Column
    private String datein;
    @Column
    private String dateout;
    private String status;
    private String type;
    private int tongTien;
    @OneToOne
    @JoinColumn(name = "id_bs")
    BacSi bacSy;
    @OneToOne
    @JoinColumn(name = "id_bn")
    BenhNhan benhNhan;

    @OneToOne
    @JoinColumn(name = "id_benh")
    Benh benh;


}
