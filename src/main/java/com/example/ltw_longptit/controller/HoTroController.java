package com.example.ltw_longptit.controller;

import com.example.ltw_longptit.model.HoTro;
import com.example.ltw_longptit.model.Kham;
import com.example.ltw_longptit.model.LuongYTa;
import com.example.ltw_longptit.model.Yta;
import com.example.ltw_longptit.repo.HoTroRepository;
import com.example.ltw_longptit.repo.YtaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/hotro", produces = "application/json")
@CrossOrigin(origins = "*")
public class HoTroController {
    @Autowired
    private HoTroRepository hoTroRepository;

    @Autowired
    private YtaRepository ytaRepo;

    @GetMapping()
    public Iterable<HoTro> getAllHoTro() {
        return hoTroRepository.findAll();
    }

    @GetMapping("/{id}")
    public HoTro getHoTroById(@PathVariable("id") int id) {
        Optional<HoTro> optionalHoTro = hoTroRepository.findById(id);
        if (optionalHoTro.isPresent()) {
            return optionalHoTro.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    public HoTro postHoTro(@RequestBody HoTro hoTro) {
        return hoTroRepository.save(hoTro);
    }

    @PutMapping("/{id}")
    public HoTro putHoTro(@RequestBody HoTro hoTro) {
        return hoTroRepository.save(hoTro);
    }

    @DeleteMapping("/{id}")
    public void deleteHoTro(@PathVariable("id") Integer id) {
        try {
            hoTroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @GetMapping("dsYtaFromKhamId/{id}")
    public Iterable<HoTro> getYtaFromKhamId(@PathVariable("id") String id) {
        return hoTroRepository.getYTaTheoIdKham(id);
    }

    @GetMapping("tk/yta/{keyword}/{id}")
    public  Iterable<HoTro> getHoTroByIdYta(@PathVariable("keyword") String keyword, @PathVariable("id") String id) {
        return hoTroRepository.getHoTroTheoIdYTa(keyword, id);
    }

//2021-12
    public LuongYTa getLuongYTa(String keyword, String id) {
            int soLan = hoTroRepository.getSoLanHoTro(keyword, id);
            Yta  yta = ytaRepo.getById(Integer.parseInt(id));
            LuongYTa luongYTa = new LuongYTa();
            luongYTa.setLuongCoBan(5000000);
            int luongCongThem = soLan*200000;
            //set lại thằng y tá
            int luongTong = luongCongThem + 5000000;
            luongYTa.setLuongCongThem(luongCongThem);
            luongYTa.setLuongTong(luongTong);
            luongYTa.setSoLan(soLan);
            luongYTa.setId(yta.getId());
            luongYTa.setYtaCMT(yta.getYtaCMT());
            luongYTa.setYtaDiaChi(yta.getYtaDiaChi());
            luongYTa.setYtaThamNien(yta.getYtaThamNien());
            luongYTa.setYtaSDT(yta.getYtaSDT());
            luongYTa.setYtaTen(yta.getYtaTen());
            luongYTa.setYtaNgaySinh(yta.getYtaNgaySinh());
            return luongYTa;
    }

    @GetMapping("tl/yta/{keyword}")
    public List<LuongYTa> getListLuong(@PathVariable("keyword") String keyword) {
        List<Yta> ytaFull = ytaRepo.findAll();
        ArrayList<LuongYTa> listLuongYTa = new ArrayList<>();

        for(int i=0 ; i<ytaFull.size() ; i++)
        {
            listLuongYTa.add(getLuongYTa(keyword, String.valueOf(ytaFull.get(i).getId())));
        }

        return listLuongYTa;
    }

    @DeleteMapping("/delete/hotro-theo-id-kham/{id}")
    public void deleteHoTroTheoIdKham(@PathVariable("id") String id) {
        hoTroRepository.deleteHoTroTheoIdKham(id);
    }



}
