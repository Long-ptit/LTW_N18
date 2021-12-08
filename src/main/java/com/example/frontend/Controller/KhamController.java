package com.example.frontend.Controller;

import com.example.frontend.enity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/kham")
public class KhamController {
    RestTemplate rest = new RestTemplate();
    String url = "http://localhost:8080";
    @GetMapping
    public String getDsKham(Model model) {
        List<Kham> listKham = Arrays.asList(rest.getForObject(url+"/kham",Kham[].class));
        model.addAttribute("listKham", listKham);
        return "kham/dsKham";
    }

    @GetMapping("/create")
    public String addKham(Model model) {
        List<Yta> listYta = Arrays.asList(rest.getForObject(url + "/yta", Yta[].class));
        List<BacSi> listBacsi = Arrays.asList(rest.getForObject(url + "/bacsi",BacSi[].class));
        List<Benh> listBenh = Arrays.asList(rest.getForObject(url + "/benh/list-benh",Benh[].class));
        List<BenhNhan> listBenhNhan = Arrays.asList(rest.getForObject(url + "/benhnhan",BenhNhan[].class));
        List<Thuoc> listThuoc = Arrays.asList(rest.getForObject(url+"/thuoc/list-thuoc", Thuoc[].class));
        Kham kham = new Kham();
        model.addAttribute("kham", kham);
        model.addAttribute("listYta", listYta);
        model.addAttribute("listBacsi", listBacsi);
        model.addAttribute("listBenh", listBenh);
        model.addAttribute("listBenhNhan", listBenhNhan);
        model.addAttribute("listThuoc", listThuoc);
        return "kham/addKham";
    }

    @PostMapping("/save")
    public String saveKham(Kham kham,@RequestParam("idYta") String idYta,@RequestParam("idThuoc") String idThuoc, @RequestParam("soLuong") String soLuong) {
        System.out.println("Yta id" + idYta);
        System.out.println("id Thuoc" + idThuoc);
        System.out.println("so luong tuong ung" + soLuong);
        List<Thuoc> listThuoc = new ArrayList<>();
        idThuoc = idThuoc.substring(0, idThuoc.length()-2);

        for(String i : idThuoc.split(",")) {
            listThuoc.add(rest.getForObject(url+"/thuoc/get-thuoc/{id}",Thuoc.class, Integer.valueOf(i)));
        }

        System.out.println("thuoc id " + idThuoc);//a,x,x

        List<Yta> ytaList = new ArrayList<>();
        for(String i: idYta.split(",") ) {
            Yta yTa = rest.getForObject(url+ "/yta/{id}", Yta.class, i);
            ytaList.add(yTa);
        }
        Kham a = rest.postForObject(url+"/kham", kham, Kham.class);
        for(int i = 0; i< ytaList.size() ; i++) {
            HoTro hoTro = new HoTro();
            Yta yta1 = ytaList.get(i);
            hoTro.setKham(a);
            hoTro.setYta(yta1);
            rest.postForObject(url + "/hotro",hoTro , HoTro.class);
        }
        System.out.println(a.getId());
        DonThuoc donThuoc = new DonThuoc();
        donThuoc.setKham(a);
        donThuoc.setTongTien(50000);
        DonThuoc d = rest.postForObject(url + "/donthuoc", donThuoc, DonThuoc.class);

        for(int i=0 ; i<listThuoc.size() ; i++) {
            ThuocSuDung thuocSuDung = new ThuocSuDung();
            thuocSuDung.setThuoc(listThuoc.get(i));
            thuocSuDung.setDonThuoc(d);
            thuocSuDung.setSoLuong(5);
            rest.postForObject(url + "/thuocsd", thuocSuDung, ThuocSuDung.class);
        }


        return "redirect:/kham/";
    }
}
