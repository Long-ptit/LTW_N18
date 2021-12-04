package com.example.ltw_longptit.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table
public class Benh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_benh")
    private int id;
    @Column
    private String name;
}
