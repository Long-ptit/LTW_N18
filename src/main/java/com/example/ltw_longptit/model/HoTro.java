package com.example.ltw_longptit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class HoTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_yta")
    Yta yta;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_kham")
    Kham kham;

}
