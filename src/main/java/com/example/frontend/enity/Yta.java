package com.example.frontend.enity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class Yta {
        private int id;
        private int ytaThamNien;
        @NotBlank(message = "fuck you bitch")
        private String ytaCMT;
        private String ytaTen;
        private String ytaSDT;
        private String ytaDiaChi;
        private String ytaNgaySinh;

        public String toString() {
                String res = "Ten: "+ ytaTen + " DiaChi: " + ytaDiaChi + "cmt:"+ ytaCMT + "Ns"+ ytaNgaySinh + "std" + ytaSDT + "tn" +ytaThamNien;
                return res;
        }
}
